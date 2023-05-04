package Task8;

import AQA.Task2.Operations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider {
    Operations operations = new Operations();

    @DataProvider
    private Object[][] BoolProvider(){
        int n=5; //number of test data sets
        int m=3; //argument number (int a, int b, int expected)

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{'a',true};
        res[1]= new Object[]{'4',true};
        res[2]= new Object[]{'4',false};
        res[3]= new Object[]{'A',false};
        res[4]= new Object[]{'1',true};
        return res;
    }
    @Test (dataProvider = "BoolProvider")
    public void IsDigitTest(char a , boolean expected ){

        boolean actualResult= operations.IsDigit(a);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @Test (dataProvider = "BoolProvider")
    public void IsLetterTest(char a , boolean expected){
        boolean actualResult= operations.IsLetter(a);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @DataProvider
    private Object[][] UpperLowerProvider(){
        int n=3; //number of test data sets
        int m=3; //argument number (int a, int b, int expected)

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{'a','A'};
        res[1]= new Object[]{'A','a'};
        res[2]= new Object[]{'a','a'};
        return res;
    }
    @Test (dataProvider = "UpperLowerProvider")
    public void ToLowerCaseTest(char a , boolean expected){
        char actualResult= operations.ToUpperCase(a);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @Test
    public void ToUpperCaseTest(char a , boolean expected){
        char actualResult= operations.ToUpperCase(a);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
}
