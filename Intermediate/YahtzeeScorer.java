public class YahtzeeScorer

{  
    //private int v1,v2,v3,v4,v5;
    private int aceC,twoC,threeC,fourC,fiveC,sixC;
    private Die [] arrCopy=new Die[5];;
    YahtzeeScoreCard yd;
    public YahtzeeScorer(Die [] dieArr)
    {
        for(int x=0;x<=4;x++)
        {
            arrCopy[x]=dieArr[x];            
        }

        countDie();
        yd= new YahtzeeScoreCard(aceC,twoC,threeC,fourC,fiveC,sixC);
    }

    private void countDie()
    {
        for(int x=0;x<=4;x++)
        {
            if(arrCopy[x].getCurrentValue()==1)
                aceC++;
            if(arrCopy[x].getCurrentValue()==2)
                twoC++;
            if(arrCopy[x].getCurrentValue()==3)
                threeC++;
            if(arrCopy[x].getCurrentValue()==4)
                fourC++;
            if(arrCopy[x].getCurrentValue()==5)
                fiveC++;
            if(arrCopy[x].getCurrentValue()==6)
                sixC++;     
        }
        
    }

    public void printC()
    {
        System.out.println(aceC+" "+twoC+" "+threeC+ " "+ fourC+" "+fiveC+" "+sixC);
    }

    public int calcCategoryScore()
    {   
        int temp=0;
        if(yd.isYahtzee())
        {   
            temp=50;
        }
        else if (yd.isQuad())
        {
            temp= yd.currentDiceValue();   
        }
        else if (yd.isTriple())
        {
            temp =yd.currentDiceValue();
        }
        if(yd.isLgStr())
        {
            temp=40;
        }
        else if (yd.isSmStr())
        {
            temp=30;

        }
        if(yd.isFullHouse())
        {
            temp=25;
        }
        else
            temp=yd.currentDiceValue();
        return temp;

    }

    public String calcCategoryString()
    {String temp="";
       if(yd.isYahtzee())
        {   
            temp="Yahtzee";
        }
        else if (yd.isQuad())
        {
            temp= "Four of a Kind";   
        }
        else if (yd.isTriple())
        {
            temp ="Three of a Kind";
        }
        else if(yd.isLgStr())
        {
            temp="Large Straight";
        }
        else if (yd.isSmStr())
        {
            temp="Small Straight";

        }
        else if(yd.isFullHouse())
        {
            temp="Full House";
        }
        else
            temp="Chance";
           
        return temp;

    }

    public static void main(String [] args)
    {
        Die die1 = new Die();
        die1.roll();
        Die die2 = new Die();
        die2.roll();
        Die die3 = new Die();
        die3.roll();
        Die die4 = new Die();
        die4.roll();
        Die die5 = new Die();
        die5.roll();
        Die [] arr = {die1,die2,die3,die4,die5};
        System.out.println("Die: "+ die1.getCurrentValue()+" "+die2.getCurrentValue()+" "+die3.getCurrentValue()+ " " +die4.getCurrentValue()+ " "+die5.getCurrentValue());
        YahtzeeScorer ys = new YahtzeeScorer(arr);
        ys.printC();
        System.out.println("Score is a "+ys.calcCategoryString() + "with a score of  "+ys.calcCategoryScore());
    }

}