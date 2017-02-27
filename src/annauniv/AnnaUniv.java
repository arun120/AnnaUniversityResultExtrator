/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annauniv;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Home
 */
public class AnnaUniv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // COE1 t=new COE1();
       // t.run();
       //AnnaUnivRunnableCOE t=new AnnaUnivRunnableCOE();
        //t.run();
       // for(int i=0;i<5;i++){
            Runnable t1=new BaseCOE();
            t1.run();
        //}
        
       // Thread thread=new Thread(t);
        //thread.start();
        
    }
    
}
