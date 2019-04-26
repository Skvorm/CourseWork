package src.src.hw2;
import java.util.*;
public class Chromosome {
	String seq;
	int intR,intG,intB;
	String binR,binB,binG;//binary string representations of RGB sections 
	String goalSeq;
	int intRG,intGG,intBG;
	String binRG,binBG,binGG;
	Random r = new Random();
	//creates Chromosome with manually defined sequence
	public Chromosome(String goal,String sequence)
	{   seq=sequence;
		goalSeq=goal;
		setupSections();
		setupGoalSections();
		setupInt();
	 
	}
	//creates Chromosome with random sequence
	public Chromosome(String s)
	{   seq=generateRandom();
	    goalSeq=s;	
		setupSections();
		setupGoalSections();
		setupInt();
	
	}
	public String generateRandom()
	{ String temp="";
	  int val;
		for (int x=0;x<=23;x++)
		{   val=r.nextInt(2);
			temp+=val;
			
		}
		return temp;
	
	}
	private void setupSections()
	{   String tempS="";
		int tempI=0;
		for (int x=0;x<=7;x++)
		{
			tempI=(int)seq.charAt(x)-48;			
		    tempS+=tempI;
			
		}
		binR=tempS;
		tempS="";
		for (int x=8;x<=15;x++)
		{	
			tempI=(int)seq.charAt(x)-48;		
			tempS+=tempI;	
	}
		binB=tempS;
		tempS="";
		for (int x=16;x<=23;x++)
		{
			tempI=(int)seq.charAt(x)-48;			
		    tempS+=tempI;
			
		}
		binG=tempS;
	}
	
	private void setupGoalSections()
	{   String tempS="";
		int tempI=0;
		for (int x=0;x<=7;x++)
		{
			tempI=(int)goalSeq.charAt(x)-48;		
		    tempS+=tempI;
			
		}
		binRG=tempS;
		tempS="";
		for (int x=8;x<=15;x++)
		{	
			tempI=(int)goalSeq.charAt(x)-48;		
			tempS+=tempI;	
	}
		binBG=tempS;
		tempS="";
		for (int x=16;x<=23;x++)
		{
			tempI=(int)goalSeq.charAt(x)-48;			
		    tempS+=tempI;
			
		}
		binGG=tempS;
	}
	
	private void setupInt()
	{
		intR=convInt(binR);
		intG=convInt(binB);
		intB=convInt(binG);
		intRG=convInt(binRG);
		intGG=convInt(binBG);
		intBG=convInt(binGG);
	}
	
	public int convInt(String s)
	{
		return Integer.parseInt(s,2);
	}

	public void printRGB()
	{
		System.out.print("(R="+intR+":G="+ intG+ ":B="+intB+") ");
	}
	public int getFitFunc()//more similar = lower number
	{ 
		double rval=(double)(intRG-intR);
		double gval=(double)(intGG-intG);
		double bval = (double)(intBG-intB);
		double rgbval = (Math.pow(rval,2)+Math.pow(gval,2)+Math.pow(bval,2));
		return (int)Math.sqrt(rgbval);
	}
	
	
	public void mutate(int factor)
	{   int [] sArr = new int[24];
	    for(int x=0;x<=23;x++)
	    {
	    	sArr[x]=seq.charAt(x)-48;
	    }
		String temp="";

		int pos=0;
		//System.out.println(" pre-mutate seq is"+ seq);
		for (int x=0;x<factor;x++)
			{
			pos=r.nextInt(24);
		if(sArr[pos]==1)
		{
			sArr[pos]=0;
			//System.out.println(":changing pos" + pos + " to 0");
		}
		else
		{
			sArr[pos]=1;
			//System.out.println(":changing pos" + pos + " to 1");
			
		}
			}
		for(int y=0;y<=23;y++)
		{
			temp+=sArr[y];
		}

		seq=temp;
	
		setupSections();
		setupInt();
	}

	public String toString()
	{
		return seq;
	}
	


	

}
