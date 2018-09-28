package com.example.alumno.url_hilos;

/**
 * Created by alumno on 27/09/2018.
 */
import java.net.HttpURLConnection;


import java.lang.String;
import java.net.*;
import java.io.*;



public class EjemploConexion {
    public EjemploConexion() {
    }

    public String ObtenerString()
    {
        String s =" ";

        try
        {
            URL url = new URL("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml");
            HttpURLConnection conection =(HttpURLConnection) url.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int response = conection.getResponseCode();
            if(response == 200)
            {
                InputStream is = conection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                is.close();
                return new String(baos.toByteArray());
            }


        }
        catch(Exception ex)
        {
        ex.printStackTrace();

        }

        return s;
    }


    public byte[] ObtenerImagen(URL url)

    {
       // ByteArrayOutputStream b = new ByteArrayOutputStream();
        try
        {

           // URL url = new URL("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml/ubuntu-logo.png");

            HttpURLConnection conection =(HttpURLConnection) url.openConnection();
            conection.setRequestMethod("GET");
            conection.connect();
            int response = conection.getResponseCode();
            if(response == 200)
            {
                InputStream is = conection.getInputStream();
                /*byte[] bytes = (byte[]) msg.obj;
                Bitmap bytmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);*/
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                is.close();
                return baos.toByteArray();
//recycler, handerl, conecciones
            }




        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }

        return null;
    }
}
