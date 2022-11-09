package com.example.landmarks;

import java.io.Serializable;


public class Landmark implements Serializable { //serializable for intents
    private String name;
    private String country;
    private String location;
    private String url;
    private String image;
    private String extra;


    public Landmark(String name, String country, String location, String url, String image, String extra) {
        this.name = name;
        this.country = country;
        this.location = location;
        this.image = image;
        this.url = url;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) { this.extra = extra; }

}
