/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annauniv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class BaseCOE implements Runnable{
    public  String SessionId;
    public String hiddencode;
    @Override
    public void run() {
    
        try {
            String url = "http://coe1.annauniv.edu/home/index.php";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
      
            
            int responseCode = con.getResponseCode();
            
            System.out.println("\nSending 'GET' request to URL : " + url);
           // System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
            SessionId=con.getHeaderField(4).split("=")[1].split(";")[0];
            System.out.println("Session Header" +con.getHeaderField(4));
            System.out.println("Session : " +SessionId);
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine+"\n");
            }
            in.close();
        
            hiddencode=response.toString().substring(response.toString().lastIndexOf("hidden")).split("=")[3];
            hiddencode=hiddencode.substring(1, hiddencode.lastIndexOf("\""));
            
            //print result
            System.out.println("Hidden Code: "+hiddencode);
            System.out.println(response.toString());
            
             Scanner s=new Scanner(System.in);
            
             AnnaUnivRunnableCOE t1=new AnnaUnivRunnableCOE();
             t1.setDob("05-02-1997");
             t1.setHiddencode(hiddencode);
             t1.setRegno("312414104018");
             t1.setSessionId(SessionId);
             System.out.println("Enter Captcha");
             t1.setSecuritycode(s.next());
             System.out.println("Security Captcha:"+t1.getSecuritycode());
             
            // t1.setSessionId("sap2o9onl5pjbr2i2jkg99bnf1");
          //   t1.setHiddencode("2geAqAAElXF7m30PX3Sa");
        //     t1.setSecuritycode("XCY847");
             t1.run();
     
        } catch (Exception ex) {
            Logger.getLogger(AnnaUnivRunnableCOE.class.getName()).log(Level.SEVERE, null, ex);
        }

	
    
    
    }
}
