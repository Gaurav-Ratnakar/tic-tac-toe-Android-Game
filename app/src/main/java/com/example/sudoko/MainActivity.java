package com.example.sudoko;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;
    boolean turn=true;
    TextView result;
    Button b[][]=new Button[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button r;

        b[0][0]=findViewById(R.id.button1);b[0][1]=findViewById(R.id.button2);b[0][2]=findViewById(R.id.button3);
        b[1][0]=findViewById(R.id.button4);b[1][1]=findViewById(R.id.button5);b[1][2]=findViewById(R.id.button6);
        b[2][0]=findViewById(R.id.button7);b[2][1]=findViewById(R.id.button8);b[2][2]=findViewById(R.id.button9);
        r=findViewById(R.id.ResetBtn);
        result=findViewById(R.id.WinnerName);
    }

    public void clickbox(View v)
    {

        Button b2=(Button) v;
        if(b2.getText().toString().equals("")==false)
            return ;
        if(count==0)
            result.setText("");
        if(turn==true) {                               //this is x's turn
            b2.setText("X");

            result.setText("O's turn");
        }
        else                                          //this is O's turn
        {
            b2.setText("O");
            result.setText("X's turn");
        }
        if(checkforwin())
        {
            if(turn==true){result.setText("Winner is X.");clear1();}
            else
            {result.setText("Winner is O.");clear1();}

        }
        else if(count==9)
        {
            result.setText("Match Draw!");
            clear1();

        }
        turn = !turn;
    }

    public void clear(View v)
    {
        clear1();
        result.setText("");


    }
    public void clear1()
    {
        count=0;
        int i,j;
        for(i=0;i<3;i++) {
            for (j = 0; j < 3; j++) {
                b[i][j].setText("");
            }
        }

    }
    public boolean checkforwin()
    {
        String[][] s=new String[3][3];
        int i,j;
        for( i=0;i<3;i++)
        {
            for( j=0;j<3;j++)
            {
                s[i][j]=b[i][j].getText().toString();
            }
        }
        for(i=0;i<3;i++)
            if(s[i][0].equals(s[i][1]) && s[i][0].equals(s[i][2]) && !s[i][0].equals(""))
                return true;

        for(i=0;i<3;i++)
            if(s[0][i].equals(s[1][i]) && s[0][i].equals(s[2][i]) && !s[0][i].equals(""))
                return true;
        if(s[0][0].equals(s[1][1])&& s[0][0].equals(s[2][2])&& !s[0][0].equals(""))
            return true;
        if(s[0][2].equals(s[1][1])&& s[2][0].equals(s[1][1])&& !s[0][2].equals(""))
            return true;


        return false;

    }
}