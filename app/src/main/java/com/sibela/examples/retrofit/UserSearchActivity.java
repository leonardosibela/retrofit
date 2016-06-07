package com.sibela.examples.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sibela.examples.retrofit.model.User;
import com.sibela.examples.retrofit.task.UserSearch;

import java.util.List;

public class UserSearchActivity extends AppCompatActivity implements UserSearch.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
    }

    @Override
    public void displayUsers(List<User> users) {

    }

    @Override
    public void displayError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void searchUsers() {

    }
}
