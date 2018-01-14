

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySing extends JFrame {
	private JButton clear, undo, redo,
	save, restore, saveJPEG;
	private MyDrawer drawer;
	private MyClock myClock;
	
	public MySing() {
		super("簽名");
		setLayout(new BorderLayout());
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		save = new JButton("Save");
		restore = new JButton("Restore");
		saveJPEG = new JButton("Save JPEG");
		myClock = new MyClock();
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		top.add(save); top.add(restore); top.add(saveJPEG);
		top.add(myClock);
		add(top, BorderLayout.NORTH);
		
		drawer = new MyDrawer();
		add(drawer, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawer.redo();
			}
		});
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawer.save();
			}
		});
		restore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawer.restore();
			}
		});
		saveJPEG.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveJPEG();
			}
		});

	}
	
	private void saveJPEG() {
	    BufferedImage img = new BufferedImage(
	    		drawer.getWidth(), 
	    		drawer.getHeight(), 
	    		BufferedImage.TYPE_INT_RGB);
	    drawer.print(img.getGraphics()); // or: panel.printAll(...);
	    try {
	        ImageIO.write(img, "jpg", new File("dir1/drawer.jpg"));
	        System.out.println("Save OK");
	    }catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	
	public static void main(String[] args) {
		new MySing();
	}

}