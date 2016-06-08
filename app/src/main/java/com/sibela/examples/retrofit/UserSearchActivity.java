package com.sibela.examples.retrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sibela.examples.retrofit.adapter.StringAdapter;
import com.sibela.examples.retrofit.model.User;
import com.sibela.examples.retrofit.presenter.UserSearchPresenter;
import com.sibela.examples.retrofit.task.UserSearch;
import com.sibela.examples.retrofit.view.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSearchActivity extends AppCompatActivity implements UserSearch.View {

    @Bind(R.id.users_recycler)
    RecyclerView userRecycler;

    @Bind(R.id.user_name_input)
    EditText userNameInput;

    @Bind(R.id.user_search_progress)
    ProgressBar progressBar;

    private UserSearch.Presenter presenter;
    private StringAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        ButterKnife.bind(this);

        presenter = new UserSearchPresenter(this);
        setRecyclerView();
    }

    private void setRecyclerView() {
        userRecycler.setLayoutManager(new LinearLayoutManager(this));
        userRecycler.addItemDecoration(new SimpleDividerItemDecoration(this));
        adapter = new StringAdapter(R.layout.string_item);
        userRecycler.setAdapter(adapter);
    }

    @Override
    public void displayUsers(List<User> users) {
        adapter.setItems(users);
        hideProgress();
    }

    @Override
    public void displayError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, R.string.error_searching_users, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        userRecycler.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        userRecycler.setVisibility(View.VISIBLE);
    }

    @Override
    @OnClick(R.id.search_button)
    public void searchUsers() {
        hideKeyboard();
        showProgress();
        String login = userNameInput.getText().toString();
        presenter.searchUsers(login);
    }

    public void hideKeyboard() {
        View view = getCurrentFocus();
        getImputMethodManager().hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private InputMethodManager getImputMethodManager() {
        return (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }
}
