package com.ohgiraffers.mini_game.crop;

public abstract class Crop {
    protected String cropName;
    protected int growthTime;
    protected int sellPrice;
    protected int growthProgress = 0;

    public Crop(String cropName, int growthTime, int sellPrice) {
        this.cropName = cropName;
        this.growthTime = growthTime;
        this.sellPrice = sellPrice;
    }

    public String getCropName() {
        return cropName;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getGrowthProgress() {
        return growthProgress;
    }

    public void grow() {
        growthProgress++;
    }

    public boolean isReadyToHarvest() {
        return growthProgress >= growthTime;
    }

    public int getPrice() {
        return sellPrice;
    }

    public String getName() {
        return cropName;
    }
    // 기본적으로 아무 동작하지 않는 메서드 (Carrot에서 오버라이딩 가능)
    public void increaseGrowthTime(){}
    // 다른 작물은 성장속도 증가 없음 (Carrot에서만 오버라이딩)
}

