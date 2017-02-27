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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class AnnaUnivRunnableCOE implements Runnable{
    
    private String regno;
    private String SessionId;
    private String dob;
    private String securitycode;
    private String hiddencode;
    
    @Override
    public void run() {
    
        try {
            String url = "http://coe1.annauniv.edu/home/students_corner.php";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.addRequestProperty("Cookie","PHPSESSID="+SessionId+";"); 
            
            //add reuqest header
            con.setRequestMethod("POST");
           // con.setRequestProperty("User-Agent", USER_AGENT);
           // con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            /*
           qe617mVqNLsunJhpq2Eh: 'qe617mVqNLsunJhpq2Eh',
register_no : '312414104018',
dob : '05-02-1997',
security_code_student : 'ANMZ7R'
           */
            String urlParameters = "register_no="+regno+"&dob="+dob+"&security_code_student="+securitycode+"&"+hiddencode+"="+hiddencode;
            
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine+"\n");
            }
            in.close();
            
            //print result
            System.out.println(response.toString());
        } catch (Exception ex) {
            Logger.getLogger(AnnaUnivRunnableCOE.class.getName()).log(Level.SEVERE, null, ex);
        }

	
    
    
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String SessionId) {
        this.SessionId = SessionId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSecuritycode() {
        return securitycode;
    }

    public void setSecuritycode(String securitycode) {
        this.securitycode = securitycode;
    }

    public String getHiddencode() {
        return hiddencode;
    }

    public void setHiddencode(String hiddencode) {
        this.hiddencode = hiddencode;
    }
}
