import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.Socket;

public class Brad61 {

	public static void main(String[] args) {
		File source = new File("imgs/coffee.gif");
		byte[] buf = new byte[(int)source.length()];
		try {
			BufferedInputStream bin = 
				new BufferedInputStream(
					new FileInputStream(source));
			bin.read(buf);
			bin.close();
			
			Socket socket = new Socket(
					InetAddress.getByName("127.0.0.1"),
					7777);
			BufferedOutputStream bout = 
				new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			socket.close();
			System.out.println("Upload Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		

	}

}
