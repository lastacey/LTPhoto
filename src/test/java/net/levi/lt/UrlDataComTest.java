package net.levi.lt;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;

public class UrlDataComTest {

    @Test(expected = MalformedURLException.class)
    public void givenBadURL_Throws() throws MalformedURLException, IOException {
        UrlDataCom urlDat = new UrlDataCom();

        assertNotNull(urlDat.urlGet(""));

    } 

   @Test(expected = IOException.class)
   public void givenMissDirectedURL_Throws() throws MalformedURLException, IOException {
       UrlDataCom urlDat = new UrlDataCom();

       assertNotNull(urlDat.urlGet("https://notavailidurl.busted"));

   }  

   @Test(expected = ClassCastException.class)
   public void givenWrongSchemaURL_Throws() throws MalformedURLException, IOException {
       UrlDataCom urlDat = new UrlDataCom();

       assertNotNull(urlDat.urlGet("http://notavailidurl.busted"));
   }  
   
   @Test
   public void givenValidUrlWithBadAlbumId_ReturnsEmptyArray() throws MalformedURLException, IOException {
       UrlDataCom urlDat = new UrlDataCom();
       String tstring = urlDat.urlGet("https://jsonplaceholder.typicode.com/photos?albumId=99999");
       assertEquals("[]",tstring);
   }  

      
   @Test
   public void givenValidUrlWithValidAlbumId_ReturnsValues() throws MalformedURLException, IOException {
       UrlDataCom urlDat = new UrlDataCom();
       String tstring = urlDat.urlGet("https://jsonplaceholder.typicode.com/photos?albumId=3").replace("\n", "").replace("\r", "");
       assertTrue(tstring.startsWith("[  {    \"albumId\": 3,"));
   }  
}