package src.src.hw2;
import java.util.*;
public class Generator {
ArrayList <Chromosome> popList;
ArrayList<Chromosome> nextGen= new ArrayList<Chromosome>();
Random r = new Random();
String goal;
int popSize, sel,mut,nB,cross,genNum;
public Generator(String g,int popIn,int selIn,int mutIn, int newIn, int crossIn, int genIn)
{ 
	goal = g ;//input string =goal
	popSize=popIn;//popIn=chromosomes per population
	sel=selIn;//selIn=Chromosomes that undergo selection
	mut=mutIn;//mutIn=mutated Chromosomes
	nB=newIn;//newIn newblood Chromosomes
	cross=crossIn;//crossIn crossover pairs
	genNum=genIn;//genIn generations
    popSize=popIn;
    popList = new ArrayList<Chromosome>();
	for (int x=0;x<popSize;x++)
	{ 
		popList.add(new Chromosome(goal));	
	}
	popList.sort(new FitFuncComparator());
//	for (int x=0;x<popSize;x++)
//	{
//		System.out.println(popList.get(x).getFitFunc());
//	}
}
private String crossOverOne(Chromosome c,Chromosome c2,int pos)
{ 
	
	String cSect1=c.seq.substring(0,pos);
   String c2Sect2=c2.seq.substring(pos);
	String seq=cSect1+c2Sect2;
	return seq;
}
private String crossOverTwo(Chromosome c,Chromosome c2,int pos)
{ 
   String c2Sect1=c2.seq.substring(0,pos);
   String cSect2=c.seq.substring(pos);
   
	String seq=c2Sect1+cSect2;
	return seq;
}
public void crossOver(int pos1,int pos2)
{ int pos= r.nextInt(24);
  Chromosome c=popList.get(pos1);
  Chromosome c2=popList.get(pos2);
  nextGen.add( new Chromosome (crossOverOne(c,c2,pos)));
  nextGen.add( new Chromosome (crossOverTwo(c,c2,pos)));
}
public int selectPos()
{
	return r.nextInt(popSize);
}
public int tSelect()
{ int r1= r.nextInt(popSize);
  int r2= r.nextInt(popSize);
	if (r1<r2)
		return r1;
	else if
	   (r1==r2)
		return r1;
	else 
		return r2;
}
public void runGenerator()
{  
	Chromosome best= new Chromosome(goal,"000000000000000000000000");
	Chromosome overallBest= new Chromosome(goal,"000000000000000000000000");
	int pos;
	int pos2;
	int bestGen=0;
	for(int x=0;x<genNum;x++)
	{ 
		for(int s=0;s<sel;s++)
		{ pos=tSelect();
			nextGen.add(popList.get(pos));
			
		}
		for(int m=0;m<mut;m++)
		{ 
		 pos=tSelect();
		 popList.get(pos).mutate(1);
		 nextGen.add(popList.get(pos));
		 
		}
		for(int n=0;n<nB;n++)
		{
			 pos=tSelect();
			 popList.get(pos).mutate(24);
			 nextGen.add(popList.get(pos));
		}
		for(int c=0;c<cross;c++)
		{
			 pos=tSelect();
			 pos2=tSelect();
			 crossOver(pos,pos2);
		}
		nextGen.sort(new FitFuncComparator());
		
		best=nextGen.get(0);
		if(best.getFitFunc()<overallBest.getFitFunc())
		{
			overallBest=best;
			bestGen=x;
		}
		System.out.println("after generation "+ x + " the best fit Chromosome is "+ best);
		best.printRGB();
		System.out.println("with a distance of " + best.getFitFunc() + " units from the goal");
		System.out.println();
		
//		for(int y=0;y<nextGen.size();y++)
//		{
//			System.out.println((y+1)+ ":"+ nextGen.get(y)+ " : "+nextGen.get(y).getFitFunc());
//		}
		popList.clear();
		popList.addAll(nextGen);
		nextGen.clear();
	}
	System.out.println("---Generation finished---");
	System.out.println("best remaining chromosome is " + best);
	System.out.println("With a value of "+ best.getFitFunc());
	System.out.println("(Best Overall Chromosome is " + overallBest + "-from Generation "+bestGen);
	System.out.println("With a value of "+ overallBest.getFitFunc()+")");
}
}

