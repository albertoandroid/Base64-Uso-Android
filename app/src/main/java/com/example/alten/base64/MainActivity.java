package com.example.alten.base64;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*
    Base64 -> Es la mayor potencia de dos que puede ser representada usando únicamente los caracteres imprimibles de ASCII
    A-Z, a-z y 0-9 en este orden para los primeros 62 dígitos. Los últimos 2 digitos varian entre versiones

    Cuando queremos enviar datos binarios a través de la red, no se envian en forma de bits o bytes a través del cable
    en un formato "sin formato". Esto podría dar lugar a error, puesto que los datos binarios pueden entenderse como datos de control en un móden. etc
    Por ello y como todos los medios están hechos para transmitir texto se utiliza este tipo de codificiación.
    Es decir codificamos los datos binarios en caracteres y evitamos este tipo de errores y base64 hace esto exactamente.

    Uso Comun de Base64
    Criptografía:
    Por norma general las claves de encriptación no suelen ser un texto, sino que son directamente bytes en bruto, pero al final la clave tiene que ser almacenada en una base de datos
    esto quiere decir que al final nos resultará útil utilizar base64 para poder salvarla en nuestro sistema.
    Lo mismo nos va a ocurrir con los bytes cifrados resultantes del mensaje.
    Por ello es preciso que tengamos en cuenta que Base64 se utiliza mucho en criptografía, pero NO ES UN MECANISMO DE SEGURIDAD.
    Cualquier persona puede convertir una cadena en Base64 a sus bytes originales, por lo tanto no puede usarse para progeger datos, es solo un formato
    para almacenar bytes sin formato de manera sencilla.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String cadenaACodificarEnBase64 = "Ver cursos de Android Desde Cero";
        /*
        Codificar en Base 64
         */
        //Encode -> codifica String en BASE64 (Se le pasa la cadena en Array de Bytes)
        byte[] bytesEncoded =  Base64.encode(cadenaACodificarEnBase64.getBytes(), Base64.DEFAULT);
        //Si queremos ver como queda la cadena que esta en Array de Bytes en String lo hacemos de esta manera:
        String cadenaCodificada64 = new String(bytesEncoded);
        Log.d("TAG", cadenaCodificada64);
        //TAG -> VmVyIGN1cnNvcyBkZSBBbmRyb2lkIERlc2RlIENlcm8=


        /*
        Decodificar en Base 64
         */
        //Decode -> decodifica String en Base64
        byte[] bytesDecoded = Base64.decode(cadenaCodificada64, Base64.DEFAULT);
        String cadenaDescodificadaEnBase64 = new String(bytesDecoded);
        Log.d("TAG", cadenaDescodificadaEnBase64);
        //TAG -> Ver cursos de Android Desde Cero
    }
}
