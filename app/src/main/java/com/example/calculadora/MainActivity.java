package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero, numeroUm, numeroDois, numeroTrez, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            virgula, soma, subtracao, divisao, igual, multiplicao, limpar, positivo_negativo;

    private ImageView backspace;

    private TextView txt_expressao, txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.num_0);
        numeroUm = findViewById(R.id.num_1);
        numeroDois = findViewById(R.id.num_2);
        numeroTrez = findViewById(R.id.num_3);
        numeroQuatro = findViewById(R.id.num_4);
        numeroCinco = findViewById(R.id.num_5);
        numeroSeis = findViewById(R.id.num_6);
        numeroSete = findViewById(R.id.num_7);
        numeroOito = findViewById(R.id.num_8);
        numeroNove = findViewById(R.id.num_9);
        virgula = findViewById(R.id.num_virgula);
        limpar = findViewById(R.id.botton_limpar);
        divisao = findViewById(R.id.botton_divisao);
        soma = findViewById(R.id.botton_mais);
        subtracao = findViewById(R.id.botton_menos);
        multiplicao = findViewById(R.id.botton_vezes);
        numeroZero = findViewById(R.id.botton_porcentagem);
        igual = findViewById(R.id.botton_igual);
        positivo_negativo = findViewById(R.id.botton_positivo_negativo);
        backspace = findViewById(R.id.backpace);
        txt_expressao = findViewById(R.id.txt_expressao);
        txt_resultado = findViewById(R.id.txt_resultado);
    }
    public void AcresentarUmaExpressap(String string, boolean limpar_dados){
        if (txt_resultado.getText().equals("")){
            txt_expressao.setText("");
        }

        if (limpar_dados){
            txt_resultado.setText("");
            txt_expressao.append(string);
        }else{
            txt_expressao.append(txt_resultado.getText());
            txt_expressao.append(string);
            txt_resultado.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.num_0:
                AcresentarUmaExpressap( "0", true);
                break;
        }
    }
}
