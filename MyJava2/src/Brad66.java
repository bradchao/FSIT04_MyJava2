import java.io.BufferedReader;
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

public class Brad66 {

	public static void main(String[] args) {
		
		try {
//			SSLContext ctx = SSLContext.getInstance("TLS");
//	        ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
//	        SSLContext.setDefault(ctx);
			
			
//			URL url = new URL("https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=8");
//			HttpsURLConnection conn = 
//					(HttpsURLConnection)url.openConnection();
	
			URL url = new URL("http://gis.taiwan.net.tw/XMLReleaseALL_public/scenic_spot_C_f.json");
			HttpURLConnection conn = 
					(HttpURLConnection)url.openConnection();
			
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
			
			
			//System.out.println(sbJSON);
			String temp = trimJSON(sbJSON.toString()) + "}}";
			System.out.println(temp);
			parseJSONV2(temp);
		} catch (Exception e) {
			System.out.println("Ｅ" +e.toString());
		}
		
		
		//parseJSONV2("﻿{'XML_Head':{'Infos':{'Info':[{'Add':'vvv'}]}}}");
		//System.out.println(trimJSON("Brad, \"language\": \"C\", \"listname\": \"1\", \"orgname\": \"315080000H\", \"updatetime\": \"2018-01-21 01:00:00\" }}"));

	}
	
	static String trimJSON(String strJSON) {
		int pos = strJSON.lastIndexOf("language");
		return strJSON.substring(0, pos-3);
	}
	
	static void parseJSON(String strJSON) {
		JSONArray root = new JSONArray(strJSON);
		System.out.println(root.length());
		for (int i=0; i<root.length(); i++) {
			JSONObject data = root.getJSONObject(i);
			String name = data.getString("Name");
			System.out.println(name);
		}
	}
	
	static void parseJSONV2(String strJSON) {
		JSONObject root = new JSONObject(strJSON);
		JSONObject head = root.getJSONObject("XML_Head");
		JSONObject infos = head.getJSONObject("Infos");
		JSONArray info = infos.getJSONArray("info");
		System.out.println(info.length());
		
	}
	
    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
	
}



