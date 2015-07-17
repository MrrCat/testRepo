import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rectangle extends JFrame {
	private int recWidth;
	private int recHeigth;
	private int x;
	private int y;
	private JPanel graphicPanel;

	public Rectangle(int recWidth, int recHeigth, int x, int y) throws HeadlessException {// init
																							// params
		super();
		this.recWidth = recWidth;
		this.recHeigth = recHeigth;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.drawRect(x, y, recHeigth, recWidth);
		g.dispose();
	}

	public Rectangle() {// constructing panel
		graphicPanel = new JPanel();
		add(graphicPanel);
	}

	public static void main(String[] args) throws Runner {
		// TODO exception possible on wrong input data
		Rectangle rec = new Rectangle(); // creating new class object
		try {
			Scanner sc = new Scanner(System.in);// getting values
			System.out.println("Enter the width value");
			rec.recWidth = sc.nextInt();
			System.out.println("Enter the heigth value");
			rec.recHeigth = sc.nextInt();
			System.out.println("Enter the x value");
			rec.x = sc.nextInt();
			System.out.println("Enter the y value");
			rec.y = sc.nextInt();
		} catch (Exception e) {
			if ((rec.recWidth<0)||(rec.recHeigth<0)||(rec.x<0)||(rec.y<0)){
				throw new Runner("Wrong input data");
			}
		}
		JFrame fApp = rec;// Frame with params
		fApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fApp.setSize(800, 800);
		fApp.setVisible(true);
		fApp.setTitle("Rectangle");
	}
}