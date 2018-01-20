import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad63 {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(80)){
			while (true) {
				Socket socket = server.accept(); 
				InputStream in = socket.getInputStream();
				new MyThread(in).start();
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
class MyThread extends Thread {
	private InputStream in;
	MyThread(InputStream in){this.in = in;}
	@Override
	public void run() {
		//byte[] buf = new byte[4096];
		try(
			BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(in))){
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("-------");
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
}

