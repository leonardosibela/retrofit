package com.sibela.examples.retrofit.model;

import java.util.List;

public class UserSearchReturn {

    private int total_count;
    private boolean incomplete_results;
    private List<User> items;

    public List<User> getItems() {
        return items;
    }
}