import Player.*;
import view.Battle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("콘솔모드와 뷰 모드 중에 하나를 골라주세요 (콘솔모드: 1 , 뷰 모드:2)");
		System.out.print("입력 : ");
		
		int m = input.nextInt();
		if(m == 1)
			console();
		else if(m == 2)
			wingame();
		else
			System.out.println("입력이 잘못되었습니다. 다시시작해주세요.");
		
		
	}
	
    public static void console() {
 
        FIRE p1 = new FIRE("엠버", 100, 15, 1);
        WATER p2 = new WATER("웨이드", 100, 15, 1);
        EARTH p3 = new EARTH("클로드", 100, 15, 1);

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        int i = 0;
        Random rand = new Random();

        while (true) {
            // 죽은 플레이어 제거한 사본 생성
            List<Player> alivePlayers = new ArrayList<>();
            for (Player p : players) {
                if (p.getHp() > 0) {
                    alivePlayers.add(p);
                }
            }

            // 게임 종료 조건
            if (alivePlayers.size() <= 1) {
                break;
            }

            System.out.println("======" + i + "======");

            // 모든 플레이어 상태 출력 (죽은 플레이어도 포함)
            for (Player p : players) {
                p.show();
            }

            Player attacker = alivePlayers.get(i % alivePlayers.size());

            boolean chooseSkill = rand.nextBoolean();
            Player target = attacker.setTarget(alivePlayers);
            int prevHp = target.getHp();
            int prevAttackerHp = attacker.getHp();
            if(chooseSkill) attacker.healSkill();
            else {
                if (attacker.getLevel() >= 2) 
                    attacker.ultimateSkill(target);
                else attacker.attackSkill(target);
                }
            
            if (target.getHp() <= 0 && prevHp > 0) 
                System.out.println(target.name + " DIED!!!");
            else if (attacker.getHp() <= 0 && prevAttackerHp > 0) {
                System.out.println(attacker.name + " DIED!!!");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;
        }

        // 승자 출력 (살아있는 플레이어 한 명)
        for (Player p : players) {
            if (p.getHp() > 0) {
                System.out.println(p.name + " win!!!");
                break;
            }
        }
        
        
        
        wingame();
    }
	
	
    public static void wingame() {
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