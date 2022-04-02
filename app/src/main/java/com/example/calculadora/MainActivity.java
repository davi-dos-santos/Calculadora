package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero, numeroUm, numeroDois, numeroTrez, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            virgula, soma, subtracao, divisao, porcentagem, igual, multiplicao, limpar, positivo_negativo;

    private ImageView backspace;

    private TextView txt_expressao, txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTrez.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        virgula.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicao.setOnClickListener(this);
        positivo_negativo.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                txt_expressao.setText("");
                txt_resultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expresao = findViewById(R.id.txt_expressao);
                String string = expresao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpresao = string.substring(var0, var1);
                    expresao.setText(txtExpresao);
                }
                txt_resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expressao = new ExpressionBuilder(txt_expressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longresultado = (long) resultado;

                    if (resultado == (double)longresultado){
                        txt_resultado.setText((CharSequence) String.valueOf(longresultado));
                    }else{
                        txt_resultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });

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
        virgula = findViewById(R.id.virgula);
        limpar = findViewById(R.id.botton_limpar);
        divisao = findViewById(R.id.botton_divisao);
        soma = findViewById(R.id.botton_mais);
        subtracao = findViewById(R.id.botton_menos);
        multiplicao = findViewById(R.id.botton_vezes);
        porcentagem = findViewById(R.id.botton_porcentagem);
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
            txt_resultado.setText(" ");
            txt_expressao.append(string);
        }else{
            txt_expressao.append(txt_resultado.getText());
            txt_expressao.append(string);
            txt_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.num_0:
                AcresentarUmaExpressap( "0", true);
                break;

            case R.id.num_1:
                AcresentarUmaExpressap( "1", true);
                break;

            case R.id.num_2:
                AcresentarUmaExpressap( "2", true);
                break;

            case R.id.num_3:
                AcresentarUmaExpressap( "3", true);
                break;

            case R.id.num_4:
                AcresentarUmaExpressap( "4", true);
                break;

            case R.id.num_5:
                AcresentarUmaExpressap( "5", true);
                break;

            case R.id.num_6:
                AcresentarUmaExpressap( "6", true);
                break;

            case R.id.num_7:
                AcresentarUmaExpressap( "7", true);
                break;

            case R.id.num_8:
                AcresentarUmaExpressap( "8", true);
                break;

            case R.id.num_9:
                AcresentarUmaExpressap( "9", true);
                break;

            case R.id.virgula:
                AcresentarUmaExpressap( ".", true);
                break;

            case R.id.botton_mais:
                AcresentarUmaExpressap( "+", false);
                break;

            case R.id.botton_menos:
                AcresentarUmaExpressap( "-", false);
                break;

            case R.id.botton_vezes:
                AcresentarUmaExpressap( "*", false);
                break;

            case R.id.botton_divisao:
                AcresentarUmaExpressap( "/", false);
                break;

            case R.id.botton_porcentagem:
                AcresentarUmaExpressap( "", false);
                break;

            case R.id.botton_positivo_negativo:
                AcresentarUmaExpressap( "", false);
                break;

        }
    }
}
