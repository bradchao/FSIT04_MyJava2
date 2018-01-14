import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainBoard extends JPanel {
	private Timer timer;
	private int ballX, ballY;
	private int viewW, viewH;
	private int ballW, ballH;
	private int dx, dy;
	private boolean isInit;
	private BufferedImage imgBall;
	
	public MainBoard() {
		setBackground(Color.GRAY);
		timer = new Timer();
		timer.schedule(new BallTask(), 0, 60);
	
		
	}
	
	private void init() {
		isInit = true;
		viewW = getWidth(); viewH = getHeight();
		try {
			imgBall = ImageIO.read(new File("imgs/ball.png"));
			ballW = imgBall.getWidth();
			ballH = imgBall.getHeight();
			dx = dy = 16;
		} catch (IOException e) {

		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		if (!isInit) init();
		
		g2d.drawImage(imgBall, ballX, ballY, null);


	}
	
	private class BallTask extends TimerTask {
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
			repaint();
		}
	}
}
