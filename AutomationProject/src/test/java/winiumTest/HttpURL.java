package winiumTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURL {
	
	
     public static void main(String args[]) throws IOException
     {
    	 URL url=new URL("https://www.ultimatix.net");
    	 HttpURLConnection huc=(HttpURLConnection)url.openConnection();
    	 BufferedReader in = new BufferedReader(
    		        new InputStreamReader(url.openStream()));

    		        String inputLine;
    		        while ((inputLine = in.readLine()) != null)
    		        {
    		            System.out.println(inputLine);
    		            
    		        }
    		        in.close();
    		        huc.disconnect();
    		       
    	 
	
      }
} 