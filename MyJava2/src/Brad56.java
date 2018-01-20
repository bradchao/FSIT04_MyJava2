import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad56 {
	// UDP Sender
	public static void main(String[] args) {
		byte[] buf = "Hello, 資策會".getBytes();
		try {
			DatagramSocket socket =
				new DatagramSocket();
			DatagramPacket packet = 
				new DatagramPacket(buf, buf.length, 
					InetAddress.getByName("127.0.0.1"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
