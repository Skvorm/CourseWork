package src.src.hw2;
import java.util.*;

public class Tester {

	public static void main(String[]args)
	{   int popIn, selIn,mutIn,newIn,crossIn,genIn;
		Scanner kb= new Scanner (System.in);
		System.out.println("What is your input bit string");
		String goalInp=kb.nextLine();
		Chromosome goal = new Chromosome(goalInp);
		//input
		System.out.println("Target Color is");
		System.out.println("color R=" + goal.intRG + " G=" + goal.intGG + " B="+ goal.intBG);
		System.out.print("How Many Chromosomes per population? ");
		  popIn=kb.nextInt();
		  System.out.println(popIn);
		 System.out.print("How Many Chromosomes undergo selection? ");
		 selIn= kb.nextInt();
		 System.out.println(selIn);
		 System.out.print("How Many Chromosomes undergo mutation? ");
		 mutIn= kb.nextInt();
		 System.out.println(mutIn);
		 System.out.print("How Many New Chromosomes per Generation? ");
		 newIn= kb.nextInt();
		 System.out.println(newIn);
		 System.out.print("How many crossover pairs? ");
		 crossIn = kb.nextInt();
		 System.out.println(crossIn);
		 System.out.print("How generations? ");
		 genIn = kb.nextInt();
		 System.out.println(genIn);
		  Generator g = new Generator(goalInp,popIn,selIn,mutIn,newIn,crossIn,genIn);
		  g.runGenerator();

			
		}
		 
		
		
	}

