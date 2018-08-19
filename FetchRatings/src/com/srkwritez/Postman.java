package com.srkwritez;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
//import org.json.JSONObject;

public class Postman {
	
		   
	public static String callAPI(String...params) throws Exception {
	     String url = "http://stg.api.bazaarvoice.com/data/reviews.json?apiversion=5.4&passkey=caB45h2jBqXFw1OE043qoMBD1gJC8EwFNCjktzgwncXY4&filter=Id:16970607&include=Products";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     
	     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     
	     String responseString =response.toString();	     
	     
	     
	     //JSONObject myResponse = new JSONObject(responseString);
	     
	     return responseString;
	     
	   }

}
