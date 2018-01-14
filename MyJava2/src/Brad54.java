import java.util.Timer;
import java.util.TimerTask;

public class Brad54 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 3*1000, 1*1000);
		timer.schedule(new MyStop(timer), 10*1000);
		System.out.println("Brad");
		
	}

}

class MyTask extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class MyStop extends TimerTask {
	private Timer timer;
	MyStop(Timer timer){this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}