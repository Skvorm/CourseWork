import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TickTac extends JFrame implements ActionListener
{
    private JButtonPlus[] b;
    private JPanel body;
    public TickTac()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(300,100);
        setLayout(new GridLayout());
        b = new JButtonPlus[9];
        Buttons();  
        Panels();     
        add(body, BorderLayout.CENTER);

    }

    public void Buttons()
    {
        for (int x=0;x<b.length;x++)
        {
            b[x] = new JButtonPlus(x+"");
            b[x].addActionListener(this);
            b[x].setText((x+1)+ "");

        }
    }

    public void Panels()
    {
        body = new JPanel();
        body.setLayout(new GridLayout(3,3));
        for (int x=0;x<b.length;x++)
        {
            body.add(b[x]);

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        int actInt = Integer.parseInt(action);
        if(b[actInt].getText().equals("X"))
        {
            b[actInt].setText("O");
        }
        else if(b[actInt].getText().equals("O"))
        {
            b[actInt].setText("X");
        }
        else 
        {
            b[actInt].setText("X");
        }


    }

    public String evalString(String str)
    {
        String temp="";
        if(str.equals("X"))
            temp="O";
        else if(str.equals("O"))
            temp="X";
        else if((Integer.parseInt(str)>=1)&&(Integer.parseInt(str)<=9))
        {
            temp="X";   
        }
        return temp;

    }

    public static void main(String [] args)
    {
        TickTac t = new TickTac();
        t.setVisible(true);
    }
    private class JButtonPlus extends JButton
    {
        private String buttonName;
        public JButtonPlus(String name)
        {
            super();
            buttonName=name;
            this.setActionCommand(buttonName);
        }

    }
}
