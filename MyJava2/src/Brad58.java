import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad58 {
	// TCP Receiver
	public static void main(String[] args) {
		try {
			ServerSocket server = 
					new ServerSocket(9999);
			Socket socket = server.accept();	// Listen
			//----------------------
			InputStream in = socket.getInputStream();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			//-------------------------
			server.close();
			System.out.println("TCP Receive OK");
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}
