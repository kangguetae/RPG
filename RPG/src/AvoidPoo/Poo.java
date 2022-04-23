package AvoidPoo;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Poo extends Thread {
	
	public static int k=-1;
	private Image pooImage = new ImageIcon(Main.class.getResource("../Image/poo.png")).getImage();
	private int x, y;

	public Poo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void screenDraw(Graphics2D g) {
		if (avoidpoo.gameStart == true && y<800) {
			g.drawImage(pooImage, x, y, null);
			
		}
		
	}

	public void drop() {		
			if(y<70+100) {
				y += Main.POO_SPEED1;
				//+3
			}
			else if(y>=70+100&&y<150+100) {
				y += Main.POO_SPEED2;
				//+5
			}
			else if(y>=150+100&&y<=800) {
				y += Main.POO_SPEED3;
				//+7
			}
			if(y==735) {
				Poo.k++;
			}
			else if(y==798) {
				Game.p.add(Poo.k, 0);
				Game.p.remove(Poo.k+1);
			}

	}

	@Override
	public void run() {
		try {
			while (Game.GameEnd==false) {
				
				drop();

				
					Thread.sleep(Main.SLEEP_TIME*2);
				
				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
