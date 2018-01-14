

public class Brad53 {

	
	public static void main(String[] args) {
		Brad531 obj1 = new Brad531();
		Brad531 obj2 = new Brad531();
		obj1.start();
		obj2.start();
		
	}

}

class Brad531 extends Thread {
	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}
}
