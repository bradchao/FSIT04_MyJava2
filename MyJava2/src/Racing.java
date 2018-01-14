import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Horse[] horses;
	
	public Racing() {
		super("Racing Game");
		setLayout(new GridLayout(9, 1));
		
		go = new JButton("Go!");
		add(go);
		
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ".");
			add(lanes[i]);
		}
		
		horses = new Horse[8];
		for (int i=0; i<horses.length; i++) {
			horses[i] = new Horse(i);
		}
		
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				go();
			}
		});
		
		
	}
	
	private void go() {
		for (int i=0; i<horses.length; i++) {
			horses[i].start();
		}
	}
	
	
	private class Horse extends Thread {
		private int num;	// 0-base
		Horse(int n){num=n;}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				lanes[num].setText(lanes[num].getText() + ">");
				try {
					Thread.sleep(50 + (int)(Math.random()*200));
				} catch (InterruptedException e) {

				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Racing();

	}

}
