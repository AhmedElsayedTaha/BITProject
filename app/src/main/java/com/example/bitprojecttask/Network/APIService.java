package com.example.bitprojecttask.Network;

import com.example.bitprojecttask.Model.HomeModel;
import com.example.bitprojecttask.Model.UserData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface APIService {

    /**
     * Getting the data like images
     * @return HomeModel object
     */
    @GET("home")
    Single<HomeModel> getData();

    /**
     * Getting the User data
     * @return user data object
     */
    @GET("profile")
    Single<UserData> getUserData();
}
