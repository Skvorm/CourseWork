using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using UnityEngine;
using UnityEngine.Events;

public class DataRep : MonoBehaviour
{
    sampleValues v;
    public enum DataType { Int, Char, Short, Long, Float, Double, Boolean, String, Data };
    public DataType type;
    private string[] minArr = { "-128", "0", "-2\xB1\xB15", "-2\xB3\xB31", "-2\xB6\xB3", "2\xB-\xB1\x4\xB9", "2\xB-\xB1\xB0\xB7\xB4", "false" };
    private string[] maxArr = { "127", "2\xB1\xB6-1", "2\xB1\xB5-1", "2\xB3\xB1-1", "2\xB6\xB3-1", "2-2\xB-\xB2\xB3)(2\xB1\xB2\xB7)", "2-2\xB-\xB2\xB3)(2\xB1\xB0\xB2xB3)", "true" };
    private Action[] rVals;
    private int[] sizArr = { 8, 16, 16, 32, 64, 32, 64, 1 };
    public string value;
    private string min, max;
    private int size;

    public bool displayType = true;
    public bool initilizeRandomValue = false;


    public string Value
    {
        get
        {
            return value;
        }
    }

    void Start()
    {
        Setup();
        //rVals={v.getRInt(),v.getRChar(),v.getRShort(),v.getRLong(),v.getRDouble(),v.getRBool()};
        v = this.GetComponent<sampleValues>();
        if (initilizeRandomValue)
        {
            String tmp = "";
            switch ((int)type)
            {
                case 0:
                    tmp += v.getRInt();
                    break;
                case 1:
                    tmp += v.getRChar();
                    break;
                case 2:
                    tmp += v.getRShort();
                    break;
                case 3:
                    tmp += v.getRLong();
                    break;
                case 4:
                    tmp += v.getRFloat();
                    break;
                case 5:
                    tmp += v.getRDouble();
                    break;
                case 6:
                    tmp += v.getRBool();
                    break;
                case 7:
                    tmp = "Text";
                    break;
                default:
                    tmp = "Data";
                    break;
            }
            SetValue(tmp);

        }


    }
    public void changeType(DataType t)
    {
        type = t;
    }
    void OnValidate()
    {
        Setup();


    }
    public void SetValue(string val)
    {
        TextMesh t = this.transform.GetChild(1).GetComponentInChildren<TextMesh>();
        t.text = val;
    }
    public void SetUpperText(string val)
    {
        TextMesh t = this.transform.GetChild(2).GetComponentInChildren<TextMesh>();
        t.text = val;
    }
    public void setNodeText(string val)
    {
        TextMesh t = this.transform.GetChild(3).GetComponentInChildren<TextMesh>();
        t.text = val;
    }

    public void Setup()
    {
        int tmp = (int)type;
        SetValue(value);
        if (displayType)
            SetUpperText(type.ToString());
        else
            SetUpperText("");
        if (tmp <= 6)
        {
            min = minArr[tmp];
            max = maxArr[tmp];
            size = sizArr[tmp];
        }

    }
}
