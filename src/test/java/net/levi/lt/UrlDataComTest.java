package net.levi.lt;

import org.junit.Test;
import static org.junit.Assert.*;


public class UrlDataComTest{

    @Test 
    public void givenURL_ExpectsNotnull(){
        UrlDataCom urlDat = new UrlDataCom();

        assertNotNull(urlDat.urlGet("")); 

    } 
}