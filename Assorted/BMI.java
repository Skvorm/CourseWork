import java.util.*;
public class BMI
{
    public static void main (String [] args)
    {
        Scanner kb = new Scanner(System.in);
        double h= 0,w= 0, bmi= 0;
        String weight,height;
        boolean htick = false, wtick = false, otick = false;
        char input=0,inp=0;
           while(!otick)
        {
        System.out.println("Select Measurement type: Metric or American");
        String userin = kb.nextLine();
        inp = userin.charAt(0);
        input = Character.toUpperCase(inp);
        if (input == 'M')
        {System.out.println("You've entered Metric units");
            while (!htick)
            {System.out.println("Enter height(meters)");
                height = kb.nextLine();
                try
                {
                    h = Double.parseDouble(height);
                    if (h > 0)
                    {htick = true;}
                    else 
                    {
                        htick = false;
                        System.out.println(height + " is an invalid input. Try again.");
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("There was an error in the input. Please Try Again");
                }
            }
            while (!wtick)
            {System.out.println("Enter weight(kilograms)");
                weight = kb.nextLine();
                try
                {w = Double.parseDouble(weight);
                    if (w > 0)
                    wtick = true;
                    else
                    {
                        wtick = false;
                        System.out.println(weight + " is an invalid input. Please Try again");
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("There was an error in the input. Please Try Again");
                }
            }
            bmi = ( w /Math.pow(h,2));
            System.out.println("Your Body Mass Index is " + bmi);
            otick=true;
        }

        else if (input == 'A')
        {System.out.println("You've entered American units");
            while (!htick)
            {System.out.println("Enter height(inches)");
                height = kb.nextLine();
                try
                { h = Double.parseDouble(height);
                    if (h > 0)
                    {htick = true;}
                    else 
                    {
                        htick = false;
                        System.out.println(height + " is an invalid input. Try again.");
                    }
                
                }
                catch (NumberFormatException e)
                {
                    System.out.println("There was an error in the input. Please Try Again");
                }
            }
            while (!wtick)
            {System.out.println("Enter weight(pounds)");
                weight = kb.nextLine();
                try
                {w = Double.parseDouble(weight);
                    if (w > 0)
                    wtick = true;
                    else
                    {
                        wtick = false;
                        System.out.println(weight + " is an invalid input. Please Try again");
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("There was an error in the input. Please Try Again");
                }
            }
            bmi = ( w /Math.pow(h,2)) *703;
            System.out.println("Your Body Mass Index is " + bmi);
            otick=true;
        }

        else
        {
            otick=false;
            System.out.println(userin + " is invalid. Try again");
        }
         
        }
            
        }
    }
 
