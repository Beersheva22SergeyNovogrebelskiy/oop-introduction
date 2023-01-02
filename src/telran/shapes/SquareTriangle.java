package telran.shapes;

import java.util.Arrays;

public class SquareTriangle extends Square {
	private boolean isLeftDiagonal;

	protected SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}

	public boolean isLeftDiagonal() {
		return isLeftDiagonal;
	}

	private char[][] buildTriangle() {
		int size = getWidth();
		char symbolChar = symbol.charAt(0);
		char[][] triangle = new char[size][size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(triangle[i], ' ');
			if (isLeftDiagonal) {
				triangle[i][size - 1] = symbolChar;
				triangle[i][size - i - 1] = symbolChar;
			} else {
				triangle[i][0] = symbolChar;
				triangle[i][i] = symbolChar;
			}
		}
		return triangle;
	}

	public String[] presentation(int offset) {
		int size = getWidth();
		String[] res = new String[size];
		int lastline = size - 1;
		res[lastline] = getLine(offset);
		char[][] triangle = buildTriangle();
		for (int i = 0; i < lastline; i++) {
			res[i] = getOffset(offset) + new String(triangle[i]);
		}
		return res;
	}
}