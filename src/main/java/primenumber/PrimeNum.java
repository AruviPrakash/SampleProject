package primenumber;

import java.util.Scanner;

public class PrimeNum {

	public static void main(String[] args) {
		
		
		int num;
		int i;
		int count=0;
		String primenum =""	;
		
		//Getting the input from the user
		System.out.println("Enter the number");
		
		Scanner ab =new Scanner(System.in);
		
		num=ab.nextInt();
		
		//Logic
		for(i=2;i <=num/2;i++)
		{
		if(num%i==0)
		{
		count++;
		}
		}
		if (count==0 && num!=1)
		System.out.println("The number is PRIME");
		
		if(count!=0)
		System.out.println("The number is NOT  A  PRIME NUMBER");
		
		
	}

}
