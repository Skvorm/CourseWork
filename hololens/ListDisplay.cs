using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ListDisplay : MonoBehaviour {
    public ObjectSpawner objectSpawner;
    public GameObject TextParent;
    private List<GameObject> objectList;
    public GameObject LineRendererParent;
   private DrawLines dL;

    TextMesh t;

    // Use this for initialization
    void Start() {
        objectList = objectSpawner.GetList();
        if (TextParent != null)
        t = TextParent.GetComponent<TextMesh>();
        dL = LineRendererParent.GetComponent<DrawLines>();
    }
    public string PrintList(List<GameObject> list)
    { string temp="";
        foreach(GameObject obj in list)
        {
            temp += (obj.name+"::"+obj.transform.position+ "\n");
        }
        return temp;
    }
    public static Vector3[] pointArr(List<GameObject> list)
    { Vector3[] vectArr = new Vector3[list.Count];
        for(int x=0;x<list.Count;x++)
        {
            vectArr[x] = list[x].transform.position;
        }
        return vectArr;
    }
    
	
	// Update is called once per frame
	void Update () {
        objectList = objectSpawner.GetList();
        dL.updateArr(pointArr(objectList));
        dL.setupPositions();

        t.text = objectList.Count+ "\n"+
            PrintList(objectList);

    }
}
