
public class Brad68 {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		p.start();
		c.start();
	}

}
class Buffer {
	private int count;
	private int pc, cc;
	synchronized void addCount() {
		while (count==1) {
			try {
				System.out.println("P:W"+pc);
				wait();
			} catch (InterruptedException e) {
			}

		}			
		count++;
		System.out.println("P" + pc++);
		notify();
	}
	synchronized void rmCount() {
		while (count==0) {
			try {
				System.out.println("C:W"+cc);
				wait();
			} catch (InterruptedException e) {
			}
		}			
		count--;
		System.out.println("C"+ cc++);
		notify();
	}
	int getCount() {return count;}
}
class Producer extends Thread {
	private Buffer buffer;
	Producer(Buffer buffer){this.buffer=buffer;}
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			buffer.addCount();
		}
	}
}
class Consumer extends Thread {
	private Buffer buffer;
	Consumer(Buffer buffer){this.buffer = buffer;}
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			buffer.rmCount();
		}
	}
}




