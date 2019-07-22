package com.docotel.muhadif.smartcompnews.data.repo;


import android.content.Context;
import android.util.Log;

import com.docotel.muhadif.smartcompnews.BuildConfig;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    static ApiInterface createRequesst(Context context, String apiKey, String certificateKey) {
        return getClient(context, apiKey, certificateKey).create(ApiInterface.class);
    }

    private static Retrofit getClient(Context context, String apiKey, String certificateKey) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConfig.BASE_URL)
                    .client(getOkHttpClient(context, apiKey, certificateKey))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient(Context context, String apiKey, String certificateKey) {
        if(okHttpClient == null) {
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(context.getCacheDir(), cacheSize);
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(1);
            dispatcher.setMaxRequestsPerHost(1);
            OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .cache(cache)
                    .dispatcher(dispatcher);

            okHttpBuilder.addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("api-key", apiKey).build();
                return chain.proceed(request);
            });

            if(BuildConfig.DEBUG){
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okHttpBuilder.addInterceptor(interceptor);
            }

            CertificatePinner certificatePinner = new CertificatePinner.Builder()
                    .add("*.smartcom.id", certificateKey)
                    .build();
//
//            okHttpBuilder.addInterceptor(chain -> {
//                Request request = chain.request().newBuilder().addHeader("api-key", JNIHelper.getApi()).build();
//                return chain.proceed(request);
//            });

            okHttpClient = okHttpBuilder
                    .certificatePinner(certificatePinner)
                    .build();
        }
        return okHttpClient;
    }
}
