import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad55 {
	public static void main(String[] args) {
		try {
			InetAddress ip = 
				InetAddress.getByName("192.168.200.4");
			System.out.println(ip.getHostAddress());
			byte[] bb = {123,16,2,3};
			InetAddress ip2 = InetAddress.getByAddress(bb);
			System.out.println(ip2.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
