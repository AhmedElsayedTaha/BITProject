package com.example.bitprojecttask.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeModel {

    @SerializedName("data")
    @Expose
    private List<ImageModel> data = null;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public List<ImageModel> getData() {
        return data;
    }

    public void setData(List<ImageModel> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
