//HW7  Write a java program to print the following pattern in eclipse console


package Week2;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;

public class PrintPattern {
	public static void main(String[] args) {
		
		
		//To get input
		System.out.println("Enter the number");
		Scanner inp = new Scanner(System.in);
		int num;
		num =inp.nextInt();
		
		
		int x;
		int y;
		int z=1;
		for(x=0;x<=num;x++)
		{
						
			for(y=0;y<z;y++)
			{
				System.out.print("*");
			}
			
			z=z+2;			
			System.out.println();
			
			
		}		
		
	}

}
