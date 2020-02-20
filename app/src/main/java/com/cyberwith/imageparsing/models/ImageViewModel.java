package com.cyberwith.imageparsing.models;

public class ImageViewModel {
    private String imageURL, author;

    public ImageViewModel() {
    }

    public ImageViewModel(String imageURL, String author) {
        this.imageURL = imageURL;
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
