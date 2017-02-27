/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annauniv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Home
 */
public class AnnaUnivRunnable implements Runnable{
    int result(BigInteger a) {
        try{
      HttpURLConnection connection = null;
         InputStream input=null;
    URL url =new URL("http://aucoe.annauniv.edu/cgi-bin/result/cgrade.pl?regno="+a.toString());
                   
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
            
            input = connection.getInputStream();
               //connect=1;
               
               char c;
                String s = new String();
                while ((c = (char) input.read()) != (char) -1)
                    s += c;
                
                //System.out.print(s);
                System.out.println(a.toString());
                File dir=new File("result/");
                if(!dir.exists())
                    dir.mkdirs();
               
                File dir1=new File("result/result.html");
                dir1.createNewFile();
                //FileOutputStream file=new FileOutputStream("result/"+a.toString()+".html");
                FileOutputStream file=new FileOutputStream("result/"+"result"+".html",true);
                
                file.write(s.getBytes());
                file.close();
                
                return 1;
        }catch(Exception e)
        {
         System.out.println(e);
         return 0;
        }
    }
    @Override
    public void run() {
                 //http://aucoe.annauniv.edu/cgi-bin/result/cgrade.pl?regno=312414104061
                        //new URL("http://182.74.154.218/newportal/");
                        //new URL("http://coe1.annauniv.edu/home/");
              //  connection.getResponseCode();

/*
                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                while (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    System.out.println("Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage());
                }*/
               // System.out.println(connection.getResponseCode());
               int connect=0;
               
       BigInteger a=new BigInteger("312414104001");
       while(a.compareTo(new BigInteger("312414104062"))!=0)
       {
           while(result(a)==0);
           a=a.add(new BigInteger("1"));
       }           
               
                   
               

                              
               }
                
               
           
            
    }
    
