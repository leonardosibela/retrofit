package com.sibela.examples.retrofit.task;

import com.sibela.examples.retrofit.model.Repository;

import java.util.List;

public interface RepositorySearch {

    public interface View {

        void displayRepositories(List<Repository> repositories);

        void displayError();

        void showProgress();

        void hideProgress();

        void searchRepositories();
    }

    public interface Presenter {

        void searchRepositories(String login);
    }
}
