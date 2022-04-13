package com.example.pruebacapicua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView txtResultado;
    private EditText etPalabra;
    private Button btnProcesar;

    private String palabra,invertida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*
            Al configurar un boton para decirle que esté pendiente
            al evento click de ese boton en pantalla con el uso
            del metodo .setOnClickListener()
            Lo que ese metodo esta esperando como parametro o argumento
            es una funcion que será la función click que activará
            las acciones cuando se presionó el botón.

            Cuando se pasa una funcion como parametro, estas generalmente
            son conocidas como funciones anónimas.
            La idea es que esa función ejecute su procedimiento a partir
            del método que la recibe como parámetro.
         */

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Este método onCLick sólo existe en el
                // ámbito del botón btnProcesar
                // Lo que se haga acá sólo sirve para ese botón
                recibirInformacion();
                invertirPalabra();
            }
        });
    }

    private void invertirPalabra() {
        // Una manera directa de invertir una cadena
        // esto es netamente codigo JAVA
        invertida=new StringBuilder(palabra).reverse().toString();
        txtResultado.setText(invertida);
    }

    private void recibirInformacion() {
        palabra=etPalabra.getText().toString();
    }

    private void inicializarVistas() {
        txtResultado=findViewById(R.id.txtResultado);
        etPalabra=findViewById(R.id.etPalabra);
        btnProcesar=findViewById(R.id.btnProcesar);
    }


}