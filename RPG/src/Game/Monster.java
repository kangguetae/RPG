package Game;

public class Monster extends Character {
	
	String type;
	
	public Monster(String name,int dmg, int level, int hp, int exp, int guard, int money, String type) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.exp = exp;
		this.name = name;
		this.type = type;
		this.dmg = dmg;
	}
	
//	@Override
	public String getType() {
		return type;
	}
	
	public void monsterInfo() {
		System.out.println(this.name+"\n: lv"+this.level+"\n HP: "+this.hp+"\n타입: "+this.type);
	}
	
	
}
