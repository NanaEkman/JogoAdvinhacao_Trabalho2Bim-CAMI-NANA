package com.example.jogoadvinhacao_trabalho2bim_cami_nana;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Camila Devita Basaglia (3010058) e Nana de Souza Ekman Simões (3010414)

    //atributos
    private Button btn1;
    private Button btn2;
    private Button btn3;

    private EditText txtNumero;
    private EditText txtResultado;

    private int numeroUsuario = 0;


    //gets das variáveis
    public Button getBtn1() {
        return btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public Button getBtn3() {
        return btn3;
    }

    public EditText getTxtNumero() {
        return txtNumero;
    }

    public EditText getTxtResultado() {
        return txtResultado;
    }

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        txtNumero = findViewById(R.id.txtNumero);
        txtResultado = findViewById(R.id.txtResultado);

        btn1.setOnClickListener( new EscutadorBtn1());
        btn2.setOnClickListener( new EscutadorBtn2());
        btn3.setOnClickListener( new EscutadorBtn3());
    }

    //sorteando o numero que o app está pensando

    public static int getRandom(int intervalo){
        Random random = new Random();
        int num = random.nextInt(intervalo + 1);
        while (num == 0) {
            num = random.nextInt(intervalo + 1);
        }
        return num;

    }
    private int numeroSorteado = getRandom(3);

    //pegando o número escolhido pelo usuário
    class EscutadorBtn1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroUsuario = 1;
        }
    }

    class EscutadorBtn2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroUsuario = 2;
        }
    }
    class EscutadorBtn3 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroUsuario = 3;
        }
    }

    //colocando o número sorteado na tela
    txtNumero.setText(Integer.toString(numeroSorteado));


    //comparando resultados
    if (numeroSorteado == numeroUsuario){
        txtResultado.setText("Você ganhou!!");
    }

}