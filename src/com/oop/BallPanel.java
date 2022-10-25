package com.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.Random;

public class BallPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final int REFRESH_RATE = 30;
	private Ball ball;
	private BallArea box;
	private int areaWidth, areaHeight;
	
	public BallPanel(int width, int height) {
		this.areaHeight = height;
		this.areaWidth = width;
		
		Random rand = new Random();
		int radius = 50;
		
		int x = rand.nextInt(width - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(height - radius * 2 - 20) + radius + 10;
		
		int speed = 5;
		int angleInDegree = rand.nextInt(360);
		
		ball = new Ball(x, y, radius, speed, angleInDegree, Color.BLUE);
		box = new BallArea(0, 0, width, height, Color.BLACK, Color.WHITE);
	
		// Untuk mendapatkan ukuran area latar belakang jika frame di resize
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				areaWidth = dim.width;
				areaHeight = dim.height;
				box.set(0, 0, width, height);
			}
		});
		startThread();
	}
	
	public void startThread() {
		Thread gameThread = new Thread() {
			public void run() {
				while(true) {
					ball.collide(box);
					repaint();
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					} catch(InterruptedException ex) {}
				}
			}
		};
		{
			gameThread.start(); // Jalankan thread
		}
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		box.draw(g);
		ball.draw(g);
	}
}
