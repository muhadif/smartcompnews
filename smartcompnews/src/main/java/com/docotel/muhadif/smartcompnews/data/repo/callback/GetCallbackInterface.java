package com.docotel.muhadif.smartcompnews.data.repo.callback;

public interface GetCallbackInterface {
    void onGetDataSucess(int requestId, String rawData);
    void onGetDataFailure(String message);
}
