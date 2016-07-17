package com.sibela.examples.retrofit;

import android.app.Activity;
import android.os.Bundle;

import com.sibela.examples.retrofit.model.Repository;
import com.sibela.examples.retrofit.task.RepositorySearch;

import java.util.List;

public class RepositorySearchActivity extends Activity implements RepositorySearch.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);
    }

    @Override
    public void displayRepositories(List<Repository> repositories) {

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
    public void searchRepositories() {

    }
}
