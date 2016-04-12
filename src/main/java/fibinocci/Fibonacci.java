package fibinocci;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		int num;
		int first=0;
		int second=1;
		int i;
		int next=0;
		
		//Getting the input from the user
				System.out.println("Enter the number");
				
				Scanner ab =new Scanner(System.in);
				
				num=ab.nextInt();
				
		System.out.println("FIBINOCCI SERIES");
		//System.out.println(first);
		System.out.println(second);
		//Logic		
		for(i=0;i<=num-1;i++)
		{
			while(next<=88)
			{
			next=first+second;
			System.out.println(next);
			first=second;
			second= next;
			}	
			break;
			
		}
					
	}

}
