package com.example.alumno.url_hilos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;



import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    MiHilo hilo;
    Handler h;
    TextView tv;
    ImageView iv;
    URL url = new URL("http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png");
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
         tv = (TextView) findViewById(R.id.txtNombre);
        iv = (ImageView) findViewById(R.id.imagen);
        // Worker w = new Worker(handler);
        hilo = new MiHilo(h,url,false);
        hilo.start();



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
     //   client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    protected void onStop() {
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
       // AppIndex.AppIndexApi.end(client, getIndexApiAction());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  client.disconnect();
    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.d("LLEGO EL MENSAJE", " " + msg.arg1+" "+msg.obj);



        if (msg.arg1 == 1){
            tv.setText(msg.obj.toString());// Log.d("LLEGO EL MENSAJE",msg.obj.toString());
    }else if(msg.arg1==2)
        {
            byte[] bytes = (byte[]) msg.obj;
            Log.d("bytes" ,"llego imagen "+bytes);
            Bitmap bytmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            iv.setImageResource(R.mipmap.ic_launcher);
            iv.setImageBitmap(bytmap);
        }
        return false;
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }*/
}
