package com.example.alumno.url_hilos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    MiHilo hilo;
    Handler h;
    TextView tv;
    ImageView iv;
    //URL url = new URL("http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png");
    //URL url = new URL("http://192.168.3.79:8080/personas.xml");
    URL url = new URL("http://192.168.3.79:8080/MOCK_DATA.json");
    //MOCK_DATA.json
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // private GoogleApiClient client;
    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = new Handler(this);
        // txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        MiHilo tc2 = new MiHilo(h,url,true );
        Thread t2 = new Thread((tc2));
        t2.start();

        tv = (TextView) findViewById(R.id.txtNombre);
        iv = (ImageView) findViewById(R.id.imagen);
        // Worker w = new Worker(handler);
        hilo = new MiHilo(h, url, false);
        hilo.start();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.d("LLEGO EL MENSAJE", " " + msg.arg1 + " " + msg.obj);


       // List<Persona> list = (List<Persona>) msg.obj;
       // tv.setText(list.get(10).toString());


       tv.setText(msg.obj.toString());
       ParseXmlPersona.PersonasJson(msg.obj.toString());
        /*if (msg.arg1 == 1) {
            tv.setText(msg.obj.toString());// Log.d("LLEGO EL MENSAJE",msg.obj.toString());
        } else if (msg.arg1 == 2) {
            byte[] bytes = (byte[]) msg.obj;
            Log.d("bytes", "llego imagen " + bytes);
            Bitmap bytmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            iv.setImageResource(R.mipmap.ic_launcher);
            iv.setImageBitmap(bytmap);
        }*/
        return false;
    }



}
