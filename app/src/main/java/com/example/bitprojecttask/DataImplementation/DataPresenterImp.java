package com.example.bitprojecttask.DataImplementation;

import com.example.bitprojecttask.Interfaces.UserInterface;
import com.example.bitprojecttask.Model.ImageModel;
import com.example.bitprojecttask.Model.UserData;

import java.util.List;

/**
 * Presenter Implementation
 */
public class DataPresenterImp implements UserInterface.DataPresenter,UserInterface.DataInteractor.OnDataListener {
    private UserInterface.DataInteractor dataInteractor;
    private UserInterface.DataView dataView;

    public DataPresenterImp(UserInterface.DataInteractor dataInteractor, UserInterface.DataView dataView) {
        this.dataInteractor = dataInteractor;
        this.dataView = dataView;
    }

    /**
     * For request Home data
     */
    @Override
    public void requestData() {
        dataInteractor.getData(this);
    }

    /**
     * Foe request user data
     */
    @Override
    public void requestUserData() {
        dataInteractor.getUserData(this);
    }

    /**
     * Listen if request to get Home data success
     * @param imageModels list of images
     */
    @Override
    public void onFinishedData(List<ImageModel> imageModels) {
        if(dataView!=null)
            dataView.dataFetchedSuccessfully(imageModels);
    }

    /**
     * Listen if request to get home data failed
     * @param t error
     */
    @Override
    public void onFailedData(Throwable t) {
        if(dataView!=null)
        dataView.dataFailedToGet(t);
    }

    /**
     * Listen if request to get user data success
     * @param userData list of user data
     */
    @Override
    public void onFinishedGetUserData(UserData userData) {
        if(dataView!=null)
            dataView.userDataFetchedSuccessfully(userData);
    }

    /**
     * Listen if request to get user data failed
     * @param t error
     */
    @Override
    public void onFailedGetUserData(Throwable t) {
        if(dataView!=null)
            dataView.userDataFailedToGet(t);
    }
}
