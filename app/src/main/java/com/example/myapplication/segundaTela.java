package com.example.myapplication;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class segundaTela extends AppCompatActivity {

    private TextView numerosSorteadosTextView;
    private DatabaseConfig dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        numerosSorteadosTextView = findViewById(R.id.textViewNumeros);
        dbHelper = new DatabaseConfig(this);

        exibirNumerosSorteados();
    }

    private void exibirNumerosSorteados() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Sorteio ORDER BY id", null);

        List<List<Integer>> sorteios = new ArrayList<>();

        List<Integer> numerosSorteioAtual = new ArrayList<>();
        while (cursor.moveToNext()) {
            int numero = cursor.getInt(cursor.getColumnIndexOrThrow("numero"));
            numerosSorteioAtual.add(numero);

            if (numerosSorteioAtual.size() == 6) {
                sorteios.add(new ArrayList<>(numerosSorteioAtual));
                numerosSorteioAtual.clear();
            }
        }

        cursor.close();

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < sorteios.size(); i++) {
            List<Integer> numerosSorteio = sorteios.get(i);
            resultado.append("Sorteio ").append(i + 1).append(": ");
            for (Integer numero : numerosSorteio) {
                resultado.append(numero).append(",");
            }
            resultado.append("\n");
        }

        numerosSorteadosTextView.setText(resultado.toString());
    }
}
