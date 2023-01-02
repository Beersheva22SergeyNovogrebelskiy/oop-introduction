package telran.shapes;

public abstract class Shape {
	protected int width;
	protected int height;
	
public static final String SYMBOL = "*";
	
	protected static String symbol = SYMBOL;
	public static String getSymbol() {
		return symbol;
	}
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public static void setSymbol(String symbol) {
		Shape.symbol = symbol;
	}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	abstract public String[] presentation(int offset);
}
