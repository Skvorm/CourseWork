using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.Windows;

    public class TextScroller : MonoBehaviour {
        private string[] texts;
        
        private int ct = 0;
        private int ctprev = 0;
        private int ctnext = 0;
        public string file;
        public string iniString;
        public int initialWaitTime;
        public bool continuous;
        private bool toggle=true;

        private UnityEngine.UI.Text textDisp;


        // Use this for initialization
        void Start() {
            textDisp = GetComponent<Text>();
            textDisp.text = iniString;
        texts = System.IO.File.ReadAllLines(@"C:\Users\Mark\Desktop\TestRead.txt");
        //texts = System.IO.File.ReadAllLines(@file);
        StartCoroutine(read());
        }
        IEnumerator read()
        {
            yield return new WaitForSeconds(initialWaitTime);
            while (toggle)
            {
                ctnext = (ct + 1) % (texts.Length);
                textDisp.text = texts[ctprev] + System.Environment.NewLine + texts[ct] + System.Environment.NewLine + texts[ctnext];
                yield return new WaitForSeconds(1);
                ctprev = ct;
                ct = ctnext;
                if(!continuous)
                {
                    toggle = false;
                }
            }
        }

        // Update is called once per frame
        void Update() {

        }
        //called to set the text being read by read thread
        public void SetText(string t)
        {
            texts = new[] { t };
        }
    }

   
