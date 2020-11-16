package bounce;

import java.awt.Color;

public class DynamicRectangleShape extends RectangleShape{
	private Color color = Color.red;
	private boolean wall = true;
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY,int width, int height, Color color) {
		super(x,y,deltaX,deltaY,width,height);
		this.color = color;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY,int width, int height, Color color, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
		this.color = color;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY,int width, int height,  String text, Color color) {
		super(x,y,deltaX,deltaY,width,height, text);
		this.color = color;
	}

	public void doPaint (Painter painter) {
		if (wall == true) {
			//painter.drawRect(_x, _y, _width, _height);
			painter.setColor(color);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(Color.black);
		}
		else {
			painter.drawRect(_x, _y, _width, _height);
			painter.drawCenteredText(_text, _x + _width / 2, _y + _height / 2);
		}
	}
	
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;
		
		super.move(width, height);
		
		if (nextX <= 0 || nextX + _width >= width) {
			this.wall = true;
		}
		else if (nextY <= 0 || nextY + _height >= height) {
			this.wall = false;
		}
		
	}
}
