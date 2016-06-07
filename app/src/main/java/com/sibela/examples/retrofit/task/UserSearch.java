package com.sibela.examples.retrofit.task;

import com.sibela.examples.retrofit.model.User;

import java.util.List;

public interface UserSearch {

    public interface View {

        void displayUsers(List<User> users);

        void displayError();

        void showProgress();

        void hideProgress();

        void searchUsers();
    }

    public interface Presenter {

        void searchUsers(String name);
    }
}
