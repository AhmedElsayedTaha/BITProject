package com.example.bitprojecttask.DataImplementation;

import com.example.bitprojecttask.Interfaces.UserInterface;
import com.example.bitprojecttask.Model.HomeModel;
import com.example.bitprojecttask.Model.UserData;
import com.example.bitprojecttask.Network.APIClient;
import com.example.bitprojecttask.Network.APIService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Thid class for Implement functions that request data from server
 */
public class DataInteractorImp implements UserInterface.DataInteractor {

    /**
     * This function for get the Home data like images using Retrofit
     * @param onDataListener listener that listen on request if success pr not
     */
    @Override
    public void getData(final OnDataListener onDataListener) {
        APIService apiService = APIClient.getRetrofitInstance().create(APIService.class);
        apiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<HomeModel>() {
                    @Override
                    public void onSuccess(HomeModel value) {
                        onDataListener.onFinishedData(value.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        onDataListener.onFailedData(e);
                    }
                });
    }

    /**
     * This function for get User data
     * @param onDataListener listener that listen on request if success pr not
     */
    @Override
    public void getUserData(OnDataListener onDataListener) {
        APIService apiService = APIClient.getRetrofitInstance().create(APIService.class);
        apiService.getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<UserData>() {
                    @Override
                    public void onSuccess(UserData value) {
                        onDataListener.onFinishedGetUserData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onDataListener.onFailedGetUserData(e);
                    }
                });
    }
}
