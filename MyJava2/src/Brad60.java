import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Brad60 {

	public static void main(String[] args) {
		try {
			Socket socket =
				new Socket(InetAddress.getByName("127.0.0.1"), 
						9999);
			OutputStream out = socket.getOutputStream();
			
			out.write("Hello, Brad\nHello World\n1234567\n".getBytes());
			out.flush();
			out.close();
			socket.close();
			System.out.println("TCP Send OK:");
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}
