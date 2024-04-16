package com.example.lumenrestapicarownerexercise.viewmodels;

public class CarViewModel {

    private int carId;
    private String make;
    private String model;
    private String colour;
    private int yearOfManufacture;
    private int ownerId;

    private OwnerViewModel owner;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public OwnerViewModel getOwner() {
        return owner;
    }

    public void setOwner(OwnerViewModel owner) {
        this.owner = owner;
    }
}
