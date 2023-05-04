package Task8;

import AQA.Task2.Operations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestTask2 {
    private Operations operations=new Operations();

    @Test
    public void IsDigitTest(){
        //testData
        char c1 = 'A', c2 = '4', c3 = 'a';


        // expected test data
        boolean expected = true;

        boolean actualResult= operations.IsDigit(c2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @Test
    public void IsLetterTest(){
        //testData
        char c1 = 'A', c2 = '4', c3 = 'a';


        // expected test data
        boolean expected = true;

        boolean actualResult= operations.IsLetter(c1);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @Test
    public void ToLowerCaseTest(){
        //testData
        char c1 = 'A', c2 = '4', c3 = 'a';


        // expected test data
        char expected = Character.toLowerCase('A');

        char actualResult= operations.ToUpperCase(c1);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
    @Test
    public void ToUpperCaseTest(){
        //testData
        char c1 = 'A', c2 = '4', c3 = 'a';


        // expected test data
        char expected = Character.toUpperCase('A');

        char actualResult= operations.ToUpperCase(c1);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
}
