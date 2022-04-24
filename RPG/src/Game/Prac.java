package Game;

import java.util.Scanner;

public class Prac {

	public static void main(String [] args) {
		Scanner scn = new Scanner(System.in);
		
		
		Character c = new Character();
		System.out.println("플레이어의 이름을 정하세요");
		String playerName = scn.nextLine();
		Character p1 = new Player(playerName);
		Character slime = new Monster("슬라임",1, 1, 100, 5, "normal");
		Character juiorNeki = new Monster("주니어네키",5, 7, 370, 40, "normal");
		Character yeti = new Monster("예티",10, 22, 760, 100, "normal");
		Character jacoom = new Monster("자쿰",20, 35, 2800, 1800, "boss");
		
		
		
		
		
		
		
		play: while(true) {
			System.out.println("1: 사냥   2: 정보   3: 종료 ");
			int newTurn = scn.nextInt();
			
			switch(newTurn) {
				case 1 :
					slime = new Monster("슬라임",1, 1, 100, 5, "normal");
					System.out.println(slime.name+"이 나타났다! ("+((Monster)slime).getType()+")");
					while(true) {
						System.out.println("\n1: 공격   2: 도망친다");
						int huntOrRun = scn.nextInt();
						if(huntOrRun == 1) {
							if(!p1.checkDead()) {
								p1.attack(slime);
							}
							else {
								System.out.println("플레이어가 사망했습니다.\n게임을 종료합니다.");
								break play;
							}
							if(!slime.checkDead()) {
								slime.attack(p1);	
							}
							else {
								((Player)p1).addExp(slime.exp);
								break; 
							}
						}
						else break; 
						
					}
					break;
					
					
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
}
