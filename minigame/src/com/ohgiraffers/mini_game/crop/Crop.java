package com.ohgiraffers.mini_game.crop;

// 작물 기본
/*
* 1.농부 이름 정하기(사용자)
* 2. 턴 길이 설정 - 10턴
* 3. 초기 자본과 기본 토지 제공 - 5칸
* */

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

