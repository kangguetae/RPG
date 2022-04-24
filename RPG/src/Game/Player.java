package Game;

public class Player extends Character{
	
	
	
	int guard, mp, maxEXP, maxHP;
	
	public Player(String name) {
		this.dmg = 10;
		this.hp = 100;
		this.level = 1;
		this.exp = 0;
		this.maxEXP = 20;
		this.name = name;
		maxHP = 100;
	}
	
	public void addExp(int exp) {
		this.exp += exp;
		checkLevelUp();
	}
	
	
	
	public void checkLevelUp() {
		if(exp >= maxEXP) {
			exp -= maxEXP;
			level++;
			dmg += 5 + (1 * level);
			maxHP += 10 * level;
			hp = maxHP;
			maxEXP += 10 + (3 * level);
			System.out.println("레벨업!");
		}
	}
	
	public void playerInfo() {
		System.out.println("이름: "+name +"\n레벨: "+level+"\n체력: "+hp+"\n경험치"+exp+"/"+maxEXP);
	}
	
	
	
	
	
	
	
}
