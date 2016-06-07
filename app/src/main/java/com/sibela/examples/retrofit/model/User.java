package com.sibela.examples.retrofit.model;

public class User {

    long id;
    String login;
    String avatar_url;
    String gravatar_id;
    String url;
    String tml_url;
    String followers_url;
    String following_url;
    String gists_url;
    String starred_url;
    String subscriptions_url;
    String organizations_url;
    String repos_url;
    String events_url;
    String received_events_url;
    String type;
    boolean site_admin;
    double score;

    @Override
    public String toString() {
        return login;
    }
}
