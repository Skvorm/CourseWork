using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PageManager : MonoBehaviour {
    public List<GameObject> pages=new List<GameObject>();
    public int startingPage = 0;
    private int currentPage=0;
    public GameObject TitleParent;
    private TextMesh t;
	// Use this for initialization
	void Start () {
        t = TitleParent.GetComponent<TextMesh>();
        currentPage = startingPage;
        SwitchPage(currentPage, true);
	}
    private void SetName(int page)
    {
        t.text = pages[page].name;
    }
    public void setPage(int page)
    {
        foreach(GameObject g in pages)
        {
            if (g != pages[page])
            {
                g.SetActive(false);
            }
        }
        pages[page].SetActive(true);
        currentPage = page;

    }
    private void SwitchPage(int page,bool setName)
    {
        setPage(page);
        if(setName)
        {
            SetName(page);
        }
    }
    public void SwitchPage(int page)
    {
       SwitchPage(page,true);
    }
 
    public void NextPage()
    {
        if(currentPage<pages.Count)
        {
            SwitchPage(currentPage+1,true);
        }
    }
    public void PreviousPage()
    {
        if (currentPage > 0)
        {
            SwitchPage(currentPage-1,true);
        }
    }
 
    void OnValidate()
    {
        if(pages.Count>1)
       setPage(startingPage);
    }
}
