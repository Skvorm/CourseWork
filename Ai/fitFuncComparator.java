package src.src.hw2;
import java.util.Comparator;

class FitFuncComparator implements Comparator<Chromosome>
	{
		public int compare(Chromosome c,Chromosome c2)
		{
				if (c.getFitFunc()>c2.getFitFunc())
				return 1;
				else if (c.getFitFunc()==c2.getFitFunc())
					return 0;
				else 
					return -1;
		}
	}