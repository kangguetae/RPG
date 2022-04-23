package AvoidPoo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	public static boolean REGAME = false;
	@Override
	public void keyPressed(KeyEvent e) {
		if(avoidpoo.gameStart == false) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			System.out.print("L1");
			avoidpoo.game.pressLeft();
		} 
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			System.out.print("R1");
			avoidpoo.game.pressRight();
		} 
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			KeyListener.REGAME=true;
//			System.out.print("1");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(avoidpoo.gameStart == false) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			System.out.print("L2");
			
		} 
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			System.out.print("R2");
		} 
		
	}
}
