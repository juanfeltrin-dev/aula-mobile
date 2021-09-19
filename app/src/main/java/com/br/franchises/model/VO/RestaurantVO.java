package com.br.franchises.model.VO;

import java.io.Serializable;

public class RestaurantVO implements Serializable {
    private String name;
    private String address;
    private String city;
    private int image;

    public RestaurantVO(String name, String address, String city, int image) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
