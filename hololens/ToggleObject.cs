using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ToggleObject : MonoBehaviour
{
    public GameObject obj;
    public void Activate()
    {

        obj.SetActive(true);
    }
    public void Deactivate()
    {
      obj.SetActive(false);
    }
    public void toggle()
    {
        if (obj.activeSelf)
        {
            Deactivate();
        }
        else
            Activate();
    }

    public void Activate(GameObject o)
    {

        o.SetActive(true);
    }
    public void Deactivate(GameObject o)
    {
        o.SetActive(false);
    }
    public void toggle(GameObject o)
    {
        if (o.activeSelf)
        {
            Deactivate();
        }
        else
            Activate();
    }

}
