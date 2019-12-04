package com.example.bitprojecttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.bitprojecttask.Adapter.UserAdapter;
import com.example.bitprojecttask.DataImplementation.DataInteractorImp;
import com.example.bitprojecttask.DataImplementation.DataPresenterImp;
import com.example.bitprojecttask.Interfaces.UserInterface;
import com.example.bitprojecttask.Model.ImageModel;
import com.example.bitprojecttask.Model.UserData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserInterface.DataView{

    UserInterface.DataPresenter presenter;
    @BindView(R.id.userImg)
    CircleImageView circleImageView;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.bio)
    TextView bio;
    @BindView(R.id.post)
    TextView posts;
    @BindView(R.id.followers)
    TextView followers;
    @BindView(R.id.following)
    TextView following;
    @BindView(R.id.rec)
    RecyclerView myRec;

    ProgressDialog progressDialog;

    UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        myRec.setLayoutManager(new GridLayoutManager(this,3));
        presenter = new DataPresenterImp(new DataInteractorImp(),this);
        presenter.requestUserData();


    }

    @Override
    public void dataFetchedSuccessfully(List<ImageModel> imageModels) {
        if(imageModels !=null&& imageModels.size()>0){
                adapter = new UserAdapter(MainActivity.this,imageModels);
                myRec.setAdapter(adapter);
        }
        progressDialog.dismiss();
    }

    @Override
    public void dataFailedToGet(Throwable t) {
        progressDialog.dismiss();
        Log.e("failed","failed "+t.getMessage());
    }

    @Override
    public void userDataFetchedSuccessfully(UserData userData) {
        presenter.requestData();
        if(userData!=null){
            userName.setText(userData.getData().getFullName());
            location.setText(userData.getData().getLocation());
            bio.setText(userData.getData().getBio());
            posts.setText(String.valueOf(userData.getData().getCounts().getPosts()));
            followers.setText(String.valueOf(userData.getData().getCounts().getFollowers()));
            following.setText(String.valueOf(userData.getData().getCounts().getFollowing()));

            Glide.with(MainActivity.this)
                    .load(userData.getData().getProfilePicture())
                    .into(circleImageView);

        }
    }

    @Override
    public void userDataFailedToGet(Throwable t) {
        Log.e("failed","failed "+t.getMessage());

    }
}
