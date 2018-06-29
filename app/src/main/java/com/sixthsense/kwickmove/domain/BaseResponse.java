package com.sixthsense.kwickmove.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public abstract class BaseResponse implements Serializable {

    @SerializedName("isValid")
    @Expose
    public boolean isValid;
    @SerializedName("error")
    @Expose
    public String error;

    public boolean isValid() {
        return isValid;
    }

    public String getError() {
        return error;
    }
}
