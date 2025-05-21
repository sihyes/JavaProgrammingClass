package player;

import weapon.*; // 웨폰클래스에서 모든것을 임포트 해오겠다. 

//이름, hp, power, 무기, 공격하기() ...
//현재 상태보기
public class Player {

	public String name;
	private int hp;
	private int power;
	private Weapon weapon;

	//생성자
	public Player(String name, int hp, int power) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = power;
	}
	//getter, setter
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	//공격하기!
	//target을 공격하고, target의 hp를 power만큼 깎는다.
	public void attack(Player target) {
		System.out.println(this.name +"--attacking..-->"+target.name);
		target.hp -= this.power;
	}
	public void attack(Player target, Weapon weapon) {
		System.out.println(this.name +"--attacking..-->"+target.name+"with"+weapon.name);
		target.hp -= (this.power + weapon.getPower());
	}
	
	public void show() {
		System.out.printf("%s(%d %d)\n",this.name,this.hp,this.power);
	}
	

}
