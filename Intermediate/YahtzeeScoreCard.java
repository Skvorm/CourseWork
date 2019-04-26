

public class YahtzeeScoreCard
{
    private int aceNum,twoNum,threeNum,fourNum,fiveNum,sixNum;//how many times each value occurs in the face value of five die
    private int aceSc=0,twoSc=0, threeSc=0,fourSc=0,fiveSc=0, sixSc=0,upBonusSc=0;//
    private int tripSc=0,quadSc=0,fullHSc=0,yahtzeeSc=0,chanceSc=0,lgStrSc=0,smStrSc=0;
    private int lowT=0,upperT=0;
    private int yahtzeeBonusCt=0;
    private int round=1;
    private int grandT=0;
    public YahtzeeScoreCard()
    {
        aceNum=0;
        aceNum=0;
        twoNum=0;
        threeNum=0;
        fourNum=0;
        fiveNum=0;
        sixNum=0;
        aceSc=0;
        twoSc=0;
        threeSc=0;
        fourSc=0;
        fiveSc=0;
        sixSc=0;

    }

    public YahtzeeScoreCard(int one,int two,int three,int four,int five,int six)//occurences of face value in 5 dice;
    {
        aceNum=one;
        twoNum=two;
        threeSc=three;
        fourNum=four;
        fiveNum=five;
        sixNum=six;

    }
   

    public boolean isGameOver()
    {
        if (round>13)
        {
            return true;
        }
        else
        return false;
    }

    public void setRound(int val)
    {
        round=val;
    }

    public int getRound()
    {
        return round;
    }
    
  //occurences of each value within round
    public void setAce(int val)
    {
        aceNum=val;
    }

    public void setTwo(int val)
    {
        twoNum = val;
    }

    public void setThree(int val)
    {
        threeNum = val;
    }

    public void setFour(int val)
    {
        fourNum = val;
    }

    public void setFive(int val)
    {
        fiveNum = val;
    }

    public void setSix(int val)
    {
        sixNum = val;
    }
    //occurences of each value within round
    public int getAce()
    {
        return aceNum;
    }

    public int getTwo()
    {
        return twoNum;
    }

    public int getThree()
    {
        return threeNum;
    }

    public int getFour()
    {
        return fourSc;
    }

    public int getFive()
    {
        return fiveNum;
    }

    public int getSix()
    {
        return sixNum;
    }
    //value scores across game
    public int scoreAce()
    {
        return aceNum;
        
    }

    public int scoreTwo()
    {
       return 2*twoNum;
     
    }

    public int scoreThree()
    {
       return 3*threeNum;

    }

    public int scoreFour()
    {
        return 4*fourNum;
         
    }

    public int scoreFive()
    {
       return 5*fiveNum;
        
    }

    public int scoreSix()
    {
      return 6*sixNum;
       
    }
    public void setAceScore(int val)
    {
    	aceSc=val;	
    }
    public void setTwoScore(int val)
    {
    	twoSc=val;	
    }
    public void setThreeScore(int val)
    {
    	threeSc=val;	
    }
    public void setFourScore(int val)
    {
    	fourSc=val;	
    }
    public void setFiveScore(int val)
    {
    	fiveSc=val;	
    }
    public void setSixScore(int val)
    {
    	sixSc=val;	
    }
  //score in lower categories-accessor Methods
    public void setTripSc(int val)
    {
         tripSc=val;
    }
     public void setQuadSc(int val)
    {
        quadSc=val;
    }
     public void setFullHSc(int val)
    {
         fullHSc=val;
    }
     public void setSmStrSc(int val)
    {
        smStrSc=val;
    }
    public void setYahtzeeSc(int val)
    {
         yahtzeeSc=val;
    }
    public void setChanceSc(int val)
    {
        chanceSc=val;
    } 
    public int getTripSc()
    {
        return tripSc;
    }
     public int getQuadSc()
    {
        return quadSc;
    }
     public int getFullHSc()
    {
        return fullHSc;
    }
     public int getSmStrSc()
    {
        return smStrSc;
    }
    public int getYahtzeeSc()
    {
        return yahtzeeSc;
    }
    public int getChangeSc()
    {
        return chanceSc;
    } 
    //Score-Mutators
    public void setUpperTotal(int val)
    {
    	upperT=val;
    }
    public void setLowerTotal(int val)
    {
    	lowT=val;
    }
    //methods for testing-used to quickly set all scores of upper/lower sections
 
    public void numSetL()
    {
    }

    
    public int currentDiceValue()//adds current total of dice, for chances,3s and 4s of a kind.
    {
    	int temp;
        temp= scoreAce()+scoreTwo()+scoreThree()+scoreFour()+scoreFive()+scoreSix();
        return temp;
        
    }

    public boolean isFullHouse()
    {
        if (isTriple() &&((aceNum == 2)||(twoNum == 2)||(threeNum == 2)||(fourNum == 2)||(fiveNum == 2)||(sixNum == 2)))
        {
            return true;
        }
        else
            return false;
    }

    public boolean isSmStr()
    {
        if((aceNum >=1)&&(twoNum>=1)&&(threeNum>=1)&&(fourNum>=1))
        {
            return true;
        }
        else if((twoNum >=1)&&(threeNum>=1)&&(fourNum>=1)&&(fiveNum>=1))
        {
            return true;
        }else if((threeNum >=1)&&(fourNum>=1)&&(fiveNum>=1)&&(sixNum>=1))
        {
            return true;
        }
        else 
            return false;
    }

    public boolean isLgStr()
    {
        if((aceNum >=1)&&(twoNum>=1)&&(threeNum>=1)&&(fourNum>=1)&&(fiveNum>=1))
        {
            return true;
        }
        else if((twoNum>=1)&&(threeNum>=1)&&(fourNum>=1)&&(fiveNum>=1)&&(sixNum>=1))
        {
            return true;
        }
        else 
            return false;
    }

    public void setYahtzeeBonus(int bonusYahtzees)
    {
        yahtzeeBonusCt=bonusYahtzees;
    }
    public int getYahtzeeBonus()
    {
        return yahtzeeBonusCt;
    }

    public boolean isTriple()
    {  
        if ((aceNum == 3)||(twoNum == 3)||(threeNum == 3)||(fourNum == 3)||(fiveNum == 3)||(sixNum == 3))
        {
            return true;
        }
        else 
            return false;
    }

    public boolean isQuad()
    {
        if ((aceNum == 4)||(twoNum == 4)||(threeNum == 4)||(fourNum == 4)||(fiveNum == 4)||(sixNum == 4))
        {
            return true;
        }
        else 
            return false;
    }

    public boolean isYahtzee()
    {
        if ((aceNum == 5)||(twoNum == 5)||(threeNum == 5)||(fourNum == 5)||(fiveNum == 5)||(sixNum == 5))
        {
            return true;
        }
        else 
            return false;
    }
    public void scoreTriple()
    {
        if(isTriple())
        {
            tripSc=currentDiceValue();
            
        }
        else
        tripSc=0;
    }

    public void scoreQuad()
    {
        if(isQuad())
        {
            quadSc=currentDiceValue();
        }
        else
        quadSc=0;
    }
    public void scoreFullHouse()
    {
        if(isFullHouse())
        {
            fullHSc=25;
        }
        else 
        fullHSc=0;
    }
    

    public void scoreYahtzee()
    {
        if(isYahtzee())
        {
           yahtzeeSc=50;
        }
        else
        yahtzeeSc=0;
    }

    public void scoreLgStr()
    {
        if(isLgStr())
        {
            lgStrSc=40;
        }
        else
         lgStrSc=0;
    }

    public void scoreSmStr()
    {
        if(isSmStr())
        {
            smStrSc=30;
        }
        else
         smStrSc=0;
    }
    public void scoreChanceSc()
    {
       chanceSc=currentDiceValue();
    }
    public void calcLowerTotal()
    {
    lowT=tripSc+quadSc+fullHSc+smStrSc+lgStrSc+yahtzeeSc+chanceSc;
    }
    public void calcUpperTotal()
    {
    upperT=scoreAce()+scoreTwo()+scoreThree()+scoreFour()+scoreFive()+scoreSix();
    }
    public int getUpperTotal()
    {  
        return upperT;
    }
 

    public int getLowerTotal()
    {
        return lowT;
    }
    public int getCurrentScore()
    { calcUpperTotal();
      calcLowerTotal();
      return upperT+lowT+(getYahtzeeBonus()*100); 
    }
    public void calcGrandTotal()
    {        
      int temp=getCurrentScore();
      if(getUpperTotal()>=63)
      upBonusSc=30;
      grandT=temp+upBonusSc;
    }
    public int getGrandTotal()
    {
        return grandT;
    }

    public void resetRound()
    {
        aceNum=0;
        twoNum=0;
        threeNum=0;
        fourNum=0;
        fiveNum=0;
        sixNum=0;
    }
   
    public void resetGame()
    {
        aceSc=0;
        twoSc=0;
        threeSc=0;
        fourSc=0;
        fiveSc=0;
        sixSc=0;
        lowT=0;
        upperT=0;
        grandT=0;
        aceNum=0;
        twoNum=0;
        threeNum=0;
        fourNum=0;
        fiveNum=0;
        sixNum=0;
        tripSc=0;
        quadSc=0;
        fullHSc=0;
        yahtzeeSc=0;
        chanceSc=0;
        lgStrSc=0;
        smStrSc=0;
        lowT=0;
        upperT=0;
        round=1;
        yahtzeeBonusCt=0;

    }
    public void printScoreCard()
    {
        System.out.println("---------------Current Dice Values---------------");
        System.out.println("1:"+aceNum+" "+"2: "+twoNum+"3: "+threeNum+"4: "+fourNum+"5: "+fiveNum+"6: "+sixNum);
        System.out.println ("ace  : "+ scoreAce());
        System.out.println ("two :  "+ scoreTwo());
        System.out.println ("three: "+ scoreThree());
        System.out.println ("four : "+ scoreFour());
        System.out.println ("five : "+ scoreFive());
        System.out.println ("six  : "+ scoreSix());
        System.out.println ("Upper Total: " +upperT);
        System.out.println("   3 of a kind : " +tripSc);
        System.out.println("   4 of a kind : " +quadSc);
        System.out.println("   Full House  : " +fullHSc);
        System.out.println("Small Straight : " +smStrSc);
        System.out.println("Large Straight : " +lgStrSc);
        System.out.println("    Yahtzee    : " +yahtzeeSc);
        System.out.println("     Chance    : " +chanceSc);
        System.out.println("Yahtzee Bonus:" +(yahtzeeBonusCt*100));        
        System.out.println("lower Total: " +lowT);
        System.out.println("Upper Total: " +upperT);
        System.out.println("Grand Total: " +grandT);        
     
    }


    public static void main(String []args)
    { 
        

    }
}