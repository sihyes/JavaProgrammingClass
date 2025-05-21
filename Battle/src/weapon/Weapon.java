package weapon;
//이름, power
//어떤 무기는 자체공격기능
//어떤 무기는 플레이어가 사용해야한다.
public class Weapon {
	public String name;
	private int power;
	//생성자
	public Weapon(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}
	//getter setter
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	
	

}
