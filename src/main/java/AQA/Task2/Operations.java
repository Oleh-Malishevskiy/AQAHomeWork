package AQA.Task2;

// V 10: Character Operations
// Objective: To understand and use primitive char type in Java.
// Instructions:
// Declare a char variable.
// Use Character methods (e.g., isDigit, isLetter, toUpperCase, toLowerCase) to manipulate the char.
// Print the result of each operation to the console.


public class Operations {
    public static void main(String[] args)
    {

        Operations operations = new Operations();
        char c1 = 'A', c2 = '4', c3 = 'a';

        System.out.println(
                c1 + " is a digit -> "
                        + operations.IsDigit(c1));
        System.out.println(
                c2 + " is a digit -> "
                        + operations.IsDigit(c2));
        System.out.println(
                c1 + " is a isLetter -> "
                        + operations.IsLetter(c1));
        System.out.println(
                c2 + " is a isLetter -> "
                        + operations.IsLetter(c2));
        System.out.println(
                c3 + " is a toUpperCase -> "
                        + operations.ToUpperCase(c3));
        System.out.println(
                c1 + " is a toLowerCase -> "
                        + operations.ToLowerCase(c1));

    }
    public boolean IsDigit(char a){
        return Character.isDigit(a);
    }
    public boolean IsLetter(char a){
        return Character.isLetter(a);
    }
    public char ToUpperCase(char a){
        return Character.toUpperCase(a);
    }
    public char ToLowerCase(char a){
        return Character.toLowerCase(a);
    }
}

