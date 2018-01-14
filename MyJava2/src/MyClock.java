import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	
	MyClock(){
		timer  = new Timer();
		timer.schedule(new MyTask(), 0, 500);
	}
	
	private class MyTask extends TimerTask {
		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			setText(now.get(Calendar.HOUR_OF_DAY) + ":" +
					now.get(Calendar.MINUTE) + ":" +
					now.get(Calendar.SECOND));
		}
	}
}
