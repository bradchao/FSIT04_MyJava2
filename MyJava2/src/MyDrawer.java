

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycler;
	
	public MyDrawer() {
		setBackground(Color.GREEN);
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				super.mouseDragged(event);
				//System.out.println("drag");
				doMouseEvent(event);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				//System.out.println("press");
				doNewLine(event);
			}
		});
		
		lines = new LinkedList<>();
		recycler = new LinkedList<>();
		
	}
	
	private void doNewLine(MouseEvent event) {
		LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
		lines.add(line);
		doMouseEvent(event);
		
		recycler.clear();
	}
	
	private void doMouseEvent(MouseEvent event) {
		HashMap<String,Integer> dot = new HashMap<>();
		dot.put("x", event.getX());
		dot.put("y", event.getY());
		lines.getLast().add(dot);
		repaint();
	}

	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			recycler.add(lines.removeLast());
			repaint();
		}
	}

	public void redo() {
		if (recycler.size()>0) {
			lines.add(recycler.removeLast());
			repaint();
		}
	}
	
	public void save() {
		try {
			ObjectOutputStream oout = 
				new ObjectOutputStream(
					new FileOutputStream("dir1/mysign.dat"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			System.out.println("Save OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void restore() {
		File datFile = new File("dir1/mysign.dat");
		if (datFile.exists()) {
			try {
				ObjectInputStream oin = 
					new ObjectInputStream(
						new FileInputStream(datFile));
				lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)
						oin.readObject();
				
				oin.close();
				
				repaint();
				
			}catch(Exception e) {
				System.out.println(e.toString());
			
			}
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i=1; i<line.size(); i++) {
				HashMap<String,Integer> p0 = line.get(i-1);
				HashMap<String,Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}
		
	}
	
}

