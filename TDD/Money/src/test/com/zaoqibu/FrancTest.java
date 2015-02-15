package test.com.zaoqibu;

import com.zaoqibu.Franc;
import junit.framework.TestCase;

/**
 * Created by vwarship on 2015/2/16.
 */
public class FrancTest extends TestCase {
    public void testMultiplication() {
        Franc franc = new Franc(5);

        assertEquals(new Franc(10), franc.times(2));
        assertEquals(new Franc(15), franc.times(3));
    }
}
