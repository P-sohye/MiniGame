package com.ohgiraffers.mini_game.weather;
import com.ohgiraffers.mini_game.crop.Crop;
import com.ohgiraffers.mini_game.crop.Carrot;
import com.ohgiraffers.mini_game.crop.Potato;
import com.ohgiraffers.mini_game.crop.Rice;
import java.util.Random;

// 환경변수
/*
 * random 날씨 맞추기 2회 기회
 * 성공: 특수 조건 실행
 * 실패: 다음 턴
 * 1. 화창한 날☀️ |성공시 : 종일 맑고 화창한 날이 될 것입니다! 쌀🌾을 바로 수확 할 수 있습니다.|
 * 2. 비 오는 날🌧 |성공시 : 종일 비가 올 것입니다. 감자🥔를 바로 수확 할 수 있습니다. | 실패시: 폭풍이 접근하고 있습니다. 천둥번개도 예상됩니다.
 * 3. 가뭄🌤 |성공시 : 농작물에 물을 뿌려 주어야 합니다. 당근🥕을 바로 수확 할 수 있습니다. |실패시 : 가뭄이 지속되고 있습니다. 당근🥕 성장속도 1턴 증가
 * */


public class Weather {
    private String Weather;
    private static final String[] weatherEffect = {"Sunny", "Rainy", "Drought"};
    private Random random = new Random();

    public Weather() {
//        random.nextInt(3) → 0, 1, 2 중 랜덤한 숫자를 반환
        //weatherEffect에서 해당 인덱스의 값을 선택하여 Weather 변수에 저장
        this.Weather = weatherEffect[random.nextInt(weatherEffect.length)];
    }

    public String getCondition() {
        return Weather;
    }

   //사용자가 입력한 날씨(userGuess)와 실제 날씨(Weather)가 같은지 비교하는 메서드
    public boolean guessWeather(String userGuess) {
        return Weather.equals(userGuess);
    }

    public void applyEffect(Crop crop) {
        switch (Weather) {
            case "Sunny":
                if (crop instanceof Rice) {
                    System.out.println("오늘은 맑고 화창한 날입니다! 쌀🌾을 바로 수확할 수 있습니다.");
                    crop.grow();
                }else{
                    System.out.println("❌ 틀렸습니다. 오늘의 날씨는 맑고 화창한 날입니다! 하지만 아무런 일도 일어나지 않습니다. ");
                }
                break;
            case "Rainy":
                if (crop instanceof Potato) {
                    System.out.println("비가 와서 감자🥔를 바로 수확할 수 있습니다.");
                    crop.grow();
                } else {
                    System.out.println("❌ 틀렸습니다. 폭풍이 접근하고 있습니다. 천둥번개도 예상됩니다.");
                }
                break;


        case "Drought":
        if (crop instanceof Carrot) {
            System.out.println("가뭄입니다. 물을 뿌려 주어야 합니다. 당근🥕을 바로 수확할 수 있습니다.");
            crop.grow();
        } else {
            System.out.println("❌ 틀렸습니다. 가뭄이 지속되어 당근🥕의 성장속도 1턴 증가합니다.");
            crop.increaseGrowthTime();
        }
        break;
        }
    }
}

