package com.example.emailapp;

class EmailItem {
    private String title;
    private String subTitle;
    private String content;
    private String date;
    private String imageURL;

    EmailItem(String title, String subTitle, String content, String date, String imageURL) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.date = date;
        this.imageURL = imageURL;
    }

    String getTitle() {
        return title;
    }

    String getSubTitle() {
        return subTitle;
    }

    String getContent() {
        return content;
    }

    String getDate() {
        return date;
    }

    String getImageURL() {
        return imageURL;
    }
}