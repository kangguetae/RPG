package Game;

//d
public class Character implements Items{
	String name;
	int dmg, hp, exp, level, guard, money;

	public Character() {

	}

//	public String getType() {return "";}		

	
	
	
	public void attack(Character c) {
		System.out.println(this.name + "이 " + c.name + "을 공격!");
		c.hp -= this.dmg;

		if (c.checkDead()) {
			System.out.println(c.name + "이(가) 쓰러졌다!");
		}
		else
			System.out.println(c.name + "의 체력: " + c.hp);

	}

	public boolean checkDead() {
		if (this.hp <= 0)
			return true;

		return false;
	}
}
