package Game;

public class Prac {

	public static void main(String [] args) {
		Character c = new Character();
		Character p1 = new Player("민혜숙");
		Character m1 = new Monster("강민채", 1, 100, 5);
		
		Player p2 = new Player("강지은");
		
//		System.out.println(p1.name);
		
		
		while(!m1.checkDead()) {
			p1.attack(m1);
		}
		
	}
}
