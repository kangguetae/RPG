package Game;

import java.util.Scanner;

public class Play {

	static Scanner scn = new Scanner(System.in);
	static Character slime, juniorNeki, yeti, jacoom, p1;
	public static void main(String [] args) {
		
	
		System.out.println("플레이어의 이름을 정하세요");
		String playerName = scn.nextLine();
		Player p1 = new Player(playerName);
		
		
		
		
		play: while(true) {
			System.out.println("1: 사냥   2: 정보   3: 휴식   3: 종료 ");
			int newTurn = scn.nextInt();
			slime = new Monster("슬라임",3, 1, 100, 5, 1, 5, "normal");
			juniorNeki = new Monster("주니어네키",5, 7, 370, 40, 4, 15, "normal");
			yeti = new Monster("예티",10, 22, 760, 100, 10, 35, "normal");
			jacoom = new Monster("자쿰",20, 35, 2800, 1800, 30, 200, "boss");
			
			switch(newTurn) {
				case 1 :
					System.out.println("사냥할 몬스터를 선택하세요.");
					System.out.println("1: 슬라임(lv 1)  2: 주니어네키(lv 5)  3: 예티(lv 10)  4: 자쿰(lv 20 Boss) ");
					int chooseMonster = scn.nextInt();
					Character monster = chooseMonster == 1 ? slime : (chooseMonster == 2 ? juniorNeki : (chooseMonster == 3 ? yeti : jacoom));
					if(!battle(p1, monster)) {
						System.out.println("게임을 종료합니다.");
						break play;
					}
				case 2 :
					((Player)p1).playerInfo();
					break;
				case 3 : 
					System.out.println("게임을 종료합니다.");
					break play;
				
				
			}
			System.out.println("------------------------");
		}	
	}
	
	public static boolean battle(Character p, Character m) {
		
		System.out.println(m.name+"이 나타났다! ("+((Monster)m).getType()+")");
		while(true) {
			System.out.println("\n1: 공격   2: 도망친다");
			int huntOrRun = scn.nextInt();
			if(huntOrRun == 1) {
				
				p.attack(m);
				if(m.checkDead()) {
					((Player)p).addExp(m.exp);
					break; 
				}
				else {
					m.attack(p);	
				}
				
				if(p.checkDead()) {
					return false;
				}
				
			}
			else{
				System.out.println("도망쳤습니다.");
				break; 
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
}
