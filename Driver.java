import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) {

       double [] c1 = {6, -2, 5};
       int [] e1 = {0, 1, 3};
       Polynomial p1 = new Polynomial(c1, e1);


       double[] c2 = {2, -3, 3, -4};
       int[]    e2 = {1,  2, 3,  4};
       Polynomial p2 = new Polynomial(c2, e2);

       System.out.println("ADD");
       Polynomial np = p1.add(p2);
       for (int i = 0; i < np.coefficients.length; i++)
           System.out.print(np.coefficients[i] + " ");
       System.out.println();

        for (int i = 0; i < np.exponents.length; i++)
            System.out.print(np.exponents[i] + " ");
        System.out.println();

        System.out.println("MULTIPLY");
        np = p1.multiply(p2);
        for (int i = 0; i < np.coefficients.length; i++)
            System.out.print(np.coefficients[i] + " ");
        System.out.println();

        for (int i = 0; i < np.exponents.length; i++)
            System.out.print(np.exponents[i] + " ");
        System.out.println();



       try {
           p1.saveToFile("output.txt");
       } catch (IOException ex1) {
           // TODO;
       }

    }
}