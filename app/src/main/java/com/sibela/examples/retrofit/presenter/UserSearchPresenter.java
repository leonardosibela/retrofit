package com.sibela.examples.retrofit.presenter;

import android.support.annotation.NonNull;

import com.sibela.examples.retrofit.api.GithubAPI;
import com.sibela.examples.retrofit.model.UserSearchReturn;
import com.sibela.examples.retrofit.task.UserSearch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserSearchPresenter implements UserSearch.Presenter {

    private UserSearch.View userSearchView;

    public UserSearchPresenter(@NonNull UserSearch.View userSearchView) {
        checkNotNull(userSearchView, "UserSearchView cannot be null");
        this.userSearchView = userSearchView;
    }

    @Override
    public void searchUsers(String login) {

        String userSearchByLogin = GithubAPI.Util.toSearchByLogin(login);

        Call<UserSearchReturn> usersCall = GithubAPI.getInstance().getUsers(userSearchByLogin);
        usersCall.enqueue(new Callback<UserSearchReturn>() {

            @Override
            public void onResponse(Call<UserSearchReturn> call, Response<UserSearchReturn> response) {
                UserSearchReturn userSearchReturn = response.body();
                userSearchView.displayUsers(userSearchReturn.getItems());
            }

            @Override
            public void onFailure(Call<UserSearchReturn> call, Throwable t) {
                userSearchView.displayError();
            }
        });
    }
}
