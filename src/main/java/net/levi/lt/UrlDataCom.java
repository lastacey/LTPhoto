package net.levi.lt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UrlDataCom {

    public String urlGet(String url) throws MalformedURLException,IOException{
        HttpsURLConnection uconn = (HttpsURLConnection) new URL(url).openConnection();
        uconn.setRequestMethod("GET");
        uconn.setUseCaches(false);  //Don't use cache.  Get it every time.
        
        BufferedReader buffreder = new BufferedReader(new InputStreamReader(uconn.getInputStream()));

        StringBuilder strbuild = new StringBuilder();
        String bufftemp = buffreder.readLine();

        while(bufftemp != null){
            strbuild.append(bufftemp);
            bufftemp = buffreder.readLine();
        }

        return strbuild.toString();
    }

}