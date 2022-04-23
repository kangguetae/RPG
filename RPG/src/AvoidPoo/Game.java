package AvoidPoo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	public static boolean GameEnd = false;
	public static int C1 = 0;
	public static int C2 = 0;
	public static int charX = 400;
	private Image pooImage = new ImageIcon(Main.class.getResource("../Image/poo.png")).getImage();
	private Image character = new ImageIcon(Main.class.getResource("../Image/char.png")).getImage();

	ArrayList<Poo> pooList = new ArrayList<Poo>();
	public static ArrayList<Integer> p = new ArrayList<>();

	public void screenDraw(Graphics2D g) {
		// g.drawImage(pooImage, 400, 400, null);
		int nan = 0;
		if (avoidpoo.easy == true) {
			nan = 70;
		}
		else if (avoidpoo.hard == true) {
			nan = 35;
		}
		else if (avoidpoo.korea == true) {
			nan = 10;
		}
		else {
			nan = 100;
		}

		g.drawImage(character, charX, 750, null);
		int X = (int) ((Math.random()) * 800);
		// if (Poo.y > 100 && Poo.y < 120) {
		//
		// } else if (Poo.y >= 120 && Poo.y < 160) {
		//
		// } else if (Poo.y >= 160) {
		if (C1 % nan == 0) {
			p.add(X);
			dropPoo(X);
			C2++;
		}
		// }
		for (int a = 0; a < pooList.size(); a++) {
			Poo poo = pooList.get(a);
			poo.screenDraw(g);
		}
		if(Game.GameEnd==false) {
			C1 += 10;
		}
		if (Poo.k >= 0) {

			if (Game.p.get(Poo.k) - 30 <= Game.charX && Game.p.get(Poo.k) + 30 >= Game.charX) {
				Game.GameEnd = true;
//				System.out.println("1");
			}

		}

	}

	public void pressLeft() {
		this.charX -= 10;
		// System.out.print("1");
	}

	public void pressRight() {
		this.charX += 10;
	}
	@Override
	public void run() {

	}

	public void dropPoo(int x) {

		Poo poo = new Poo(x, 100);
		poo.start();
		pooList.add(poo);

	}
}
