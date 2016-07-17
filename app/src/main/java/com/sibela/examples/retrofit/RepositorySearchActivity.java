package com.sibela.examples.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sibela.examples.retrofit.adapter.RepositoryAdapter;
import com.sibela.examples.retrofit.model.Repository;
import com.sibela.examples.retrofit.presenter.RepositorySearchPresenter;
import com.sibela.examples.retrofit.task.RepositorySearch;
import com.sibela.examples.retrofit.view.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepositorySearchActivity extends Activity implements RepositorySearch.View {

    public static final String USER_LOGIN = "userLogin";

    @Bind(R.id.repository_recycler)
    RecyclerView repositoryRecycler;

    @Bind(R.id.repo_search_progress)
    ProgressBar progressBar;

    RepositoryAdapter adapter;
    RepositorySearch.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);

        ButterKnife.bind(this);
        setRecyclerView();

        presenter = new RepositorySearchPresenter(this);
        presenter.searchRepositories(getIntent().getExtras().getString(USER_LOGIN));
    }

    @Override
    public void displayRepositories(List<Repository> repositories) {
        adapter.setRepositories(repositories);
        hideProgress();
    }

    @Override
    public void displayError() {
        Toast.makeText(this, R.string.error_searching_repos, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        repositoryRecycler.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        repositoryRecycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void searchRepositories() {

    }

    private void setRecyclerView() {
        adapter = new RepositoryAdapter();
        repositoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        repositoryRecycler.addItemDecoration(new SimpleDividerItemDecoration(this));
        repositoryRecycler.setAdapter(adapter);
    }
}
