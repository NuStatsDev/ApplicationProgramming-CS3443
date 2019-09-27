import java.util.*;
import java.io.*;

public class Bootstrap {
    public static void main ( String [] args ) {

        BigInteger x = new BigInteger("9999999");
        BigInteger y = new BigInteger(11);
        BigInteger z;

        z = x.Add( y ); // works add is done 9/11/2019 //  updated 9/12/2019
        z.Show(); // p r i n t s : 12355    -> done 9/11/2019

        z = x.Subtract(y); // works! sub is done 9/11/2019 // updated 9/12/2019
        z.Show (); // p r i n t s : 12335  -> done 9/11/2019
        y.SetBigInteger(100); // done 9/10/2019
        z = x.Multiply(y); // done 9/11/2019
        z.Show(); // p r i n t s : 1234500  -> done 9/10/2019
        z = x.Divide(100); // done 9/12/2019
        x.Show (); // p r i n t s : 12345
        z = x.Mod(10) ; // done 9/13/2019
        z.Show() ; // p r i n t s : 5
        x.Increment() ; // done 9/12/2019
        x.Show(); // p r i n t s : 12346
        x.Decrement () ; // done 9/12/2019
        x.Show();// p r i n t s : 12345 // done 9/10/2019123
     //   System.out.println(x.toString());

    }

}