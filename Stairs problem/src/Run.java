import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *  given a set of stairs, figure our how many different ways to climb the steps if
 *  you can move 1 ore 2 steps.
 *  
 *  BOUNS: modify the code so that it with an array of numbers as well as 1 or 2 steps
 *  
 * @author Gregory Evevsky
 *
 */
public class Run {

	public static int stepCounter(int steps) {
		switch (steps) {
		case 0:
			return 0;
		case 1: 
			return 1; 
		case 2: 
			return 2; 
		}
		return stepCounter(steps -1) + stepCounter(steps -2);
		
	}
	public static int factorial( int n ) { 
		if(n == 0) { 
			return 1; 
		}else { 
			return factorial( n -1) * n;
		}
	}

	public static int stepCounterB(int steps, int[]moves) {
		if(steps <= 0) {
			return 0;
		}
		// check if steps == smallest number of moves
		// if that is the case return 1;
		if(moves[0] == steps) {
			return 1;
		}
		// if steps is one of the larger numbers,
		//find any multiples in the list.
		// for each one found return 1
		for(int i = 1; i < moves.length; i++) {
			if(steps == moves[i]) {
				int multipleCount =0;
				for(int x = i; x >=0; x--) {
					if(moves[i] % moves[x] == 0) {
						multipleCount ++;
					}
				}
				return multipleCount;
			}
		}
		// solve for each solution until we reach 0
		int give = 0; 
		for( int i = 0; i < moves.length; i ++) {
			give += stepCounterB(steps - moves[i] , moves);
		}
		return give;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("how many steps: ");
			int[] array = { 3,5, 6};
			int give = stepCounterB(sc.nextInt(), array);
			System.out.println("there are " + give + " ways to climb the stairs");
			
		}
		
	}
	
}
