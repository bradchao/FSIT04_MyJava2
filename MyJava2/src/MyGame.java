import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyGame extends JFrame {
	private MainBoard main;
	
	public MyGame() {
		setSize(640,480);
		setLayout(new BorderLayout());
		main = new MainBoard();
		add(main, BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {
		new MyGame();
	}
}
