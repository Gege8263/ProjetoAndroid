package com.example.myapplication;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    private DatabaseConfig dbHelper;

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

        dbHelper = new DatabaseConfig(this); // Inicializa o DatabaseConfig
    }

    public void selectionBoto(View v) {
        Random random = new Random();
        int[] numerosSorteados = new int[6];

        // Sorteia os números
        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = random.nextInt(60) + 1;
        }

        // Insere os números sorteados no banco de dados
        for (int i = 0; i < numerosSorteados.length; i++) {
            adicionarNumeroSorteado(numerosSorteados[i]);
        }

        // Atualiza a interface do usuário com os números sorteados
        atualizarNumerosSorteados(numerosSorteados);
    }

    private void adicionarNumeroSorteado(int numero) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("numero", numero);
        db.insert("Sorteio", null, values);
        db.close();
    }

    private void atualizarNumerosSorteados(int[] numerosSorteados) {
        TextView[] numerosTextView = new TextView[]{
                findViewById(R.id.Numero),
                findViewById(R.id.Numero1),
                findViewById(R.id.Numero2),
                findViewById(R.id.Numero3),
                findViewById(R.id.Numero4),
                findViewById(R.id.Numero5)
        };

        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosTextView[i].setText(String.valueOf(numerosSorteados[i]));
        }
    }

    public void tela2(View view){
        Intent intent = new Intent(this, segundaTela.class);
        startActivity(intent);
    }
}









