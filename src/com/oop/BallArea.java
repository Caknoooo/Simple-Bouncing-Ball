package com.oop;

import java.awt.Color;
import java.awt.Graphics;

public class BallArea {
	// Data type
	protected int minX, minY, maxX, maxY;
	private Color colorFilled, colorBorder;
	
	// Contructor
	public BallArea(int x, int y, int width, int height, Color colorFilled, Color colorBorder) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + width - 1;
		this.maxY = y + height - 1;
		this.colorFilled = colorFilled;
		this.colorBorder = colorBorder;
	}
	
	// Setter
	public void set(int x, int y, int width, int height) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + width - 1;
		this.maxY = y + height - 1;
	}
	
	// Drawing graphics
	public void draw(Graphics g) {
		g.setColor(colorFilled);
		g.fillRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
		g.setColor(colorBorder);
		g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
	}
}
