package JunitTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

/**
 * zhongliang 2018/4/21.
 */
public class JunitTest {
    @Test
    public void testAdd(){
        int num= 5;
        String temp= null;
        String str= "Junit is working fine";
        Assert.assertEquals("Junit is working fine", str);
        Assert.assertFalse(num > 6);
        Assert.assertNull(temp);

    }
}

