package com.example.alumno.url_hilos;

import android.support.annotation.NonNull;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alumno on 04/10/2018.
 */

public class ParseXmlPersona {

    public static List<Persona> Lista (String xmlString)
    {
        List<Persona> personas = new ArrayList<>();
        Persona p = null;

        try
        {

            XmlPullParser xml = Xml.newPullParser();

            xml.setInput(new StringReader(xmlString));

            int event = xml.getEventType();

            while (event != XmlPullParser.END_DOCUMENT)
            {
                switch (event)
                {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:

                        if("persona".equals(xml.getName()))
                        {
                            p = new Persona();
                        }else if("first_name".equals(xml.getName()))
                        {
                            p.setNombre(xml.nextText());
                        }else if("last_name".equals(xml.getName()))
                        {
                            p.setApellido(xml.nextText());
                        }else if("phone".equals(xml.getName()))
                        {
                            p.setTelefono(xml.nextText());
                        }
                        break;

                    case XmlPullParser.END_TAG:
                   if("persona".equals(xml.getName()))
                    {
                        personas.add(p);
                    }
                        break;
                }
                event = xml.next();
            }


        }

        catch(Exception ex)
        {}


        return personas;
    }

    public static List<Persona> PersonasJson (String xmlString)
    {
        List<Persona> personas = new ArrayList<>();

        try
        {
            JSONArray listaJson = new JSONArray(xmlString);
            for(int i=0; i< listaJson.length();i++)
            {
                JSONObject o = listaJson.getJSONObject(i);

            }



        }

        catch(Exception ex)
        {}



        return personas;
    }
}
