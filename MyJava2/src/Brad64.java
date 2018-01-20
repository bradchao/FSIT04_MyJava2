import java.net.InetAddress;
import java.net.Socket;

public class Brad64 {

	public static void main(String[] arg) {
		for (int i=0; i<1000000; i++) {
			try(Socket socket = 
				new Socket(InetAddress.getByName("127.0.0.1"),
						6666)){
				socket.getOutputStream().write(("Data:"+i).getBytes());
			}catch(Exception e) {
				System.out.println("Client:" +e.toString());
			}
		}

	}

}
