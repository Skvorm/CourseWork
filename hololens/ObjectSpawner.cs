using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObjectSpawner : MonoBehaviour {
    public GameObject ObjectToSpawn;
    public GameObject ParentObject;
    public List<GameObject> spawnedObjects=new List<GameObject>();
    public int objectCount=0;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    //public Transform t;
    // Use this for initialization
    void Start () {
		
	}
    public void changeObject(GameObject newObj)
    {
        ObjectToSpawn = newObj;
    }
    public void spawnObject()
    {
        float x = (ParentObject.transform.position.x+offsetX);
        float y = (ParentObject.transform.position.y+offsetY);
        float z = (ParentObject.transform.position.z+offsetZ);
        GameObject obj = Instantiate(ObjectToSpawn, new Vector3(x,y,z), Quaternion.identity) as GameObject;
        objectCount++;
        obj.name = ObjectToSpawn.name+"("+objectCount+")";
        spawnedObjects.Add(obj);

    }

    public void spawnListObject()
    {
        TextMesh t;
        float x = (ParentObject.transform.position.x + offsetX);
        float y = (ParentObject.transform.position.y + offsetY);
        float z = (ParentObject.transform.position.z + offsetZ);
        GameObject obj = Instantiate(ObjectToSpawn, new Vector3(x, y, z), Quaternion.identity) as GameObject;
        objectCount++;
        obj.name = "Node" + "(" + spawnedObjects.Count + ")";
        spawnedObjects.Add(obj);
        t = obj.transform.GetChild(3).GetComponentInChildren<TextMesh>();
        t.text = "";
        if (spawnedObjects.Count >= 2)
        {


            t = spawnedObjects[spawnedObjects.Count - 2].transform.GetChild(3).GetComponentInChildren<TextMesh>();
            t.text = "Node" + "(" + (spawnedObjects.Count-1) + ")";
        }




    }
    public void spawnListObject(GameObject newObj)
    {
        changeObject(newObj);
        spawnListObject();
    }
    public void spawnObject(GameObject newObj)
    {
        changeObject(newObj);
        spawnObject();
    }
    public void clearObjects()
    {
        foreach(GameObject obj in spawnedObjects)
        {
            Destroy(obj);
        }
        spawnedObjects.Clear();
    }
    public List<GameObject> GetList()
    {
        return spawnedObjects;
    }
	
	// Update is called once per frame
	//void Update () {
	//	
	//}
}
