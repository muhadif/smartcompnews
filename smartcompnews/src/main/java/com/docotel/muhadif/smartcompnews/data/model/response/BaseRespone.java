
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.Expose;

public class BaseRespone {

    @Expose
    private String data;
    @Expose
    private String message;
    @Expose
    private Long status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
