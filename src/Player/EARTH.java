package Player;

public class EARTH extends Player {

	public EARTH(String name, int hp, int power, int level) {
		super(name, hp, power,level);
	}

	@Override
	public void healSkill() {
		System.out.println(name +"(이)가 주변 풀의 생명력을 흡수합니다."); heal(1.3);
	}


	@Override
	public void attackSkill(Player target) {
	    System.out.println(name + "(이)가 " + target.name + "에게 땅울림을 시전합니다.");
	    if (target.dash()) return; // 수정
	    double multiplier = (target instanceof WATER) ? 1.25 : 1;
	    dealDamage(target, multiplier);

	    if (target instanceof WATER && target.getLevel() >= 2)
	        target.ultimateSkill(this); // 물 타입이 2레벨 이상이면 항상 공격 반사
	    
	    attackCount++;
	    checkLevelUp();
	}

	public void attackSkill(Player target, int ultimate) {
	    System.out.println(name + "(이)가 " + target.name + "에게 궁극기 늪지대를 시전합니다.");
	    System.out.println(target.name + "(이)가 상태이상: 속박에 걸렸습니다.");

	    double multiplier = (target instanceof WATER) ? 1.25 : 1;
	    dealDamage(target, multiplier);

	    if (target instanceof WATER && target.getLevel() >= 2) 
	        target.ultimateSkill(this); // 물 타입이 2레벨 이상이면 항상 공격 반사
	    
	}


	@Override
	public void ultimateSkill(Player target) {
	    attackSkill(target, 2); // 대쉬 비활성화 상태로 공격
	    }

}
