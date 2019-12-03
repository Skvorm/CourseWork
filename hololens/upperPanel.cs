using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class upperPanel : MonoBehaviour {

    public void Activate()
    {
        
            transform.parent.gameObject.SetActive(true);
    }
    public void Deactivate()
    {
        transform.parent.gameObject.SetActive(false);
    }
    public void toggle()
    {
        if (transform.parent.gameObject.activeSelf)
        {
            Deactivate();
        }
        else
            Activate();
    }
    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
