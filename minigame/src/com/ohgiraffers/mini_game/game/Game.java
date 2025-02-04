package com.ohgiraffers.mini_game.game;
import com.ohgiraffers.mini_game.farm.Farm;
import java.util.Scanner;

//😊사용자 이름을 작성 해 주세요😊
//🌱 농장 경영 게임을 시작합니다! (총 10턴)
//===== 턴 1 시작 =====
//===== 현재 농장 상태 =====
/*

🟫🟫🟫
🟫🟫🟫
🥔감자🥔 (성장: 0/10) 수확가격: ₩3,000
🥕당근🥕 (성장: 0/3) 수확가격: ₩3,000
🌽옥수수🌽 (성장: 0/2) 수확가격: ₩1,500
🌱완두콩🌱 (성장: 0/1) 수확가격: ₩800
🌾쌀🌾 (성장: 0/2) 수확가격: ₩1,000
*/
//===== 작물 심기 & 수확 =====
/*
1. 감자🥔 :
2. 당근🥕 :
3. 옥수수🌽 :
4. 완두콩🌱 :
5. 쌀🌾 :
 **비어있는 땅보다 더 많은 수를 작성하면 -> 현재 심을 수 있는 작물의 갯수는 총 n개 입니다. (다시 작성)
 ===== 날씨 이벤트 =====
⛅ 오늘의 날씨를 맞춰보세요! (Sunny / Rainy / Drought)
 ===== 최종 수익 확인 =====
 날씨 이벤트 적용 -> 바로 턴수가 채워질 시 최종 수익으로 누적 시작
 */
//반복
//===== 최종 단계 (10턴)=====
//반복
//축하드립니다. (사용자 이름)님은 초보 농부 (or 중수 or 고수) 입니다.🏅


public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("😊 사용자 이름을 작성 해 주세요 😊");
        String playerName = scanner.nextLine();

        System.out.println("\n🌱 농장 경영 게임을 시작합니다! (총 10턴)");
        Farm farm = new Farm();

        System.out.println("\n===== 작물 심기 =====");
//        farm.plantCrops();
//
//        for (int turn = 1; turn <= 10; turn++) {
//            System.out.println("\n===== 턴 " + turn + " 시작 =====");
//            farm.displayFarmStatus();
//            System.out.println("\n===== 작물 심기 & 수확 =====");
//            farm.harvestCrops();
//
//            System.out.println("\n===== 날씨 이벤트 =====");
//            farm.applyWeatherEvent();
//
//            farm.progressTurn();
//        }
//
//        farm.showFinalEarnings(playerName);
//        System.out.println("축하드립니다. " + playerName + "님은 " + Farm.rank + " 농부입니다! 🏅");
        System.out.println("게임을 종료합니다. 감사합니다!");
        scanner.close();
    }
}
