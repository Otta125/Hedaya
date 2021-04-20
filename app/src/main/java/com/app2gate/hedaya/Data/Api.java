package com.app2gate.hedaya.Data;


import com.app2gate.hedaya.Pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
