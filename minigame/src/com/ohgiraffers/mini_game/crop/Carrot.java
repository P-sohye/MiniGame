package com.ohgiraffers.mini_game.crop;

// 당근🥕 | 성장시간 3턴 | 수확 가격 ₩3,000 | 특수조건: 폭염(성공: 바로 수확, 실패: 1턴 증가)

public class Carrot extends Crop {
    public Carrot() {
        super("당근🥕", 3, 3000);
    }
    @Override
    public void increaseGrowthTime() {
        this.growthTime += 1;
    }
}