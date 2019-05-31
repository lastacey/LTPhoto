
package net.levi.lt;

import org.junit.Test;
import net.levi.lt.DataParse.Data;
import static org.junit.Assert.*;

import java.util.List;

public class DataParseTest {
    String baconipsum = "capicola kielbasa pancetta doner sausage";
    String jsoninput = "{\"id\":1,\"title\":\""+baconipsum+"\"}";

    @Test 
    public void givenJSON_ExpectsDataObject() {
        Data datum = new DataParse().parseJSON(jsoninput) ;

        assertNotNull(datum);
        assertEquals(1,datum.id);
        assertEquals(baconipsum,datum.title);
    }

    @Test 
    public void givenDataStrings_ExpectsFormat(){
        assertEquals("[1] " + baconipsum, new DataParse().parseJSON(jsoninput).toString());
    } 

    @Test 
    public void givenJSONArray_ExpectsListofData(){
        List<Data> dataset = new DataParse().parseJSONList("["+jsoninput+"]");
        assertNotNull(dataset);
        assertEquals(1, dataset.size());
        
        Data datum = dataset.get(0);
        assertEquals(1,datum.id);
        assertEquals(baconipsum,datum.title); 

    } 

}
