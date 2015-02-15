package test.com.zaoqibu;

import com.zaoqibu.Dollar;
import com.zaoqibu.Franc;
import com.zaoqibu.Money;
import junit.framework.TestCase;

/**
 * Created by vwarship on 2015/2/15.
 */
public class MoneyTest extends TestCase {
    public void testMultiplication() {
        Dollar dollar = new Dollar(5);

        assertEquals(new Dollar(10), dollar.times(2));
        assertEquals(new Dollar(15), dollar.times(3));
    }

    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));

        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
    }
}
