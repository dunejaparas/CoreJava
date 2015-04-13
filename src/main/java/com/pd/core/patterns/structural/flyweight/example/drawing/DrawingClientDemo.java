package com.pd.core.patterns.structural.flyweight.example.drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pd.core.patterns.structural.flyweight.example.drawing.ShapeFactory.ShapeType;

/**
 *
 * used random number generation to generate different type of Shapes in our
 * frame.
 *
 * If you run client program, you will notice the delay in creating first Line
 * Object and Oval objects with fill as true and false. After that the program
 * executes quickly since its using the shared objects.
 *
 * After clicking “Draw” button multiple times, the frame looks like below
 * image.
 *
 * flyweight-pattern-example
 *
 * And you will see following output in command line confirming that Objects are
 * shared.
 *
 * 1 2 3 Creating Line object Creating Oval object with fill=true Creating Oval
 * object with fill=false Thats all for flyweight pattern, we will look into
 * more design patterns in future posts. If you liked it, please share your
 * thoughts in comments section and share it with others too.
 *
 * Flyweight Pattern Example in JDK
 *
 * All the wrapper classes valueOf() method uses cached objects showing use of
 * Flyweight design pattern. The best example is Java String class String Pool
 * implementation.
 *
 * Important Points
 *
 * In our example, the client code is not forced to create object using
 * Flyweight factory but we can force that to make sure client code uses
 * flyweight pattern implementation but its a complete design decision for
 * particular application.
 *
 * Flyweight pattern introduces complexity and if number of shared objects are
 * huge then there is a trade of between memory and time, so we need to use it
 * judiciously based on our requirements.
 *
 * Flyweight pattern implementation is not useful when the number of intrinsic
 * properties of Object is huge, making implementation of Factory class complex.
 *
 */
public class DrawingClientDemo extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeType shapes[] = { ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NOFILL };
    private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };

    public DrawingClientDemo(final int width, final int height) {
	this.WIDTH = width;
	this.HEIGHT = height;
	final Container contentPane = getContentPane();

	final JButton startButton = new JButton("Draw");
	final JPanel panel = new JPanel();

	contentPane.add(panel, BorderLayout.CENTER);
	contentPane.add(startButton, BorderLayout.SOUTH);
	setSize(WIDTH, HEIGHT);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

	startButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent event) {
		final Graphics g = panel.getGraphics();
		for (int i = 0; i < 20; ++i) {
		    final Shape shape = ShapeFactory.getShape(getRandomShape());
		    shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor());
		}
	    }
	});
    }

    private ShapeType getRandomShape() {
	return shapes[(int) (Math.random() * shapes.length)];
    }

    private int getRandomX() {
	return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
	return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
	return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
	return (int) (Math.random() * (HEIGHT / 10));
    }

    private Color getRandomColor() {
	return colors[(int) (Math.random() * colors.length)];
    }

    public static void main(final String[] args) {
	new DrawingClientDemo(500, 600);
    }
}