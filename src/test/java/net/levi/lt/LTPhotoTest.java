
package net.levi.lt;

import org.junit.Test;
import net.levi.lt.LTPhoto.Data;
import static org.junit.Assert.*;

public class LTPhotoTest {

    @Test public void givenJSON_ExpectsDataObject() {
        Data datum = new LTPhoto().parseJSON("{\"id\":1}") ;

        assertNotNull(datum);
        assertEquals(1,datum.id);

    }




}
