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
    
    public void levelUp(){
    }

    public void addElementalBonus(){
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

}
