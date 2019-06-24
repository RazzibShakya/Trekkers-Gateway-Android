package com.trekkersgateway.Model;

public class Feed {
    String id,post,image_name,place,posted_date,userId;

    public Feed(String post, String image_name, String place, String posted_date, String userId) {
        this.post = post;
        this.image_name = image_name;
        this.place = place;
        this.posted_date = posted_date;
        this.userId = userId;
    }

    public Feed(String id, String post, String image_name, String place, String posted_date, String userId) {
        this.id = id;
        this.post = post;
        this.image_name = image_name;
        this.place = place;
        this.posted_date = posted_date;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
