package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    }


    public void selectionBoto(View v) {
        Random random = new Random();
        int x = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;
        x = random.nextInt(60) + 1;
        x1 = random.nextInt(60) + 1;
        x2 = random.nextInt(60) + 1;
        x3 = random.nextInt(60) + 1;
        x4 = random.nextInt(60) + 1;
        x5 = random.nextInt(60) + 1;

        TextView Numero = findViewById(R.id.Numero);
        Numero.setText("" + x);

        TextView Numero1 = findViewById(R.id.Numero1);
        Numero1.setText("" + x1);

        TextView Numero2 = findViewById(R.id.Numero2);
        Numero2.setText("" + x2);

        TextView Numero3 = findViewById(R.id.Numero3);
        Numero3.setText("" + x3);

        TextView Numero4 = findViewById(R.id.Numero4);
        Numero4.setText("" + x4);

        TextView Numero5 = findViewById(R.id.Numero5);
        Numero5.setText("" + x5);



    }

    public void tela2(View view){
        Intent intent = new Intent(this, segundaTela.class);
        startActivity(intent);
    }
}








