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
    private int numeroSorteado = 0;


    //gets e sets das variáveis
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

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
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


    //pegando o número escolhido pelo usuário
    class EscutadorBtn1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroSorteado = getRandom(3);
            numeroUsuario = 1;
            resultado(numeroSorteado, numeroUsuario);
        }
    }

    class EscutadorBtn2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroSorteado = getRandom(3);
            numeroUsuario = 2;
            resultado(numeroSorteado, numeroUsuario);
        }
    }
    class EscutadorBtn3 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            numeroSorteado = getRandom(3);
            numeroUsuario = 3;
            resultado(numeroSorteado, numeroUsuario);
        }
    }

    public void resultado(int numSorteado, int numUsuario){
        //colocando o número sorteado na tela
        txtNumero.setText(Integer.toString(numSorteado));

        //comparando resultados
        if (numSorteado == numUsuario){
            txtResultado.setText("Você ganhou!!");
        } else {
            txtResultado.setText("Você perdeu!!");
        }

    }

}