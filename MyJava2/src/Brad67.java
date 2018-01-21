import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad67 {

	public static void main(String[] args) {
		
		try {
			BufferedReader reader =
				new BufferedReader(
					new FileReader("upload/data1.csv"));
			String line = null; 
			while ( (line = reader.readLine()) != null) {
				//System.out.println(line);
				line = line.replaceAll("\"", "");
				String[] data = line.split(",");
				if (data.length>2) {
					System.out.println(data[0]);
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Ｅ" +e.toString());
		}
	}
	
}



