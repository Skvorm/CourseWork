using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ListPanelDisplay : MonoBehaviour {
    public ObjectSpawner objectSpawner;
    private List<GameObject> objectList;
    public GameObject LineRendererParent;
    private DrawLines dL;
    // Use this for initialization
    void Start () {
        objectList = objectSpawner.GetList();
        dL = LineRendererParent.GetComponent<DrawLines>();
    }
    void SetupObject(GameObject obj)
    {
        GameObject name = obj.transform.Find("ObjectName").gameObject;
        name.GetComponent<TextMesh>().text = "placehold";


    }


    // Update is called once per frame
    void Update () {
        objectList = objectSpawner.GetList();
        dL.updateArr(ListDisplay.pointArr(objectList));
        dL.setupPositions();
		
	}
}
