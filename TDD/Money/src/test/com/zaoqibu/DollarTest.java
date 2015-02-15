package test.com.zaoqibu;

import com.zaoqibu.Dollar;
import junit.framework.TestCase;

/**
 * Created by vwarship on 2015/2/15.
 */
public class DollarTest extends TestCase {
    public void testMultiplication() {
        Dollar dollar = new Dollar(5);
        dollar.times(2);

        assertEquals(10, dollar.getAmount());
    }
}
