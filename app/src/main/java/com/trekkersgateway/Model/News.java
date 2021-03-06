package com.trekkersgateway.Model;


public class News {
    String id,topic,description,imagename,createddate,postedby,link;

    public News(String id, String topic, String description, String imagename, String createddate, String postedby, String link) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.imagename = imagename;
        this.createddate = createddate;
        this.postedby = postedby;
        this.link = link;
    }

    public News(String topic, String description, String imagename, String createddate, String postedby, String link) {
        this.topic = topic;
        this.description = description;
        this.imagename = imagename;
        this.createddate = createddate;
        this.postedby = postedby;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public String getCreatedate() {
        return createddate;
    }

    public void setCreatedate(String createddate) {
        this.createddate = createddate;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
