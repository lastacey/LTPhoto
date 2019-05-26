
package net.levi.lt;

import org.junit.Test;
import static org.junit.Assert.*;

public class LTPhotoTest {

    @Test public void givenJSON_ExpectsDataObject() {

        assertNotNull(new LTPhoto().parseJSON(""));
    }



}
