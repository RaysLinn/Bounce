package bounce.views;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import bounce.ShapeModel;
import bounce.Shape;
import bounce.NestingShape;

public class TreeModelAdapter implements TreeModel{
	//private Directory adaptee;
	private ShapeModel adaptee;
	
	public TreeModelAdapter(ShapeModel _shapeModel) {
		adaptee = _shapeModel;
	}

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return adaptee.root();
	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		if (parent instanceof NestingShape && index < getChildCount(parent) && index >= 0) {
			return ((NestingShape)parent).shapeAt(index);
		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		if (parent instanceof NestingShape) {
			return ((NestingShape)parent).shapeCount();
		}
		return 0;
	}

	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		return !(node instanceof NestingShape);
		//return false;
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		if (parent instanceof NestingShape && child instanceof Shape) {
			NestingShape _nestingShape = (NestingShape) parent;
			return _nestingShape.indexOf((Shape)child);
		}
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	
}
