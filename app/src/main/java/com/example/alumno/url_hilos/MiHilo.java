package com.example.alumno.url_hilos;

/**
 * Created by alumno on 27/09/2018.
 */
import android.os.Handler;
import android.os.Message;

import java.net.URL;


public class MiHilo extends Thread {
 Handler h;
    EjemploConexion ej;
    URL url;
    Boolean bool;
    public MiHilo( Handler h, URL url, Boolean bool)
    {

        this.h = h;
        this.url=url;
        this.bool=bool;
    }


    @Override
    public void run() {
        try{
            Thread.sleep(4000);
            ej= new EjemploConexion();
            Message m = new Message();
            m.arg1= 2;
            //m.obj = ej.ObtenerString();
            m.obj = ej.ObtenerImagen(this.url);
            //byte[] bytes = (byte[]) m.obj;
            /*Bitmap bytmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);*/

            h.sendMessage(m);
        }
        catch(Exception e)
        {

        }

        }
    }

