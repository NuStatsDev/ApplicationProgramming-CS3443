

public class FibonacciNumber {


	/**
	 * Name: getFibonacciNumbers()
	 * Description: gets the fibonacci sequence of the passed int
	 * @param n
	 * @return
	 */

	public static int[] getFibonacciNumbers(int n) {
		int [] numbers = new int[n + 1];
		numbers [0]=0;
		numbers [1]=1;
		for(int i = 2; i< numbers.length;i++)
		{
				numbers[i] = numbers[i-2]+ numbers[i-1];
		}
		return numbers;
	}

	/**
	 * 	Name:main()
	 * 	Description: prints the contents of the 1d array of the numbers from a certain fib sequence
	 * @param args
	 */
	public static void main(String[] args) {
		int [] numbers = getFibonacciNumbers(10);
		for (int x=0; x < numbers.length;x++)
		{
			System.out.print(numbers[x] +" ");
		}
	}

}