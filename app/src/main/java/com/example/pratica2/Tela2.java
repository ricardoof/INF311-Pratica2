package com.example.pratica2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Tela2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        TextView nome = (TextView) findViewById(R.id.nomeTela2);
        TextView idade = (TextView) findViewById(R.id.idadeTela2);
        TextView peso = (TextView) findViewById(R.id.pesoTela2);
        TextView altura = (TextView) findViewById(R.id.alturaTela2);
        TextView imc = (TextView) findViewById(R.id.imcTela2);
        TextView classificacao = (TextView) findViewById(R.id.classificacaoTela2);

        Double IMC = params.getDouble("imc");
        DecimalFormat df = new DecimalFormat("0.##");
        String resultadoFormatado = df.format(IMC);
        String resultado = "";

        if(IMC < 18.5){
            resultado = "Abaixo do peso";
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            resultado = "Saudável";
        } else if(IMC >= 25 && IMC <= 29.9 ){
            resultado = "Sobrepeso";
        } else if(IMC >= 30.0 && IMC <= 34.9){
            resultado = "Obesidade Grau I";
        } else if(IMC >= 35 && IMC <= 39.9) {
            resultado = "Obesidade Grau II (severa)";
        } else if(IMC >= 40){
            resultado = "Obesidade Grau III (mórbida)";
        }

        nome.setText("Nome: " + params.getString("nome"));
        idade.setText("Idade: " + params.getString("idade"));
        peso.setText("Peso: " + params.getString("peso") + " Kg");
        altura.setText("Altura: " + params.getString("altura") + " m");
        imc.setText("IMC: " + resultadoFormatado + " Kg/m^2");
        classificacao.setText("Classificação: " + resultado);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Tela 2 .onPause() chamado");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Tela 2 .onStop() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Tela 2 .onDestroy() chamado");
    }

    public void voltarTela1(View v) {
        finish();
    }
}
