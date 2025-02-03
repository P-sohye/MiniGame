// 작물 기본
/* 턴 길이 설정(개발자) - 10턴

 농부 이름 정하기(사용자)

 초기 자본과 기본 토지(3칸) 제공*/

abstract class Crop {
    protected String name;
    protected int growthTime;
    protected int price;
    protected int currentGrowth = 0;

    public Crop(String name, int growthTime, int price) {
        this.name = name;
        this.growthTime = growthTime;
        this.price = price;
    }

}
