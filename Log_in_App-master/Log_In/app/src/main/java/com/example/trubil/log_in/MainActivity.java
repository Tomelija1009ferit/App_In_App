package com.example.trubil.log_in;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editname);
        Password = (EditText) findViewById(R.id.editpassword);
        Login = (Button) findViewById(R.id.buttonlogin);
        Info = (TextView)findViewById(R.id.edittext);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validation(String username, String userpassword){


        if((username.equals("Admin")) && (userpassword.equals("1009"))) {
            Intent intent = new Intent(MainActivity.this, secondActivity.class);
            startActivity(intent);
        }
        else{

            counter --;

            Info.setText("No more attempts: " + String.valueOf(counter) );

          if (counter == 0){
              Intent intent = new Intent(MainActivity.this, thirdActivity.class);
              startActivity(intent);
              counter = 3;
          }
        }
    }
}
