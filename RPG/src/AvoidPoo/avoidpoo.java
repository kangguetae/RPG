package AvoidPoo;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class avoidpoo extends JFrame {
	
//	private Image pooImage = new ImageIcon(Main.class.getResource("../Image/poo.png")).getImage();
//	private Image character = new ImageIcon(Main.class.getResource("../Image/char.png")).getImage();
	
	private Image screenImage;
	private Graphics screenGraphic;

	public static boolean gameStart = false;
	public static boolean easy = false;
	public static boolean hard = false;
	public static boolean korea = false;
	
	

	private JLabel menu = new JLabel(new ImageIcon(Main.class.getResource("../Image/menu.png")));

	private ImageIcon xButtonBasic = new ImageIcon(Main.class.getResource("../Image/xButtonOn.jpg"));
	private ImageIcon xButtonEntered = new ImageIcon(Main.class.getResource("../Image/xButtonOff.jpg"));
	private ImageIcon hardButton = new ImageIcon(Main.class.getResource("../Image/hardButton.jpg"));
	private ImageIcon easyButton = new ImageIcon(Main.class.getResource("../Image/easyButton.jpg"));
	private ImageIcon koreaButton = new ImageIcon(Main.class.getResource("../Image/koreaButton.jpg"));
	
	private JButton xButton = new JButton(xButtonBasic);

	private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource("../Image/startButtonOn.jpg"));
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../Image/startButtonOff.jpg"));

	private JButton startButton = new JButton(startButtonBasic);
	private JButton difficulty1 = new JButton(easyButton);
	private JButton difficulty2 = new JButton(hardButton);
	private JButton difficulty3 = new JButton(koreaButton);
	
	
	public static Game game = new Game();
	
	private int mouseX, mouseY;

	public avoidpoo() {
		setUndecorated(true);
		setTitle("Avoid Poo");
		setSize(Main.WIDTH, Main.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(120, 255, 0));
		setLayout(null);

		addKeyListener(new KeyListener());
		
		xButton.setBounds(770, 0, 30, 30);
		xButton.setBorderPainted(false);
		xButton.setContentAreaFilled(false);
		xButton.setFocusable(false);
		xButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				xButton.setIcon(xButtonEntered);
				xButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		xButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				xButton.setIcon(xButtonBasic);
				xButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		xButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		add(xButton);
		
		startButton.setBounds(310, 260, 180, 204);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusable(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEntered);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startButton.setVisible(false);
				difficulty1.setVisible(false);
				difficulty2.setVisible(false);
				difficulty3.setVisible(false);
				gameStart = true;
				
			}
		});

		add(startButton);
		
		
		difficulty1.setBounds(140, 120, 141, 141);
		difficulty1.setBorderPainted(false);
		difficulty1.setContentAreaFilled(false);
		difficulty1.setFocusable(false);
		difficulty1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				difficulty1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		difficulty1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				difficulty1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		difficulty1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avoidpoo.easy = true;
				avoidpoo.hard = false;
				avoidpoo.korea = false;
			}
		});
		
		add(difficulty1);
		
		difficulty2.setBounds(140, 280, 141, 141);
		difficulty2.setBorderPainted(false);
		difficulty2.setContentAreaFilled(false);
		difficulty2.setFocusable(false);
		difficulty2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				difficulty2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		difficulty2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				difficulty2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		difficulty2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avoidpoo.easy = false;
				avoidpoo.hard = true;
				avoidpoo.korea = false;
			}
		});
		add(difficulty2);
		
		difficulty3.setBounds(140, 430, 141, 141);
		difficulty3.setBorderPainted(false);
		difficulty3.setContentAreaFilled(false);
		difficulty3.setFocusable(false);
		difficulty3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				difficulty3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		difficulty3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				difficulty3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		difficulty3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				avoidpoo.easy = false;
				avoidpoo.hard = false;
				avoidpoo.korea = true;
			}
		});
		
		add(difficulty3);

		menu.setBounds(0, 0, 800, 30);
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menu);

	}

	public void paint(Graphics g) {

		screenImage = createImage(Main.WIDTH, Main.HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
//		g.drawImage(character, 500, 500, null);

	}

	public void screenDraw(Graphics2D g) {
		paintComponents(g); 
//		g.drawImage(startButtonBasic, 700, 700, null);
		
		if (gameStart == true) {
			game.screenDraw(g);
//			System.out.print("0");
//			g.drawImage(character, 500, 500, null);
//			g.setColor(Color.WHITE);
		}
		
//		if(Game.GameEnd==false) {
		this.repaint();
//	}

		
	}

}
