import java.util.*;

/**
 * Name: BigInteger
 * Description: takes in a char[],String, or long number and creates a BigInteger number to be able to preform Addition
 * , Subtraction, Multiplication, Division, Modulo Division, Incrementation, and Decrementation on.
 * History:       9/10/2019 - Started project.... Finished Add and Started Subtract
 *                9/11/2019 - Finished Subtract,Multiply,Divide,Modulo,Increment, and Decrement
 *                9/12/2019 - Updated Add and Subtract no using ArrayLists and Stacks instead of just Strings
 *                9/17/2019 - Added better documentation and modularized the code a tad still needs more work!
 */
public class BigInteger {

    private int length = 0;
    private String Num = "";

// ---------------------------------------------------------------------------------------------------------------------
// constructors --------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
    /**
     * Name: BigInteger()
     * Description: Constructor that takes a char[] as a param and sets
     * it to the classes String Num for further use and sets the
     * Length of the value passed.
     *
     * @param a - char array passed in to BigInteger constructor
     */
    BigInteger(char a[]) {
        Num = char2String(a);
        // sets the length
        length = Num.length();
    }

    /**
     * Name: BigInteger()
     * Description: Constructor that initializes Num with a long value
     * n and sets Length. You need to convert the long n to a
     * string in this case.
     *
     * @param n - long number
     */
    BigInteger(long n) {
        //sets the value
        Num += n;
        //sets the length
        length = Num.length();
    }

    /**
     * Name: BigInteger()
     * Description: Constructor that takes in a String and sets it to the classes String to store the number value
     * and set the length of the passed parameter.
     *
     * @param n
     */
    BigInteger(String n) {
        Num = n;
        length = Num.length();
    }

    /**
     * Name: BigInteger()
     * Description: Default Constructor. everything is set to be empty but is still created for further manipulation.
     */
    BigInteger() {
        String a ="0";
        SetBigInteger(a);
    }
// ---------------------------------------------------------------------------------------------------------------------
// private methods -----------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------

    /**
     * Name: char2String()
     * Description: Converts a char[] to a String for an easier time
     *
     * @param a
     * @return /String
     */
    private String char2String(char[] a) {
        String convertedCharArry = "";
        for (int i = 0; i < a.length; i++) {
            convertedCharArry += a[i];
        }
        return convertedCharArry;
    }

    /**
     * Name: string2ARLst()
     * Description: converts a string to an ArrayList<String>
     *
     * @param s
     * @return ArrayList</ String>
     */
    private ArrayList<String> string2ARLst(String s) {
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            a.add(s.charAt(i) + "");

        }
        return a;
    }

    /**
     * Name: getCharVal
     * Description: receives a Single character string and returns its numerical value
     * only single digit numbers should be passes here
     *
     * @param x
     * @return int
     */
    private int getCharVal(String x) {
        return Character.getNumericValue((x.charAt(x.length() - 1)));
    }

    /**
     * Name:getString()
     * Description: returns the string equivalent of a stack of strings.
     *
     * @param x - LinkedStackOfStrings
     * @return
     */
    private String getString(LinkedStackOfStrings x) {
        String s = "";
        if (x.isEmpty()) {
            return "";
        }
        return s += x.pop() + getString(x); // <- thought this way seemed cool why not ¯\_(ツ)_/¯
    }

    /**
     * Name: populate()
     * Description: populates a stack of strings by iterating through a string one character at a time while pushing
     * each character onto the stack starting from the 0th index of the the string
     *
     * @param x - String
     * @return
     */
    private LinkedStackOfStrings populate(String x) {
        LinkedStackOfStrings s = new LinkedStackOfStrings();
        while (!x.isBlank()) {
            s.push("" + x.charAt(0));
            x = x.substring(1, x.length());
        }
        return s;
    }

    /**
     * Name: leadingZeroFormatting()
     * Description: Formats the passed String to rid itself of all leading 0s. this is purely  cosmetic and does not
     * do anything to the actual values.
     *
     * @param s - String
     * @return3
     */
    private String leadingZeroFormatting(String s) {
        while (s.charAt(0) == '0') {
            s = s.substring(1, s.length());
        }
        return s;
    }

    /**
     * Name: getNum()
     * Description: gets the "Num" of the BigInteger
     *
     * @return
     */
    private String getNum() {
        return Num;
    }

    /**
     * Name: emptyList()
     * Description: "empties" an array list still needing to get some addition done on it.
     *
     * @param biggerList - ArrayList</String>
     * @param carry      - LinkedStackOfStrigns
     * @return
     */
    private String emptyList(ArrayList<String> biggerList, LinkedStackOfStrings carry) {
        int currentVal = 0, carryAdder = 0, total = 0;
        String carryGetter = "";
        LinkedStackOfStrings keep = new LinkedStackOfStrings();

        while (!(biggerList.isEmpty())) {
            currentVal = getCharVal(biggerList.get(biggerList.size() - 1));
            if (!carry.isEmpty()) {
                carryGetter = carry.pop();
                carryAdder = getCharVal(carryGetter);
            }
            total = currentVal + carryAdder;
            keep.push("" + total % 10);
            carry.push("" + total / 10);
            biggerList.remove(biggerList.size() - 1);
        }
        if (!carry.isEmpty()) {
            keep.push(carry.pop());
        }

        if (!carry.isEmpty()) {
            keep.push(carry.pop());
        }

        return getString(keep);
    }
    // overloaded
    private String Add(String s1, String s2) {
        LinkedStackOfStrings keep = new LinkedStackOfStrings();
        LinkedStackOfStrings carry = new LinkedStackOfStrings();
        int xVal = 0, yVal = 0, total = 0, carryAdder = 0;
        String carryGetter = "";
        ArrayList<String> x, y;
        x = string2ARLst(s1);
        y = string2ARLst(s2);

        while (!(x.isEmpty() || y.isEmpty())) {
            xVal = getCharVal(x.get(x.size() - 1));
            yVal = getCharVal(y.get(y.size() - 1));
            if (!carry.isEmpty()) {
                carryGetter = carry.pop();
                carryAdder = getCharVal(carryGetter);
            }
            total = xVal + yVal + carryAdder;
            keep.push("" + total % 10);
            carry.push("" + total / 10);
            x.remove(x.size() - 1);
            y.remove(y.size() - 1);
        }

        if (!x.isEmpty()) {
            keep.push(emptyList(x, carry));
        } else if (!y.isEmpty()) {
            keep.push(emptyList(y, carry));
        }

        if (!carry.isEmpty()) {
            keep.push(carry.pop());
        }

        return leadingZeroFormatting(getString(keep));
    }

    // overloaded
    private String Subtract(String n, String m) {
        LinkedStackOfStrings keep = new LinkedStackOfStrings();
        LinkedStackOfStrings s1 = new LinkedStackOfStrings();
        LinkedStackOfStrings s2 = new LinkedStackOfStrings();

        int curX = 0, curY = 0, tVal = 0, nineCounter = 0;

        s1 = populate(n);
        s2 = populate(m);

        while (!s2.isEmpty()) {
            curX = getCharVal(s1.pop()); // get the current x val
            curY = getCharVal(s2.pop()); // get the current y val
            if (curX < curY) {
                curX += 10; // if curr x is < y then +10 x
                keep.push("" + (curX - curY)); // keep whatever x-y is
                curX = getCharVal(s1.pop()); // manipulate next value since we need to simulate borrowing
                if (curX == 0) { // if the next val is 0 follow these steps
                    while (curX == 0) {  // while the next value is 0 continue to repeat these steps
                        if (s1.isEmpty()) {
                            break; // end of the list
                        }
                        nineCounter += 1;
                        curX = getCharVal(s1.pop());
                    }
                    tVal = curX; // tVal is the latest thing to get set to curX
                    s1.push("" + (tVal - 1)); // push on the value-1 to the next element to simulate the borrow
                    while (nineCounter > 0) { // adds nines depending on the number of zeros we popped off cause we carried from them
                        s1.push("9");
                        nineCounter -= 1;
                    }
                } else {
                    curX -= 1; // get the current value -1 if the next value was not a zero that we carried from and push it onto stack one
                    s1.push("" + curX);
                }
            } else {
                keep.push("" + (curX - curY)); // x>y so x-y is pushed into keep
            }
        }
        while (!s1.isEmpty()) {
            keep.push(s1.pop()); // adds the remainder of stack one to the keep stack
        }
        // returns the string version of the keep stack
        return leadingZeroFormatting(getString(keep));
    }

    // overloaded
    private String Multiply(String m, String n) {
        int position = 0, traverse = 0, zeroCounter = 0, posCounter = 0, curMVal = 0, curValX = 0, curValY = 0, carry = 0, keep = 0;
        String multi = "", mHolder = m, nHolder = n, str = "";
        ArrayList<String> x, y, stringLineList = new ArrayList<String>();

        // setting the array lists
        x = string2ARLst(mHolder);
        y = string2ARLst(nHolder);

        // ---------------	logic part -----------------

        position = x.size() - 1;
        while (!y.isEmpty()) {

            //while(position >= 0) {
            while (position >= 0) {

                curValX = getCharVal(x.get(position));
                curValY = getCharVal(y.get(y.size() - 1));
                curMVal = (curValX * curValY) + carry;
                keep = curMVal % 10;
                carry = curMVal / 10;
                multi = keep + multi;
                position -= 1;
            }

            if (carry > 0) {
                multi = carry + multi;

            }
            for (int i = 0; i < zeroCounter; i++) {
                multi = multi + "0";

            }
            carry = 0;
            keep = 0;
            stringLineList.add(multi);
            multi = "";
            zeroCounter++;
            position = x.size() - 1;
            y.remove(y.size() - 1);
        }
        multi = "";
        str = "";
        while (!stringLineList.isEmpty()) {
            if (stringLineList.size() != 0) {
                multi = Add(str, (stringLineList.get(stringLineList.size() - 1)));
                str = multi;
                stringLineList.remove(stringLineList.size() - 1);
            } else {

                break;
            }
        }

        str = leadingZeroFormatting(str);

        return str;

    }

// ---------------------------------------------------------------------------------------------------------------------
// public methods ------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------

    /**
     * Name: SetBigInteger()
     * Description: sets the Num of the big integer with the passed char[]
     *
     * @param a
     */
    public void SetBigInteger(char a[]) {
        Num = "";
        //sets the bigint
        for (int i = 0; i < a.length; i++) {
            Num += a[i];
        }
        // sets the length
        length = Num.length();
    }

    /**
     * Name: SetBigInteger()
     * Description: sets the Num of the big integer with the passed long value
     *
     * @param n
     */
    public void SetBigInteger(long n) {
        Num = "";
        // sets the values
        Num += n;
        //sets the length
        length = Num.length();
    }

    /**
     * Name: SetBigInteger()
     * Description: sets the Num of the big integer with the passed String
     *
     * @param s
     */
    public void SetBigInteger(String s) {
        Num = "";
        // sets the value
        Num = s;
        //sets the length
        length = Num.length();
    }

    /**
     * Name: Add()
     * Description: Adds the Nums of the current and passed BigIntegers and then returns a newly created BigInteger.
     * using ArrayList<String> and Stacks because I wanted to try both at the same time.
     *
     * @param n
     * @return BigInteger
     */
    public BigInteger Add(BigInteger n) {
        String carryGetter = "", s1 = n.getNum(), s2 = Num;
        LinkedStackOfStrings keep = new LinkedStackOfStrings();
        LinkedStackOfStrings carry = new LinkedStackOfStrings();
        int xVal = 0, yVal = 0, total = 0, carryAdder = 0;
        ArrayList<String> x, y;
        x = string2ARLst(s1);
        y = string2ARLst(s2);

        if(n.Num.equals("0")){
            return new BigInteger(Num);
        }

        // if any of the lists become empty just append the remainer to the front of the ending value
        while (!(x.isEmpty() || y.isEmpty())) {
            xVal = getCharVal(x.get(x.size() - 1)); // gets the current x value
            yVal = getCharVal(y.get(y.size() - 1)); // gets the current y value
            if (!carry.isEmpty()) { // if carry is not empty set the into to add into ouy total
                carryGetter = carry.pop();
                carryAdder = getCharVal(carryGetter);
            }
            total = xVal + yVal + carryAdder; // total = x+y+carry
            keep.push("" + total % 10); // we keep total%10      ex.) if the total was 19 then 19%10 is 9 which is what we want
            carry.push("" + total / 10); // we carry total/10    ex.) if the total was 19 then 19/10 is 1 which is the carry we want
            x.remove(x.size() - 1); // removes the last x value since we wont be needing it anymore
            y.remove(y.size() - 1); // removes the last y value since we wont be needing it anymore
        }

        if (!x.isEmpty()) { // if x is not empty slap the rest onto the stack in the proper order
            keep.push(emptyList(x, carry));
        } else if (!y.isEmpty()) { // if y is not empty slap the rest onto the stack in the proper order
            keep.push(emptyList(y, carry));
        }

        if (!carry.isEmpty()) { // if there is anything left in carry then add it to the end of the stack
            keep.push(carry.pop());
        }

        s1 = "";
        s1 = leadingZeroFormatting(getString(keep));
        return new BigInteger(s1);

    }

    /**
     * Name: Subtract()
     * Description: Takes in a BigInteger and subtracts that from the Current BigInteger using some stacks which was a
     * part of today's lecture so i figured i'd get some practice in with them.
     * @param n
     * @return BigInteger
     */
    public BigInteger Subtract(BigInteger n) {
        LinkedStackOfStrings keep = new LinkedStackOfStrings();
        LinkedStackOfStrings s1 = new LinkedStackOfStrings();
        LinkedStackOfStrings s2 = new LinkedStackOfStrings();
        String formattedString = "";
        int curX = 0, curY = 0, tVal = 0, nineCounter = 0;
        // populate the stacks with the string values we are operating on
        s1 = populate(Num);
        s2 = populate(n.getNum());

        if(n.Num.equals("0")){
            return new BigInteger(Num);
        }

        while (!s2.isEmpty()) {
            curX = getCharVal(s1.pop()); // get the current x val
            curY = getCharVal(s2.pop()); // get the current y val

            if (curX < curY) {
                curX += 10; // if curr x is < y then +10 x
                keep.push("" + (curX - curY)); // keep whatever x-y is
                curX = getCharVal(s1.pop()); // manipulate next value since we need to simulate borrowing
                if (curX == 0) { // if the next val is 0 follow these steps
                    while (curX == 0) {  // while the next value is 0 continue to repeat these steps
                        if (s1.isEmpty()) {
                            break; // end of the list
                        }
                        nineCounter += 1;
                        curX = getCharVal(s1.pop());
                    }
                    tVal = curX; // tVal is the latest thing to get set to curX
                    s1.push("" + (tVal - 1)); // push on the value-1 to the next element to simulate the borrow
                    while (nineCounter > 0) { // adds nines depending on the number of zeros we popped off cause we carried from them
                        s1.push("9");
                        nineCounter -= 1;
                    }
                } else {
                    curX -= 1; // get the current value -1 if the next value was not a zero that we carried from and push it onto stack one
                    s1.push("" + curX);
                }
            } else {
                keep.push("" + (curX - curY)); // x>y so x-y is pushed into keep
            }
        }
        while (!s1.isEmpty()) {
            keep.push(s1.pop()); // adds the remainder of stack one to the keep stack
        }
        // returns the string version of the keep stack
        formattedString = leadingZeroFormatting(getString(keep));
        return new BigInteger(formattedString);
    }

    /**
     * Name: Multiply()
     * Description: Multiplies big numbers using strings and array lists which were some of the topics for the lecture
     * today. Taking in a passed BigInteger and the one already in use to perform the calculations.
     *
     * @param n - BigInteger
     * @return
     */
    public BigInteger Multiply(BigInteger n) {
        int position = 0, zeroCounter = 0, posCounter = 0, curMVal = 0, curValX = 0, curValY = 0, carry = 0, keep = 0;
        String multi = "", mHolder = Num, nHolder = n.getNum(), str = "";
        ArrayList<String> x, y, stringLineList = new ArrayList<String>();

        // setting the array lists
        x = string2ARLst(mHolder);
        y = string2ARLst(nHolder);

        if(n.Num.equals("0")){
            return new BigInteger("0");
        }

        // ---------------	logic part -----------------
        position = x.size() - 1;
        while (!y.isEmpty()) {

            //while(position >= 0) {
            while (position >= 0) {
                // get the two current values we are multiplying
                curValX = getCharVal(x.get(position));
                curValY = getCharVal(y.get(y.size() - 1));
                // current value can be anything x*x
                curMVal = (curValX * curValY) + carry;
                // variables used to store the values that we keep and the value that we carry both are going to be numbers 0-9
                keep = curMVal % 10;
                carry = curMVal / 10;
                // string used to store the value that we calculated
                multi = keep + multi;
                // moving the position back one
                position -= 1;
            }
            // if there is anyhting left in the carry after all calculations are done the slap it in the front of the calculated value
            if (carry > 0) {
                multi = carry + multi;
            }
            // slaps the amount of zeros needed to the back
            for (int i = 0; i < zeroCounter; i++) {
                multi = multi + "0";
            }
            // resets the data stores the ending value and takes off the last value of the value that's being multiplied/
            carry = 0;
            keep = 0;
            stringLineList.add(multi);
            multi = "";
            zeroCounter++;
            position = x.size() - 1;
            y.remove(y.size() - 1);
        }

        multi = "";
        str = "";
        // heres where we add everything to the string from the array list
        while (!stringLineList.isEmpty()) {
            if (stringLineList.size() != 0) {
                multi = Add(str, (stringLineList.get(stringLineList.size() - 1)));
                str = multi;
                str = leadingZeroFormatting(str);

                stringLineList.remove(stringLineList.size() - 1);
            } else {
                break;
            }
        }
        // makes the value nice to look at
        System.out.println(str);
        str = leadingZeroFormatting(str);
        return new BigInteger(str);
    }

    /**
     * Name: Divide()
     * Description: takes in an integer to divide the current big integer
     * taking advantage of the already written coded in subtract
     *
     * @param divider
     * @return BigInteger
     */
    public BigInteger Divide(int divider) {
        Scanner scan = new Scanner(System.in);
        String total = "", numHolder = Num;
        int index = 0, tVal = getCharVal(numHolder.charAt(index) + ""); // tval is the largest number in the BigInteger since its starting from position 0
        index += 1; // get the next position

        while(divider<=0){
            System.out.println("Error: You can't Divide by 0!");
            divider = scan.nextInt();
        }

        while (tVal < divider) { // while the value of the dividend is less than the divisor
            tVal = tVal * 10 + (getCharVal(numHolder.charAt(index) + "")); // the value is now moved ove to the next tens place and we get the value at the next index ie.) old val is 4
            index += 1;                                                        // now we do 4*10 moving it over a tens place so 4-> 40 then we add on the value at the next postion and add it on
        }

        while (numHolder.length() > index) {
            total += (tVal / divider); // get the total by dividing the value we got up top by the divisor
            tVal = (tVal % divider) * 10 + getCharVal("" + numHolder.charAt(index)); // the new value is the remainder of th value/divisor * 10 + the character at the next index point
            index += 1;
        }
        // the final value is finalized after our final time dividing tVal by the divisor
        total += (tVal / divider);
        total = leadingZeroFormatting(total);

        return new BigInteger(total);
    }

    /**
     * Name: Increment
     * Description: Adds 1 to the current BigInteger
     *
     * @return BigInteger
     */
    public BigInteger Increment() {
        Num = Add(Num, "1");
        return new BigInteger(Num);
    }

    /**
     * Name: Decrement()
     * Description: subtracts 1 from the current BigInteger
     *
     * @return BigInteger
     */
    public BigInteger Decrement() {
        Num = Subtract(Num, "1");

        return new BigInteger(Num);
    }

    /**
     * Name: Mod()
     * Description: Gets the Modulo of the current BigInteger using the Divide,Multiply and Subtract Function.
     *
     * @param Divisor
     * @return BigInteger
     */
    public BigInteger Mod(int Divisor) {
        BigInteger Dividend = new BigInteger(getNum());
        String storeD = "", storeM = "", storeS = "", storeDi = Dividend.getNum();
        Scanner scan = new Scanner(System.in);
        while(Divisor<=0){
            System.out.println("Error: You can't Divide by 0!");
            Divisor = scan.nextInt();
        }

        storeD = Dividend.Divide(Divisor).getNum(); // first divides the current BigInteger Value and the divisor
        storeM = Multiply(storeD, "" + Divisor); // next it multiplies the stored division value and multiplies it by the divisor
        storeS = Subtract(storeDi, storeM); // finally we save the value of the stored division value - the stored multiplication value
        Dividend.Num = storeS;// the modulus is equal to the value after we've done the 3 steps above
        return Dividend;
    }

    /**
     * Name: Show()
     * Description: Prints the "Value" of the BigInteger.
     */
    public void Show() {
        System.out.println(getNum());
    }

    /**
     * Name: toString()
     * Descritpion: returns the string representation of the Big Integer
     *
     * @return string
     */
    public String toString() {
        return "BIG INTEGER: " + this.Num + "\n" + "LENGTH: " + this.length;
    }
}
