package bounce;

/**
 * Class to represent a simple rectangle.
 * 
 * @author Ian Warren
 * 
 */
public class RectangleShape extends Shape {
	boolean hasText = false;
	
	/**
	 * Default constructor that creates a RectangleShape instance whose instance
	 * variables are set to default values.
	 */
	public RectangleShape() {
		super();
	}
	
	/**
	 * Creates a RectangleShape object with a specified x and y position.
	 */
	public RectangleShape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public RectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public RectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
		if (text != "") {
			hasText = true;
		}
	}
	
	/**
	 * Paints the rectangle using the supplied Painter.
	 */
	@Override
	protected void doPaint(Painter painter) {
		if (hasText == false) {
			painter.drawRect(_x,_y,_width,_height);
		} else {			
			painter.drawRect(_x,_y,_width,_height);
			painter.drawCenteredText(_text, _x + _width / 2, _y + _height / 2);
		}
	}
}
