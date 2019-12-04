package com.example.bitprojecttask.Interfaces;

import com.example.bitprojecttask.Model.ImageModel;
import com.example.bitprojecttask.Model.UserData;

import java.util.List;

public interface UserInterface {
    interface DataPresenter{
        //Request data
        void requestData();
        //Request User Data
        void requestUserData();
    }

    interface DataInteractor{
        interface OnDataListener{
            //Home Data
            void onFinishedData(List<ImageModel> imageModels);
            void onFailedData(Throwable t);
            //User Data
            void onFinishedGetUserData(UserData userData);
            void onFailedGetUserData(Throwable t);
        }
        //Get home data
        void getData(OnDataListener onDataListener);
        //Get user data
        void getUserData(OnDataListener onDataListener);
    }

    interface DataView{
        //Get Home data
        void dataFetchedSuccessfully(List<ImageModel> imageModels);
        void dataFailedToGet(Throwable t);
        //Get User Data
        void userDataFetchedSuccessfully(UserData userData);
        void userDataFailedToGet(Throwable t);
    }
}
