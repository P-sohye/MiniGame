package com.ohgiraffers.mini_game.farm;

import com.ohgiraffers.mini_game.crop.*;
import com.ohgiraffers.mini_game.weather.Weather;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Farm 클래스 기능
* 농장 크기: 6칸 (각 칸마다 하나의 작물을 심을 수 있음)
* 작물 심기: 빈 땅이 없이 모든 땅에 작물을 심도록 설정
* 턴 진행:
* 1. 모든 작물이 성장
* 2. 날씨 이벤트 실행
* 3. 턴이 완료된 수확 가능한 작물은 판매 및 제거
* 4. 수익 누적 저장
* 5. 현재 농장 상태 표시 (어떤 작물이 어디에 심어졌는지, 남은 성장 시간)
 */


public class Farm {
    private static final int FARM_SIZE = 6;
    private List<Crop> crops;
    private int totalEarnings;
    private Scanner scanner;

    public Farm() {
        this.crops = new ArrayList<>();
        this.totalEarnings = 0;
        this.scanner = new Scanner(System.in);
    }

    //작물 심기
    public class availableFarm {
        private static final int FARM_WIDTH = 3;
        private static final int FARM_HEIGHT = 2;
        private Crop[][] farmGrid;
        private int totalEarnings;
        private Scanner scanner;

        public availableFarm() {
            this.farmGrid = new Crop[FARM_HEIGHT][FARM_WIDTH];
            this.totalEarnings = 0;
            this.scanner = new Scanner(System.in);
        }


        public void plantCrops() {
            while (true) {
                System.out.println("심을 작물 번호를 공백으로 구분하여 입력하세요 (예: 1 2 3 1 5):");
                System.out.println("1. 감자🥔 (₩3,000) | 2. 당근🥕 (₩3,000) | 3. 옥수수🌽 (₩1,500) | 4. 완두콩🫛 (₩800) | 5. 쌀🌾(₩1,000)");
                String[] choices = scanner.nextLine().split(" ");

                if (choices.length < FARM_SIZE - crops.size()) {
                    System.out.println("농장에 심을 수 있는 작물보다 적게 입력했습니다. 다시 입력해주세요.");
                    System.out.println("현재 남은 토지는 " + (FARM_SIZE - crops.size()) + "개 입니다.");
                    continue;
                }
                if (choices.length > FARM_SIZE - crops.size()) {
                    System.out.println("현재 심을 수 있는 작물 수 보다 더 많이 입력했습니다. 다시 입력해주세요.");
                    System.out.println("현재 남은 토지는 " + (FARM_SIZE - crops.size()) + "개 입니다.");
                    continue;
                }

                int index = 0;
                for (int i = 0; i < FARM_HEIGHT; i++) {
                    for (int j = 0; j < FARM_WIDTH; j++) {
                        if (farmGrid[i][j] == null && index < choices.length) {
                            try {
                                int choice = Integer.parseInt(choices[index]);
                                Crop crop = createCrop(choice);
                                if (crop != null) {
                                    farmGrid[i][j] = crop;
                                }
                                index++;
                            } catch (NumberFormatException e) {
                                System.out.println("잘못된 입력입니다: " + choices[index]);
                            }
                        }
                    }
                }
                displayFarmStatus();
                break;
            }
        }

        private Crop createCrop(int choice) {
            switch (choice) {
                case 1:
                    return new Potato();
                case 2:
                    return new Carrot();
                case 3:
                    return new Corn();
                case 4:
                    return new Pea();
                case 5:
                    return new Rice();
                default:
                    System.out.println("잘못된 선택입니다.");
                    return null;
            }
        }

        public void progressTurn() {
            System.out.println("\n===== 턴 진행 중 =====");
            for (Crop crop : crops) {
                crop.grow();
            }
            applyWeatherEvent();
            harvestCrops();
            displayFarmStatus();
        }

        public void applyWeatherEvent() {
            Weather weather = new Weather();
            System.out.println("\n===== 날씨 이벤트 =====");
            int attempts = 2;
            while (attempts > 0) {
                System.out.println("오늘의 날씨를 맞춰보세요! (Sunny / Rainy / Drought)");
                String userGuess = scanner.next();
                if (weather.guessWeather(userGuess)) {
                    System.out.println("✅ 정답입니다! 날씨 특수 효과가 적용됩니다.");
                    break;
                } else {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("❌ 틀렸습니다. 기회가 한 번 더 남아 있습니다.");
                    } else {
                        System.out.println("❌ 틀렸습니다. 오늘의 날씨는 " + weather.getCondition() + " 입니다.");
                    }
                }
            }
            for (Crop crop : crops) {
                weather.applyEffect(crop);
            }
        }

        public void harvestCrops() {
            System.out.println("\n===== 수확 중 =====");
            crops.removeIf(crop -> {
                if (crop.isReadyToHarvest()) {
                    totalEarnings += crop.getPrice();
                    System.out.println(crop.getName() + "을(를) 수확했습니다! 수익: " + crop.getPrice() + "원");
                    return true;
                }
                return false;
            });
        }
        private int availableSlots() {
            int count = 0;
            for (int i = 0; i < FARM_HEIGHT; i++) {
                for (int j = 0; j < FARM_WIDTH; j++) {
                    if (farmGrid[i][j] == null) count++;
                }
            }
            return count;
        }
        public void displayFarmStatus() {
            System.out.println("\n===== 현재 농장 상태 =====");
            for (int i = 0; i < FARM_HEIGHT; i++) {
                for (int j = 0; j < FARM_WIDTH; j++) {
                    if (farmGrid[i][j] == null) {
                        System.out.print("🟫 ");
                    } else {
                        System.out.print(farmGrid[i][j].getName() + " ");
                    }
                }
                System.out.println();
            }
        }
    }

        public void showFinalEarnings(String playerName) {
            System.out.println("\n===== 최종 수익 확인 =====");
            System.out.println("총 수익: " + totalEarnings + "원");
            String rank = (totalEarnings >= 15000) ? "고수" : (totalEarnings >= 8000) ? "중수" : "초보";
            System.out.println("축하드립니다, " + playerName + "님! 당신은 " + rank + " 농부입니다! 🏅");
        }
    }

