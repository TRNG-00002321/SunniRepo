import org.junit.Assert;
import org.junit.Test;

import org.revature.mavendemo.util.Calculator;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int x = 10;
        int y = 20;
        int result = 30;
        Assert.assertEquals(result, c.add(x, y));
    }
}
