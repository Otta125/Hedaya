package com.app2gate.hedaya.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.app2gate.hedaya.Data.RetrofitClient;
import com.app2gate.hedaya.Pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    public MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    PostInterface postsInterface;

    public PostViewModel(PostInterface posts) {
        this.postsInterface = posts;
    }

    public void getPosts() {
        postsInterface.Load();
        RetrofitClient.getInstance().getApi().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsMutableLiveData.setValue(response.body());
                postsInterface.Dissmiss();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.setValue("errr");
                postsInterface.Dissmiss();
            }
        });
    }
}