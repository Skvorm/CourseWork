using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

public class ObjLineGen : MonoBehaviour {
    //public UnityEvent eventTrigger;
    //generates from this object's position
    public GameObject baseObj;
    //object to be duplicated
    public GameObject dupObj;
    public BoxCollider cBox;
    //num objects = elements 
    //just used for debugging.
    public int numObj;
    public float gapWidth;
    private float dist;
    private float curDist;
    public GameObject[] lineArr;
    private int[] intArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    private Renderer r;

    /// 
    /// Merging
    ///
    // Use this for initialization
    private TextMesh i;
    private TextMesh v;

    private int elements;
    private int index=0;
    private int value = 0;

    private int prevInd = 0;


    public Color baseColor;
    public Color selectedColor;
    //
    //Merging
    public GameObject vT;
    public GameObject iT;
    public GameObject eT;
    private TextMesh vM;
    private TextMesh iM;
    private TextMesh eM;



    // Use this for initialization
    void Start () {
        if (numObj > 10)
            numObj = 10;
        elements = numObj;
      
        vM = vT.GetComponent<TextMesh>();
        iM = iT.GetComponent<TextMesh>();
        eM = eT.GetComponent<TextMesh>();
        lineArr = new GameObject[10];
        setup();
        setupText();
        updateEleText();
        updateValText();
        updateIndText();
        updateActive();
        UpdateColor();



    }
    public int getNumObj()
    {
        return numObj;
    }
    public void setNumObj(int i)
    {
       numObj=i;
    }
    public float getGapWidth()
    {
        return gapWidth;
    }
    public void setGapWidth(float f)
    {
        gapWidth = f;

    }
    private void UpdateColor()
    {
       lineArr[index].GetComponentInChildren<Renderer>().material.color = selectedColor;
       lineArr[prevInd].GetComponentInChildren<Renderer>().material.color =  baseColor;

    }
    public void updateCube()
    {
        setText(index, 1, value + "");
    }
  

    public void setup()
    {
        elements = numObj;
        //lineArr = new GameObject[numObj];
        for (int x = 0; x < 10; x++)
        {
            float size = baseObj.GetComponent<Renderer>().bounds.size.x;
            float xVal = (((.5f * size) + gapWidth) + baseObj.transform.position.x + ((size * .5f) * x) + (gapWidth * x));
            float yVal = (baseObj.transform.position.y);
            float zVal = (baseObj.transform.position.z);
            GameObject obj = Instantiate(dupObj, new Vector3(xVal, yVal, zVal), Quaternion.identity) as GameObject;
            //obj.transform.localScale = new Vector3(.5f, .5f, .5f);
            obj.transform.parent = baseObj.transform;

            lineArr[x] = obj;
           obj.GetComponentInChildren<Renderer>().material.color = baseColor;
            if (x >= elements)
                lineArr[x].SetActive(false);

        }
       
    }
    public void EnableCollider()
    {
        this.GetComponent<BoxCollider>().enabled = true;
    }
    public void DisableCollider()
    {
        this.GetComponent<BoxCollider>().enabled = false;
    }
    public void ToggleCollider()
    {
        if (this.GetComponent<BoxCollider>().enabled)
        {
            DisableCollider();
        }
        else
            EnableCollider();

    }
    public void setupText()
    {
        for (int x = 0; x < 10; x++)
        {
            setTIndex(x, x);
            setTValue(x, 0);
        }
    }
    public void clearObj()
    {
        for(int x=0;x<10;x++)
        {
            setTValue(x, 0);
        }
    }

    public void updateActive()
    {
        for (int x=0;x<10;x++)
        {
            if (x < elements)
                lineArr[x].SetActive(true);
            else
                lineArr[x].SetActive(false);
        }
    }
        //update method
        //iterates through destroys old obj rebuilds new
        //public void UpdateArr()
        //{
       
        
        //numObj = elements;
        //if(index>numObj)
        //{
        //    index = numObj;
        //    d.setIndex(index);
        //}

        ////clearObj();
        
        //setup();
        


        


    private void setText(int index, int child, string newText)
    {
        //child==1
        //"value" (lower) String
        //child==2
        //index(upper) String
         TextMesh t= lineArr[index].transform.GetChild(child).GetComponentInChildren<TextMesh>();
         t.text = newText;
    }
    public void setTValue(int index, int v)
    {
        setText(index, 1, (v+""));
    }
    public void setTIndex(int index, int v)
    {
        setText(index, 2, (v+""));
    }


    public void incrVal()
    {
        value++;
        updateValText();
        updateCube();
    }
    public void incrIn()
    {
        if(index<9)
        {
            prevInd = index;
            index++;
            UpdateColor();
        }
       
        updateIndText();

    }
    public void incrEle()
    {
        if(elements<10)
        elements++;
        updateEleText();
        updateActive();

    }
    public void decVal()
    {
        if (value > 0)
            value--;
        updateValText();
        updateCube();
    }
    public void decIn()
    {
        if(index>0)
        {
            prevInd = index;
            index--;
            UpdateColor();
        }
       
        updateIndText();

    }
    public void decEle()
    {
        if(elements>0)
        elements--;
        updateEleText();
        updateActive();
    }
    public void updateValText()
    {
        vM.text = value + "";
    }
    public void updateIndText()
    {
        iM.text = index + "";
    }
    public void updateEleText()
    {
        eM.text = elements + "";
    }
    public void setValue(int v)
    {
        
        value = v;
    }
    public void setIndex(int v)
    {
        if (v > 9)
            v = 9;
        else if
            (v < 0)
            v = 0;      
        index = v;
    }
    public void setElements(int v)
    {
        elements = v;
    }
    public int getVal()
    {
        return value;
    }
    public int getIndex()
    {
        return index;
    }
    public int getElements()
    {
        return elements;
    }

}
