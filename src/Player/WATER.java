package Player;


public class WATER extends Player {

	public WATER(String name, int hp, int power, int level) {
		super(name, hp, power, level);
	}


	@Override
	public void healSkill() {
		// TODO Auto-generated method stub
		System.out.println(name +"(이)가 근두운을 소환하여 국지성 호우를 내립니다.");
		heal(1.2);
	}


	@Override
	public void attackSkill(Player target) {
	    System.out.println(name + "(이)가 " + target.name + "에게 물대포를 시전합니다.");
	    if (target.dash()) return;
	    double multiplier = (target instanceof FIRE) ? 1.25 : 1;
	    dealDamage(target, multiplier);
	    checkLevelUp();
	}

	public void attackSkill(Player target, boolean isUltimate) {
	    double multiplier = (target instanceof FIRE) ? 1.25 : 1;
	    dealDamage(target, multiplier);
	    checkLevelUp();
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
