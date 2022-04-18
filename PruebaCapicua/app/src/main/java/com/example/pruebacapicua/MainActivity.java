package com.example.pruebacapicua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private TextView txtResultado;
    private TextView txtAviso;
    private EditText etPalabra;
    private Button btnProcesar;
    private Button btnMensaje;

    private String palabra,invertida="";

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

        btnMensaje.setOnClickListener((new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mostrarMensaje();
            }
        }));
    }

    private void mostrarMensaje() {
        // Para mostrar mensajes en pantalla, ustedes pueden usar
        // una ventana emergente temporal llamada Toast,
        // que básicamente sirve para mostrar información
        // al usuario a cerca de ciertos procesos que hayan pasado,
        // confirmaciones, mostrar algun mensaje y otros
        // estatico
        /*
        El toast tiene un metodo llamado makeText que es donde configurara
        lo que se quiere mostrar al usuario, para llo deben pasar
        los siguientes parametros:
        - contexto(ambito) de la pantalla donde se va a dibujar es emensaje
        - cadena de carateres: el mensaje a mostrar
        - Constante de duracion del mensaje en pantalla para que dure mas o menos
        Finalmente deben decirle al Toast que se muestre con esa configuracion
        y para llo usan el metodo o evento .show()
         */
        //Toast.makeText(this,"Hola Mundo",Toast.LENGTH_LONG).show();
        String mensajeMostrar=evaluarPalindromo();
        Toast.makeText(this,mensajeMostrar,Toast.LENGTH_LONG).show();
    }

    private void invertirPalabra() {
        // Una manera directa de invertir una cadena
        // esto es netamente codigo JAVA
        // invertida=new StringBuilder(palabra).reverse().toString();

        // INVERTIR UNA CADENA
        invertida="";
        // La idea es tratar a la cadena como si fuera un array
        // donde cad letra esta en una posicion del array
        // para tal efecto los strings tienen un metodo que les permite
        // devolver un caracter d euna posicion como si fuera un array
        for (int i = this.palabra.length()-1; i >=0 ; i--) {
            invertida=invertida+this.palabra.charAt(i);
        }
        txtResultado.setText(invertida);
        avisarPalindromo();
    }

    private void avisarPalindromo() {
        if (this.invertida.equals(this.palabra)){
            txtAviso.setText("SI es palindromo");
        }
        else{
            txtAviso.setText("NO es palindromo");
        }
    }

    // Para evaluar palindromo
    private String evaluarPalindromo(){
        String mensaje="NO es palíndromo";
        if(this.palabra.equals(this.invertida)){
            mensaje="Es palíndromo";
        }
        return mensaje;
    }

    private void recibirInformacion() {
        palabra=etPalabra.getText().toString();
    }

    private void inicializarVistas() {
        txtResultado=findViewById(R.id.txtResultado);
        etPalabra=findViewById(R.id.etPalabra);
        btnProcesar=findViewById(R.id.btnProcesar);
        txtAviso=findViewById(R.id.txtAviso);
        btnMensaje=findViewById(R.id.btnMensaje);
    }


}