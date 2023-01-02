package telran.shapes;

public class Rectangle extends Shape {
	
	public Rectangle(int width, int height) {
		super(width, height);
	}
	
	public String[] presentation(int offset) {
		int height = getHeight();
		String res[] = new String[height];
		String line = getLine(offset);
		res[0] = line;
		int lastLine = height - 1;
		res[lastLine] = line;
		for (int i = 1; i < lastLine; i++) {
			res[i] = this.getMiddleLine(offset);
		}
		return res;
	}
	protected String getMiddleLine(int offset) {
		return getOffset(offset) + Shape.symbol + getOffset(getWidth() - 2) + symbol;
	}
	protected String getLine(int offset) {
		return getOffset(offset) + symbol.repeat(getWidth());
	}
	protected String getOffset(int offset) {
		
		return " ".repeat(offset);
	}
	

}