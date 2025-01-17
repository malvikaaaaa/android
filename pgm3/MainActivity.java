package com.example.pgm3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    TextView t;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        e=(EditText) findViewById(R.id.facted);
        b=(Button) findViewById(R.id.factb);
        t=(TextView) findViewById(R.id.textres);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==b.getId())
        {
            int num=Integer.parseInt(e.getText().toString());
            int result=1;
            if(num==0 || num==1)
            {
                result=1;
            }
            else
            {
                for(int i=2;i<=num;i++)
                    result=result*i;
            }
            t.setText("Result : "+String.valueOf(result));
        }
    }
}