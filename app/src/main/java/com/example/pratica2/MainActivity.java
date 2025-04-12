package com.example.pratica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void relatorioNutricional(View v) {
        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editIdade = (EditText) findViewById(R.id.editIdade);
        EditText editPeso = (EditText) findViewById(R.id.editPeso);
        EditText editAltura = (EditText) findViewById(R.id.editAltura);
        Button botao = (Button) findViewById(R.id.botao);

        double imc = Double.parseDouble(editPeso.getText().toString()) / (Double.parseDouble(editAltura.getText().toString()) * Double.parseDouble(editAltura.getText().toString()));

        Intent it = new Intent(getBaseContext(), Tela2.class);
        Bundle params = new Bundle();

        params.putString("nome", editNome.getText().toString());
        params.putString("idade", editIdade.getText().toString());
        params.putString("peso", editPeso.getText().toString());
        params.putString("altura", editAltura.getText().toString());
        params.putDouble("imc", imc);

        it.putExtras(params);
        startActivity(it);
    }
}