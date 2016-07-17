package com.sibela.examples.retrofit.presenter;

import com.sibela.examples.retrofit.api.GithubAPI;
import com.sibela.examples.retrofit.model.Repository;
import com.sibela.examples.retrofit.task.RepositorySearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositorySearchPresenter implements RepositorySearch.Presenter {

    private RepositorySearch.View view;

    public RepositorySearchPresenter(RepositorySearch.View view) {
        this.view = view;
    }

    @Override
    public void searchRepositories(String login) {
        Call<List<Repository>> repositoriesByUser = GithubAPI.getInstance().getRepositoriesByUser(login);
        repositoriesByUser.enqueue(new Callback<List<Repository>>() {

            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                view.displayRepositories(response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                view.displayError();
            }
        });
    }
}
