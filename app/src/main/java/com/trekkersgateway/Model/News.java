package com.trekkersgateway.Model;


public class News {
    String id,headline,description,imagename,posted_date;

    public News(String id, String headline, String description, String imagename, String posted_date) {
        this.id = id;
        this.headline = headline;
        this.description = description;
        this.imagename = imagename;
        this.posted_date = posted_date;
    }

    public News(String headline, String description, String imagename, String posted_date) {
        this.headline = headline;
        this.description = description;
        this.imagename = imagename;
        this.posted_date = posted_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }
}
