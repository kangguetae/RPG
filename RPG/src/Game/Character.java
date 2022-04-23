package Game;
//
public class Character {
	String name;
	int dmg, hp, exp, level;
	
	public Character() {
		
	}
	
	public void attack(Character c) {
		System.out.println(this.name+"이 "+c.name+"을 공격!");
		c.hp -= this.dmg;
		System.out.println(c.name+"의 체력: "+c.hp);
		checkDead();
		
	}
	
	public boolean checkDead() {
		if(this.hp <= 0) {
			System.out.println(this.name+"이(가) 쓰러졌다!");
			return true;
		}
		
		return false;
	}
}
