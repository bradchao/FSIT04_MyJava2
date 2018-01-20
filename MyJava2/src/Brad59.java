import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Brad59 {

	// TCP Client
	
	public static void main(String[] args) {
		for (int i=0; i<65535; i++) {
			try {
				Socket socket =
					new Socket(InetAddress.getByName("127.0.0.1"), 
							i);
				socket.close();
				System.out.println("TCP Send OK:"+i);
			} catch (IOException e) {
				//System.out.println(e.toString());
			}
		}

	}

}
