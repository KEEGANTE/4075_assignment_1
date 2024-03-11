package com.example.ist_4075_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
EditText editTextText, editTextText2, editTextText3,
        editTextText4, editTextText5, editTextText6,
        editTextText7, editTextText9, editTextText11;
Button btn_calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText); //bread quantity text
        editTextText2 = findViewById(R.id.editTextText2); // bread total text
        editTextText3 = findViewById(R.id.editTextText3); //milk quantity text
        editTextText4 = findViewById(R.id.editTextText4); //milk total text
        editTextText5 = findViewById(R.id.editTextText5); //sugar quantity text
        editTextText6 = findViewById(R.id.editTextText6); //sugar total text
        editTextText7 = findViewById(R.id.editTextText7); //grand total
        editTextText9 = findViewById(R.id.editTextText9); //discount
        editTextText11 = findViewById(R.id.editTextText11); //netpay

        btn_calculate = findViewById(R.id.btn_calculate);

        btn_calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String br = editTextText.getText().toString(); //retrieve the text entered by the user in the EditText view and stores it in the variable br, which is of type String.
                String mk = editTextText3.getText().toString();
                String sr = editTextText5.getText().toString();

                if(br.isEmpty() || mk.isEmpty() || sr.isEmpty()) //method used to check if a string is empty or not
                {
                    Toast.makeText(MainActivity.this, "You must enter quantity", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int bread = Integer.parseInt(br); //convert br string to an integer
                    int milk = Integer.parseInt(mk);
                    int sugar = Integer.parseInt(sr);

                    if(bread > 4 || milk > 4 || sugar > 4)
                    {
                        Toast.makeText(MainActivity.this, "You cannot buy more than 4 items", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        int bprice=5000;
                        int mprice=6000;
                        int sprice=7000;
                        int btotal=Integer.parseInt(br)*bprice;
                        int mtotal=Integer.parseInt(mk)*mprice;
                        int stotal=Integer.parseInt(sr)*sprice;
                        int grandt=(btotal+mtotal+stotal); //grand total is the sum of all of them.
                        editTextText2.setText(String.valueOf(btotal));
                        editTextText4.setText(String.valueOf(mtotal));
                        editTextText6.setText(String.valueOf(stotal));
                        editTextText7.setText(String.valueOf(grandt));
                        calculator(grandt); //method
                    }
                }
            }
        });
    }
    public void calculator(int total) //one method used only
    {
        int discount_tot=0; //var


        if (total<10000)
        {
            discount_tot*=0;
        } else if (total>11000&&total<25000) {
            discount_tot=total*15/100;
        } else if (total>26000&&total<35000) {
            discount_tot=total*25/100;
        } else if (total>35000) {
            discount_tot=total*30/100;
        }
        int net=total-discount_tot;
        editTextText9.setText(String.valueOf(discount_tot)); //display the number
        editTextText11.setText(String.valueOf(net)); //display the number
    }
}