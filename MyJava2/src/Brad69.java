import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Brad69 {

	public static void main(String[] args) {
		try{
			URL url = new URL("https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=8");
			
			TrustManager[] tm = {new X509TrustManager() {
				
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					// TODO Auto-generated method stub
					
				}
			}};
			
			TrustManager[] t2 = {}; 
			
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, tm, new SecureRandom());
			
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.connect();
			
			BufferedReader reader =
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line = null; 
			StringBuilder sbJSON = new StringBuilder();
			while ( (line = reader.readLine()) != null) {
				sbJSON.append(line);
			}
			
			reader.close();
			System.out.println(sbJSON);
			
		}catch(Exception e) {
			
		}
		
		
	}

}
