package Player;

public class EARTH extends Player {

	public EARTH(String name, int hp, int power, int level) {
		super(name, hp, power,level);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void healSkill() {
		System.out.println(name +"(이)가 주변 풀의 생명력을 흡수합니다.");
		int beforeHp = hp;
		setHp((int)(hp * 1.1));
		int healAmount = hp-beforeHp;
		System.out.println(name+"(이)가 HP를"+healAmount+"만큼 회복했습니다.");
		
	}


	@Override
	public void attackSkill(Player target) {
		System.out.println(name + "(이)가 " + target.name + "에게 땅울림을 시전합니다.");
		int beforeHp = target.hp;
		target.hp -= (this.power * 1.2); // 궁극기는 더 강력하게?
		int attackAmount = beforeHp - target.hp;
		System.out.println(target.name + "(이)가 " + name + "에게 " + attackAmount + " 만큼의 피해를 입었습니다.");
	    if (target instanceof WATER && target.getLevel()>=2) { 
		    target.ultimateSkill(this);
		    return;
	    }		    
		if (this.level <2) {
	        this.attackCount++;
	        if (attackCount >= 5) this.setLevel(2);
		}
	}

	public void attackSkill(Player target, int ultimate) {
	    System.out.println(name + "(이)가 " + target.name + "에게 궁극기 늪지대를 시전합니다.");
	    System.out.println( target.name + "이 상태이상: 속박에 걸렸습니다.");

	    int beforeHp = target.hp;
		target.hp -= (this.power * 1.4); 
		int attackAmount = beforeHp - target.hp;
		System.out.println(target.name + "(이)가 " + name + "에게 " + attackAmount + " 만큼의 피해를 입었습니다.");
		
	    if (target instanceof WATER && target.getLevel()>=2) { 
		    target.ultimateSkill(this);
		    return;
		}
	    
	    
	    
	   
	    
	    
	}


	@Override
	public void ultimateSkill(Player target) {
	    attackSkill(target, 2); // 대쉬 비활성화 상태로 공격
	    }

}
