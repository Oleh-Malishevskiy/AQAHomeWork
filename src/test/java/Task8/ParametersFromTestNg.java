package Task8;

import AQA.Task2.Operations;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersFromTestNg {
    private Operations operations=new Operations();

    @Parameters({ "a","expected" })
    @Test
    public void IsDigitTest(char a, boolean expected){

        boolean actualResult= operations.IsDigit(a);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
}
