import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad62 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			Socket socket = server.accept();
			BufferedInputStream bin = 
				new BufferedInputStream(socket.getInputStream());
			
			byte[] buf = new byte[4096]; int len = -1;
			FileOutputStream fout = 
				new FileOutputStream("upload/newcoffee.png");
			while ( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			fout.flush();
			fout.close();
			bin.close();
			socket.close();
			server.close();
			System.out.println("Upload Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			

	}

}
