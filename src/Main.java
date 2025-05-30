import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Player.*;

public class Main {
    public static void main(String[] args) {
 
        FIRE p1 = new FIRE("엠버", 100, 20, 1);
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
            if(chooseSkill) attacker.healSkill();
            else {
            	if (attacker.getLevel() >= 2) 
            		attacker.ultimateSkill(target);
            	else attacker.attackSkill(target);
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
    }
}
