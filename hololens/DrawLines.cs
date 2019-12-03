using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DrawLines : MonoBehaviour {
    LineRenderer lR;
    public Vector3 [] Arr;
	// Use this for initialization
	void Start () {
        lR = this.GetComponent<LineRenderer>();
        lR.useWorldSpace = true;
		
	}
    public void updateArr(Vector3[] array)
    {
        Arr = array;
    }
    public void setupPositions()
    {
        lR.positionCount = Arr.Length;
        lR.SetPositions(Arr);
        //lR.endWidth = .2f;
        //lR.startWidth = .2f;
    }
	
	// Update is called once per frame
	void Update () {
        setupPositions();
		
	}
}
