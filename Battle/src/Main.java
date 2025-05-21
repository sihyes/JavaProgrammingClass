import player.Player;
import weapon.Weapon;

public class Main {

	public static void main(String[] args) {
		Player p1 = new Player("짱구",100,20);
		Player p2 = new Player("흰둥이",100,10);
		Weapon w1 = new Weapon("초코비",10);
		Weapon w2 = new Weapon("귀여움",10);
		Weapon w3 = new Weapon("잔소리",20);
		
		p1.setWeapon(w1);
		p2.setWeapon(w2);
		int i = 0;
		while(true) {
			System.out.println("======"+i+"======");
			i++;
			if (p1.getHp() <0 || p2.getHp()<0) {break;}
			//죽으면 나가요
		
		
		Player attacker,target;
		if ((int)(Math.random()*100) % 2 == 0) {
			attacker = p1;
			target = p2;
		}
		else {
			attacker = p2;
			target = p1;
			
		}
		//각자 무기가 있는 상태이므로 단순코딩
		attacker.attack(target, attacker.getWeapon());
		target.show();
		
		//1초 쉬기. 쓰레드 쓰기.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //예외처리 던져봤쟈 내가해야하니/가
		
		}
		//누가이겼나!
		Player winner;
		if(p1.getHp() <0) {
			winner = p2;
		}else winner = p1;
		System.out.println(winner.name+" WINNER WINNER CHICKEN DINNER!");

	}

}
