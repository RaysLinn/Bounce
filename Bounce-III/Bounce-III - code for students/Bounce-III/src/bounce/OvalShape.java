package bounce;

class OvalShape extends Shape {
	
	public OvalShape() {
		super();
	}
	
	public OvalShape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY, width,height);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY, width,height, text);
	}
	
	public void doPaint(Painter painter) {
		painter.drawOval(_x,_y,_width,_height);
		//painter.drawCenteredText(_text, _x, _y);
	}

}
