import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad57 {
	// UDP Receiver
	public static void main(String[] args) {
		byte[] buf = new byte[4096];
		try {
			DatagramSocket socket = 
				new DatagramSocket(8888);
			DatagramPacket packet = 
				new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			socket.close();
			
			InetAddress ip = packet.getAddress();
			byte[] data = packet.getData();
			int len = packet.getLength();
			
			
			System.out.println(ip.getHostAddress() + 
					":" + len+ ":" +
					new String(data));
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
