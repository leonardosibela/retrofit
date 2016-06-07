package com.sibela.examples.retrofit.api;


import com.sibela.examples.retrofit.model.UserSearchReturn;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GithubAPI {

    private static final String ENDPOINT_URL = "https://api.github.com/";

    private static GithubService githubService;

    public interface GithubService {

        @GET("/search/users")
        Call<UserSearchReturn> getUsers(@Query("q") String searcByLoginString);

    }

    public static GithubService getInstance() {

        if (githubService == null) {
            OkHttpClient okHttpClient = new OkHttpClient();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            githubService = retrofit.create(GithubService.class);
        }

        return githubService;
    }

    public static class Util {

        public static String toUserSearchByLogin(String login) {
            return login + " in:login";
        }
    }
}
