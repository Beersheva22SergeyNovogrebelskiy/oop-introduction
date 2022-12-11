package telran.shapes;

public class Square extends Rectangle {
	int size;

	public Square(int size) {
		super(size, size);
		this.size = size;
	}

	@Override
	public void setWidth(int size) {
		super.setWidth(size);
		super.setHeight(size);
	}

	@Override
	public void setHeight(int size) {

		super.setHeight(size);
		super.setWidth(size);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}