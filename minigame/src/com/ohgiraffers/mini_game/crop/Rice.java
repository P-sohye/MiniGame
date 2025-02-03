package com.ohgiraffers.mini_game.crop;

// 쌀🌾 | 성장시간 2턴 | 수확 가격 ₩1,000 | 특수조건: 맑음(성공: 바로 수확)

public class Rice extends Crop {
    public Rice() {
        super("쌀🌾", 2, 1000);
    }
}