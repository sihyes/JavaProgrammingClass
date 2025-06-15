package Player;
import java.util.List;
import java.util.Random;

import Skill.*;


public abstract class Player implements Skill {
    public String name;
	protected int hp;
    protected int power;
    protected int level;
    protected int attackCount = 0;  // 공격 성공 카운트
    final int MAX_HP = 100; 
    

    public Player(String name, int hp, int power, int level) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.level = level;
    }    
    
    public int getHp() {
		return hp;
	}

	public int getPower() {
		return power;
	}

	public int getLevel() {
		return level;
	}
	
    public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void takeDamage(Player attacker, int damage) {
	    this.hp -= damage;
	}

	public Player setTarget(List<Player> players) {
		Random random = new Random();
		Player chosen = null;
		while (chosen == null || chosen == this)
			chosen = players.get(random.nextInt(players.size()));
		return chosen;
	}
    

    public boolean dash(){
    		double chance = 100*Math.random(); // 0.0~1.0 사이 값
    		if(chance<15) {
    			System.out.println(name+"이(가) 공격을 회피합니다.");
    			return true;
    		}
    		return false;
    }
    
	public void show() {
		String hpDisplay = (hp <= 0) ? "X" : String.valueOf(hp);
		System.out.printf("%-4s[HP:"+hpDisplay+"|%d] (Lv. %d) \n",this.name,this.power, this.level);
	}
	
	// NEW !! 공통 피해 계산 메소드
	public void dealDamage(Player target, double ratio) {
	    int damage = (int)(this.power * ratio);
	    target.hp -= damage;
	    System.out.println(target.name + "(이)가 " + name + "에게 " + damage + " 만큼의 피해를 입었습니다.");
	}
	
	// NEW!! 공통 힐링 메소드 배율만 입력해주면 됨~
	public void heal(double ratio) {
		if(this.hp>=100) {
            System.out.println(this.name + "의 HP가 이미 MAX인 상태예요!");
            return;
        }
	    int beforeHp = this.hp;
	    int healAmount;
	    this.setHp((int)(this.hp * ratio));
	    if(this.hp >= MAX_HP) { //최대 HP를 넘으면, 그 이상으로 회복 못하게 설정.
	    	healAmount = MAX_HP - beforeHp;
	    	this.hp = MAX_HP; 
	    }
	    else
	    	healAmount = this.hp - beforeHp;
	    System.out.println(this.name + "(이)가 HP를 " + healAmount + " 만큼 회복했습니다.");
	}
	
	public void checkLevelUp() {
	    if (this.attackCount >= 5 && this.level < 2) {
	        this.setLevel(2);
	        System.out.println(this.name + "의 레벨이 2로 상승했습니다!");
	    }
	}
	
	
	
	
	
	


}
