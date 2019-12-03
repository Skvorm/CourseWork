using HoloToolkit.Unity;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ToggleTagalong : MonoBehaviour
{
    public GameObject obj;
    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }
    public void enableTagalong()
    {
        obj.GetComponent<SimpleTagalong>().enabled = true;
    }
    public void disableTagalong()
    {
        obj.GetComponent<SimpleTagalong>().enabled = false;
    }
    public void toggle()
    {
        if (obj.GetComponent<SimpleTagalong>().enabled)
            disableTagalong();
        else
            enableTagalong();
    }


}
