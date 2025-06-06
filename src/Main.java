import Player.*;
import view.Battle;

import java.io.UnsupportedEncodingException;


public class Main {
    public static void main(String[] args) {
                try {

                    FIRE p1 = new FIRE("엠버", 100, 15, 1);
                    WATER p2 = new WATER("웨이드", 100, 15, 1);
                    EARTH p3 = new EARTH("클로드", 100, 15, 1);

                    Battle view = new Battle(p1,p2,p3);

                    // View 초기화 및 화면에 표시
                    view.setVisible(true); 

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (Exception e) { // 다른 예상치 못한 예외도 잡을 수 있도록 추가
                    e.printStackTrace();
                }
           
    }
}