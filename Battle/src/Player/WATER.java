package Player;


public class WATER extends Player {

	public WATER(String name, int hp, int power, int level) {
		super(name, hp, power, level);
	}


	@Override
	public void healSkill() {
		// TODO Auto-generated method stub
		System.out.println(name +"(이)가 근두운을 소환하여 국지성 호우를 내립니다.");
		int beforeHp = hp;
		setHp((int)(hp * 1.1));
		int healAmount = hp-beforeHp;
		System.out.println(name+"(이)가 HP를"+healAmount+"만큼 회복했습니다.");
	}


	@Override
	public void attackSkill(Player target) {
		System.out.println(name +"(이)가 "+target.name+"에게 물대포를 시전합니다.");
		if (target.dash()) return;
		int beforeHp = target.hp;
		target.hp -= (this.power * 1.15);
		int attackAmount = beforeHp-target.hp;
		System.out.println(target.name+"(이)가 "+name+"에게 "+attackAmount+" 만큼의 피해를 입었습니다.");
		this.attackCount++;
			if(attackCount > 5 && this.level <2)
				this.setLevel(2);
	}
	public void attackSkill(Player target, boolean isUltimate) {
		int beforeHp = target.hp;
		target.hp -= (this.power * 1.15);
		int attackAmount = beforeHp-target.hp;
		System.out.println(target.name+"(이)가 "+name+"에게 "+attackAmount+" 만큼의 피해를 입었습니다.");
		this.attackCount++;
			if(attackCount > 5 && this.level <2)
				this.setLevel(2);
	}

	@Override
    public void ultimateSkill(Player target) {
        System.out.println(name + "이(가) 궁극기 '무지개반사'를 시전합니다!");
        // 상대가 나를 공격할 경우, 해당 공격자에게 피해 반사
        if (target != null) {
            int reflectedDamage = (int)(target.getPower() * 0.5);
            System.out.println(name + "이(가) 공격을 반사하여 " + target.name + "에게 " + reflectedDamage + " 피해를 줍니다!");
            target.hp -= reflectedDamage;
        }
    }
}
