package com.docotel.muhadif.third.helper;


import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.docotel.muhadif.smartcompnews.R;

public class GlideUtil {

    public static RequestOptions options = new RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_picture)
            .error(R.drawable.ic_picture)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.NORMAL);
}
