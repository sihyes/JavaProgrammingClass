package Player;

public class FIRE extends Player {
	
    public FIRE(String name, int hp, int power, int level) {
        super(name, hp, power, level);
    }

    @Override
    public void healSkill() {
        System.out.println(name + "(이)가 장작을 먹습니다.");
        heal(1.2);
    }

    @Override
    public void attackSkill(Player target) {
        System.out.println(name + "(이)가 " + target.name + "에게 화염방사를 시전합니다.");
        if (target.dash()) return;

        if (target instanceof WATER && target.getLevel() >= 2) 
            target.ultimateSkill(this);
        

        double multiplier = (target instanceof EARTH) ? 1.25 : 1;
        dealDamage(target, multiplier);
        checkLevelUp();
    }

    @Override
    public void ultimateSkill(Player target) {
        System.out.println(name + "(이)가 " + target.name + "에게 궁극기 유리조각 날리기를 시전합니다.");
        if (target.dash()) return;

        if (target instanceof WATER && target.getLevel() >= 2)
            target.ultimateSkill(this);


        double multiplier = (target instanceof EARTH) ? 1.875 : 1.5;
        dealDamage(target, multiplier);
    }
}
