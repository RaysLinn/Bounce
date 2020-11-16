package bounce;

import java.util.ArrayList;

public class NestingShape extends Shape{
	
	//private ArrayList<Shape> nestedShape;
	//private ArrayList<Shape> children;
	ArrayList<Shape> nestedShape = new ArrayList<Shape>();
	//ArrayList<Shape> children = new ArrayList<Shape>();

	/**
	 * Creates a NestingShape object with default values.
	 */
	public NestingShape() {
		super();
		nestedShape = new ArrayList<Shape>();
	}
	/**
	 * Creates a NestingShape object with specified location values, default values for others .
	 */
	public NestingShape (int x, int y) {
		super(x, y);
		nestedShape = new ArrayList<Shape>();
	}
	/**
	 * Creates a NestingShape with specified values for location, velocity and direction. Non鈭抯pecified
	 * attributes take on default values.
	 */
	public NestingShape (int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
		nestedShape = new ArrayList<Shape>();
	}
	/**
	 * Creates a NestingShape with specified values for location, velocity, * direction, width and height.
	 */
	public NestingShape (int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY, width,height);
		nestedShape = new ArrayList<Shape>();
	}
	
	public NestingShape (int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY, width,height, text);
		nestedShape = new ArrayList<Shape>();
	}
	/**
	 * Moves a NestingShape object (including its children) within the bounds specified by arguments
	 * width and height. A NestingShape first moves itself, and then moves its children.
	 */
	public void move (int width, int height) {
		super.move(width, height);
		for (int i = 0; i < nestedShape.size(); i++) {
			Shape test = nestedShape.get(i);
			test.move(_width, _height);
		}
	}
	/**
	 * Paints a NestingShape object by drawing a rectangle around the edge of its bounding box. Once
	 * the NestingShape鈥檚 border has been painted, a NestingShape paints its children.
	 */
	@Override
	public void doPaint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		
		for (Shape i:nestedShape) {
			painter.translate(_x, _y);
			i.paint(painter);
			painter.translate(-_x, -_y);
		}
		
		painter.drawCenteredText(_text, _x + _width / 2, _y + _height / 2);
	}

	/**
	 * Attempts to add a Shape to a NestingShape object. If successful, a two鈭抴ay link is established
	 * between the NestingShape and the newly added Shape. Note that this method has package
	 * visibility 鈭� for reasons that will become apparent in Bounce III.
	 * @param shape the shape to be added.
	 * @throws IllegalArgumentException if an attempt is made to add a Shape to a NestingShape
	 * instance where the Shape argument is already a child within a NestingShape instance. An
	* IllegalArgumentException is also thrown when an attempt is made to add a Shape that will not fit
	 * within the bounds of the proposed NestingShape object.
	 */
	void add (Shape shape) throws IllegalArgumentException {
		//nestedShape.add(shape);
		
		if (shape.parent() != null) {
			throw new IllegalArgumentException();
		}
		
		if ((shape._x + shape._width > _x + _width) || (shape._y + shape._height > _y + _height)) {
			throw new IllegalArgumentException();
		} 
		shape.setParent(this);
		this.nestedShape.add(shape);
		
	}
	/**
	 * Removes a particular Shape from a NestingShape instance. Once removed, the two鈭抴ay link
	 between the NestingShape and its former child is destroyed. This method has no effect if the
	 Shape specified to remove is not a child of the NestingShape. Note that this method has package
	 visibility 鈭� for reasons that will become apparent in Bounce III.
	 * @param shape the shape to be removed.
	 */
	void remove (Shape shape) {
//		for (Shape i:nestedShape) {
//			if (i == shape) {
//				nestedShape.remove(i);
//				//shape._parent = null;
//				shape.setParent(null);
//			}
//		}
		for (int i = 0; i < nestedShape.size(); i++) {
			if (shape == nestedShape.get(i)) {
				nestedShape.remove(i);
				shape.setParent(null);
			}
		}
	}
	/**
	 * Returns the Shape at a specified position within a NestingShape. If the position specified is less
	 * than zero or greater than the number of children stored in the NestingShape less one this method
	 * throws an IndexOutOfBoundsException.
	 * @param index the specified index position.
	 */
	public Shape shapeAt (int index) throws IndexOutOfBoundsException {
			return nestedShape.get(index);
	}
	/**
	 * Returns the number of children contained within a NestingShape object. Note this method is not
	 * recursive 鈭� it simply returns the number of children at the top level within the callee
	 * NestingShape object.
	 */
	public int shapeCount () {
		int count = 0;
		
		for (Shape i:nestedShape) {
			count += 1;
		}
		
		return count;
	}
	/**
	 * Returns the index of a specified child within a NestingShape object. If the Shape specified is not
	 * actually a child of the NestingShape this method returns 鈭�1; otherwise the value returned is in the
	 * range 0 .. shapeCount() 鈭� 1.
	 * @param the shape whose index position within the NestingShape is requested.
	 */
	public int indexOf (Shape shape) {
		return nestedShape.indexOf(shape);
	}
	/**
	 * Returns true if the Shape argument is a child of the NestingShape object on which this method is
	 * called , false otherwise .
	 */
	public boolean contains (Shape shape) {
		return nestedShape.contains(shape);
	}
	
}
