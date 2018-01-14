import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainBoard extends JPanel {
	private Timer timer;
	private int viewW, viewH;
	private int ballW, ballH;
	private boolean isInit;
	private BufferedImage[] imgs = new BufferedImage[5];
	private LinkedList<Ball> balls;
	
	public MainBoard() {
		setBackground(Color.GRAY);
		timer = new Timer();
		balls = new LinkedList<>();
		
		timer.schedule(new RefreshView(), 0, 30);
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent event) {
				// TODO Auto-generated method stub
				super.mousePressed(event);
			
				if (!isGotBall(event.getX(), event.getY())) {
					addNewBall(event.getX(), event.getY());
				}
			}
			
		});

	}
	
	private boolean isGotBall(int eventX, int eventY) {
		boolean isGotIt = false;
		for (Ball ball : balls) {
			if (eventX >= ball.ballX && eventX <= ball.ballX + ballW 
					&& eventY >= ball.ballY && eventY <= ball.ballY+ballH) {
				ball.cancel();
				isGotIt = true;
				break;
			}
		}
		return isGotIt;
	}
	
	private void addNewBall(int eventX, int eventY) {
		Ball ball = new Ball(eventX, eventY);
		timer.schedule(ball, 0, 30);
		balls.add(ball);
	}
	
	private void init() {
		isInit = true;
		viewW = getWidth(); viewH = getHeight();
		for (int i=0; i<5; i++) {
			try {
				imgs[i] = ImageIO.read(new File("imgs/ball" + i +".png"));
			} catch (IOException e) {
	
			}
		}
		ballW = ballH = 48;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		if (!isInit) init();
		
		for(Ball ball : balls) {
			g2d.drawImage(imgs[ball.imgIndex], 
					ball.ballX, ball.ballY, null);
		}

	}
	
	private class RefreshView extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class Ball extends TimerTask {
		int ballX, ballY;
		private int dx, dy;
		int imgIndex;
		Ball(int x, int y){
			ballX = x; ballY = y;
			dx = (int)(Math.random()*9) - 4;
			dy = (int)(Math.random()*9) - 4;
			imgIndex = (int)(Math.random()*5);
		}
		@Override
		public void run() {
			if (ballX < 0 || ballX + ballW > viewW) {
				dx *= -1;
			}
			if (ballY < 0  || ballY + ballH > viewH) {
				dy *= -1;
			}

			ballX += dx;
			ballY += dy;
		}
	}


}
