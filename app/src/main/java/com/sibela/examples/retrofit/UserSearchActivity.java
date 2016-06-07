package com.sibela.examples.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.sibela.examples.retrofit.model.User;
import com.sibela.examples.retrofit.task.UserSearch;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSearchActivity extends AppCompatActivity implements UserSearch.View {

    @Bind(R.id.users_recycler)
    RecyclerView userRecycler;

    @Bind(R.id.user_name_input)
    EditText userNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        ButterKnife.bind(this);
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
    @OnClick(R.id.search_button)
    public void searchUsers() {

    }
}
