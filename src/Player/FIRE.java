package Player;
public class FIRE extends Player {
	
    public FIRE(String name, int hp, int power, int level) {
        super(name, hp, power, level); // 🔸 Player의 필드를 초기화
    }



	@Override
	public void healSkill() {
		System.out.println(name +"(이)가 장작을 먹습니다.");
		int beforeHp = hp;
		setHp((int)(hp * 1.1));
		int healAmount = hp-beforeHp;
		System.out.println(name+"(이)가 HP를"+healAmount+"만큼 회복했습니다.");
		
	}


	@Override
	public void attackSkill(Player target) {
		System.out.println(name +"(이)가 "+target.name+"에게 화염방사를 시전합니다.");
		if (target.dash()) return;
	    if (target instanceof WATER && target.getLevel()>=2) { 
		    target.ultimateSkill(this);
		    return;
		}
		int beforeHp = target.hp;
		target.hp -= (this.power * 1.3);
		int attackAmount = beforeHp-target.hp;
		System.out.println(target.name+"(이)가 "+name+"에게 "+attackAmount+" 만큼의 피해를 입었습니다.");
		this.attackCount++;
		if(attackCount > 5 && this.level <2)
			this.setLevel(2);
	}

	@Override
	public void ultimateSkill(Player target) {
		System.out.println(name +"(이)가 "+target.name+"에게 궁극기 유리조각 날리기를 시전합니다.");
		if (target.dash()) return;
	    if (target instanceof WATER && target.getLevel()>=2) { 
		    target.ultimateSkill(this);
		    return;
		}
		int beforeHp = target.hp;
		target.hp -= (this.power * 1.5);
		int attackAmount = beforeHp-target.hp;
		System.out.println(target.name+"(이)가 "+name+"에게 "+attackAmount+" 만큼의 피해를 입었습니다.");
		
	}
	

}
