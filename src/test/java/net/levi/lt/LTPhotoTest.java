
package net.levi.lt;

import org.junit.Test;
import net.levi.lt.LTPhoto.Data;
import static org.junit.Assert.*;

import java.util.List;

public class LTPhotoTest {
    String baconipsum = "capicola kielbasa pancetta doner sausage";
    String jsoninput = "{\"id\":1,\"title\":\""+baconipsum+"\"}";

    @Test 
    public void givenJSON_ExpectsDataObject() {
        Data datum = new LTPhoto().parseJSON(jsoninput) ;

        assertNotNull(datum);
        assertEquals(1,datum.id);
        assertEquals(baconipsum,datum.title);
    }

    @Test 
    public void givenDataStrings_ExpectsFormat(){
        assertEquals("[1] " + baconipsum, new LTPhoto().parseJSON(jsoninput).toString());
    } 

    @Test 
    public void givenJSONArray_ExpectsListofData(){
        List<Data> dataset = new LTPhoto().parseJSONList(jsoninput);

        assertNotNull(dataset);
    } 

}
