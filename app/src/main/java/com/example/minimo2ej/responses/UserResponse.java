package com.example.minimo2ej.responses;

public class UserResponse {

    //imagen del usuario
    private String avatar_url;
    //número de personas que sigues
    private int following;
    //url de los seguidores
    private String followers_url;
    private int public_repos;
    private String name;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserResponse{" +
                "avatar_url='" + avatar_url + '\'' +
                ", following=" + following +
                ", followers_url='" + followers_url + '\'' +
                ", public_repos=" + public_repos +
                ", name='" + name + '\'' +
                '}';
    }
}
