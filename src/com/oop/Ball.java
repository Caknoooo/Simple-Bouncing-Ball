package com.oop;

import java.awt.*;

public class Ball {
	private float x, y;
	private float speedX, speedY;
	private float radius;
	private Color color;
	
	// Constructor
	public Ball(float x, float y, float radius, float speed, float angleInDegree, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
		this.speedY = (float)(speed * Math.sin(Math.toRadians(angleInDegree)));
		this.color = color;
	}
	
	// Set Grafik
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));;
	}
	
	public void collide(BallArea box) {
		float ballMinX = box.minX + radius;
		float ballMinY = box.minY + radius;
		float ballMaxX = box.maxX - radius;
		float ballMaxY = box.maxY - radius;
		
		x += speedX;
		y += speedY;
		
		if(x < ballMinX) {
			speedX *= -1;
			x = ballMinX;
		}
		else if(x > ballMaxX) {
			speedX *= -1;
			x = ballMaxX;
		}
		
		if(y < ballMinY) {
			speedY *= -1;
			y = ballMinY;
		}
		else if(y > ballMaxY) {
			speedY *= -1;
			y = ballMaxY;
		}
	}
}
