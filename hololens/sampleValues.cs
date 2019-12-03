using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class sampleValues : MonoBehaviour
{
    //2 variations of each
    //1st gets random value of type
    //2nd retrieves a static example of type
    System.Random r = new System.Random();
    public float floatValue;
    public char charValue='a';
    public int intValue;
    public short shortValue;
    public long longValue;
    public bool booleanValue;
    public double doubleValue;

    public float getRFloat()
    {
        float f = (float)r.NextDouble()*100;
        return f;
    }
    public float getSFloat()
    {
        return floatValue;
    }
    public int getRInt()
    {
        int fl = r.Next(100);
        return fl ;
    }
    public float getSInt()
    {
        return intValue;
    }
    public char getSChar()
    {
        return charValue;
    }
    public char getRChar()
    {
        return (char)getRInt();
    }
    public short getSShort()
    {
        return (short)3.5;
    }
    public short getRShort()
    {
        short s = (short)(r.NextDouble()*100);
        return s;
    }
    public long getSLong()
    {
        return (long)3.5;
    }
    public long getRLong()
    {
        return (long)r.NextDouble()*100;
    }
    public bool getSBool()
    {
        return true;
    }
    public bool getRBool()
    {
        if (r.Next(2) >= 1)
            return true;
        else
            return false;
    }
    public double getSDouble()
    {
        return 3.5;
    }
    public double getRDouble()
    {
        return r.NextDouble()*100;
    }
    public void SetAll(double val)
    {
        floatValue = (float)val;
        intValue = (int)val;
        charValue = (char)val;
        doubleValue = val;
        shortValue = (short)val;
        longValue = (long)val;

    }
    public void SetAll(char ch)
    {

    }
}

    



