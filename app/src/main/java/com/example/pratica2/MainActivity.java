package com.example.pratica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        double imc = Double.parseDouble(editPeso.getText().toString()) / Math.pow(Double.parseDouble(editAltura.getText().toString()), 2);

        Intent it = new Intent(getBaseContext(), Tela2.class);
        Bundle params = new Bundle();

        params.putString("nome", editNome.getText().toString());
        params.putString("idade", editIdade.getText().toString());
        params.putString("peso", editPeso.getText().toString());
        params.putString("altura", editAltura.getText().toString());
        params.putDouble("imc", imc);

        it.putExtras(params);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(it);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Tela 1 .onPause() chamado");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Tela 1 .onStop() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Tela 1 .onDestroy() chamado");
    }
}