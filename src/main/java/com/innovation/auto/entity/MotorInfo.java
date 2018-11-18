package com.innovation.auto.entity;

import java.util.Date;

public class MotorInfo {
    private Integer id;

    private String name;

    private String model;

    private Integer manufacturerId;

    private String madeCountry;

    private Date marketTime;

    private Long retailPrice;

    private String displacement;

    private String cylindersNum;

    private String stroke;

    private String perCylinderValve;

    private String maximumPower;

    private String maximumTorque;

    private String fuelConsumption;

    private String gear;

    private String tankCapacity;

    private String weight;

    private String 
maximumSpeed;

    private String brakeSystem;

    private String instrument;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getMadeCountry() {
        return madeCountry;
    }

    public void setMadeCountry(String madeCountry) {
        this.madeCountry = madeCountry == null ? null : madeCountry.trim();
    }

    public Date getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(Date marketTime) {
        this.marketTime = marketTime;
    }

    public Long getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Long retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement == null ? null : displacement.trim();
    }

    public String getCylindersNum() {
        return cylindersNum;
    }

    public void setCylindersNum(String cylindersNum) {
        this.cylindersNum = cylindersNum == null ? null : cylindersNum.trim();
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke == null ? null : stroke.trim();
    }

    public String getPerCylinderValve() {
        return perCylinderValve;
    }

    public void setPerCylinderValve(String perCylinderValve) {
        this.perCylinderValve = perCylinderValve == null ? null : perCylinderValve.trim();
    }

    public String getMaximumPower() {
        return maximumPower;
    }

    public void setMaximumPower(String maximumPower) {
        this.maximumPower = maximumPower == null ? null : maximumPower.trim();
    }

    public String getMaximumTorque() {
        return maximumTorque;
    }

    public void setMaximumTorque(String maximumTorque) {
        this.maximumTorque = maximumTorque == null ? null : maximumTorque.trim();
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption == null ? null : fuelConsumption.trim();
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear == null ? null : gear.trim();
    }

    public String getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(String tankCapacity) {
        this.tankCapacity = tankCapacity == null ? null : tankCapacity.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBrakeSystem() {
        return brakeSystem;
    }

    public void setBrakeSystem(String brakeSystem) {
        this.brakeSystem = brakeSystem == null ? null : brakeSystem.trim();
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument == null ? null : instrument.trim();
    }
}