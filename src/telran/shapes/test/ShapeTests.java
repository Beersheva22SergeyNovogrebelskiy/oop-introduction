package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;
import telran.shapes.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Shape;
import telran.shapes.Square;
import telran.shapes.SqureLeftTriangle;
import telran.shapes.SqureRightTriangle;

class ShapeTests {
	
	Canvas canvas = new Canvas(10, 20,
			new Shape[] { new Rectangle(10, 5), new Square(10), new SqureLeftTriangle(10, true) });
	Shape[] shapes = { new Rectangle(10, 5), new Square(10), new SqureLeftTriangle(10, true), new SqureRightTriangle(10, false),
			canvas, new Square(10) };

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}
	
	@Test
	@Disabled
	void squareTest() {
		Square square = new Square(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	@Disabled
	void squareleftTriangleTest() {
		SqureLeftTriangle squreLeftTriangle = new SqureLeftTriangle(10, true);
		assertEquals(10, squreLeftTriangle.getSize());
		displayStrings(squreLeftTriangle.presentation(20));
		squreLeftTriangle.setSize(15);
		assertEquals(15, squreLeftTriangle.getSize());
		displayStrings(squreLeftTriangle.presentation(20));
	}
	
	@Test
	@Disabled
	void squareRightTriangleTest() {
		SqureRightTriangle squreRightTriangle = new SqureRightTriangle(11, false);
		displayStrings(squreRightTriangle.presentation(20));
	}
	
	@Test
	void canvasTest() {
		/*
		Shape rectangle = new Rectangle(7, 8);
		Shape square = new Square(9);
		Shape squareLeftTriangle = new SqureLeftTriangle(8, true);
		Shape squareRightTriangle = new SqureRightTriangle(7, false);
		Shape [] shapes = new Shape[] {rectangle, square, squareLeftTriangle, squareRightTriangle}; 
		Canvas canvas = new Canvas(8, 8, shapes);
		displayStrings(canvas.presentation(10));
		canvas.setDirection("column");
		displayStrings(canvas.presentation(10));
		*/
		/*
		Shape [] shapes = new Shape[] {new Rectangle(5, 7), new Square(9), new SquareLeftTriangle(5), new SquareRightTriangle(7)};
		Canvas canvas = new Canvas(15, 15, shapes);
		canvas.setMargin(1);
//		displayStrings(canvas.presentation(10));
//		canvas.setDirection("column");
//		displayStrings(canvas.presentation(10));
		
		Canvas canvas1 = new Canvas(10, 10, new Shape[]{new SquareRightTriangle(7), canvas});
		displayStrings(canvas1.presentation(10));
		canvas.setDirection("column");
		canvas1.setDirection("column");
		displayStrings(canvas1.presentation(10));
		*/
	}
	
	
	
	@Test
	//@Disabled
	void canvasInRowTest() {
		Canvas canvas = new Canvas(10, 5, shapes);
		canvas.setMargin(3);
		displayStrings(canvas.presentation(2));

	}

	@Test
	// @Disabled
	void canvasInColumnTest() {
		Canvas canvas = new Canvas(10, 4, shapes);
		canvas.setDirection("column");
		this.canvas.setDirection("column");
		canvas.setMargin(1);
		displayStrings(canvas.presentation(2));

	}
}