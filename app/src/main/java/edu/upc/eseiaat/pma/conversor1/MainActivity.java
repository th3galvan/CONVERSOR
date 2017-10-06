package edu.upc.eseiaat.pma.conversor1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 //crea en la pantalla los labels botones etc

        Button btn_a_millas = (Button)findViewById(R.id.btn_a_millas);     //declaramos el boton(clase button), buscamos el boton por su id(devuelve un tipo view) que transformamos añadiendo (button)
        Button btn_a_km = (Button)findViewById(R.id.btn_a_km);

        final EditText edit_km = (EditText) findViewById(R.id.edit_km);//declaramos el espacio para escribir texto
        final EditText edit_millas = (EditText) findViewById(R.id.edit_millas);


        btn_a_millas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                           //metodo que funciona cuando pulsamos btn_a_millas
                String skm = edit_km.getText().toString();           //obtenemos el texto de edit_km, getText nos devuelve un editable y nosotros lo queremos en string, hacemos conversion con toString
                float km = Float.parseFloat(skm);                   // convertimos el string skm a float con el metodo de la clase float parseFloat
                float millas = km / 1.609f;                          //factor de conversion
                String smillas = String.format("%f",millas);         //transforma de float a string con el metodo format("tipo de variable",variable)
                Log.i("Galvan","btn_a_millas clickado.");           // genera un mensaje en la consola
                edit_millas.setText(smillas);                       //escribe el resultado en la caja de texto de millas

            }
        });
        btn_a_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smillas = edit_millas.getText().toString();
                float millas = Float.parseFloat(smillas);
                float km = millas * 1.609f;
                String skm = String.format("%f",km);
                Log.i("Galvan","btn_a_km clickado.");
                edit_km.setText(skm);

            }
        });





    }
}
