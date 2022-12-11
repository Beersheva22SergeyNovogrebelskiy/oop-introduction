package telran.shapes;

public class SquareTriangle extends Square {
	
	private boolean isLeftDiagonal;
	protected SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	@Override
	public String[] presentation(int offset) {
		String res[] = new String[size];
		char[][] triangle = new char[size][size];
		fillGaps(triangle);
		if(isLeftDiagonal) {
			buildLeftTriangle(triangle);
		} else {
			buildRightTriangle(triangle);
		}
		fromCharToString(triangle, res, offset);
		return res;
	}
	private void fromCharToString(char[][] triangle, String[] res, int offset) {
		for(int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset);
		}
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res.length; j++) {
				res[i] = res[i] + Character.toString(triangle[i][j]);
			}
		}
	}

	private void fillGaps(char[][] triangle) {
		for(int i = 0; i < triangle.length; i++) {
			for(int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = ' ';
			}
		}
	}
	private void buildRightTriangle(char[][] triangle) {
		for(int i = 0; i < triangle.length; i++) {
			triangle[triangle.length - 1][i] = '*';
			triangle[i][triangle.length - 1] = '*';
			triangle[i][triangle.length - 1 - i] = '*';
		}
	}
	private void buildLeftTriangle(char[][] triangle) {
		for(int i = 0; i < triangle.length; i++) {
			triangle[triangle.length - 1][i] = '*';
			triangle[i][0] = '*';
			triangle[i][i] = '*';
		}
	}
}
