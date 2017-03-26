package com.example.toto.myapplication;

/**
 * Created by Toto on 22/03/2017.
 */

public class Video{
    private String title;
    private String publishedAt;
    private String channelId;
    private String channelTitle;
    private String description;
    private String liveBroadcastContent;
    private String url;

    public Video(String title, String publishedAt, String channelId, String channelTitle, String description, String liveBroadcastContent, String url) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.channelTitle = channelTitle;
        this.description = description;
        this.liveBroadcastContent = liveBroadcastContent;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
