package com.litziy.kawalcovid.ui.hospital;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalResponseModel {

    @SerializedName("http_response")
    @Expose
    private Integer httpResponse;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<HospitalData> data = null;

    public Integer getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(Integer httpResponse) {
        this.httpResponse = httpResponse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HospitalData> getData() {
        return data;
    }

    public void setData(List<HospitalData> data) {
        this.data = data;
    }
}