import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;


public class Brad65 {

	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://pdfmyurl.com/index.php?url=http://www.gamer.com.tw");
			HttpURLConnection conn = 
				(HttpURLConnection)url.openConnection();
			conn.connect();

			FileOutputStream fout = 
					new FileOutputStream("imgs/brad.pdf");
			InputStream in = conn.getInputStream();
			byte[] buf = new byte[4096]; int len = -1;
			while ( (len = in.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
				
			fout.flush();
			fout.close();
			System.out.println("Download OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
