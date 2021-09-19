package com.br.franchises.model.VO;

import java.util.ArrayList;

public class FranchiseVO {
    private String name;
    private String description;
    private int image;
    private ArrayList<RestaurantVO> restaurants;

    public FranchiseVO(String name, String description, int image, ArrayList<RestaurantVO> restaurants) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.restaurants = restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<RestaurantVO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<RestaurantVO> restaurants) {
        this.restaurants = restaurants;
    }
}
