/*
 * Created on 16-Jun-2004
 *
 * Clase implementada funciones para el manejo de ficheros de datos
 *
 */

/**
 * @author Jesus Alcala Fernandez
 *
 *
 */

package algorithms.evaep;

import java.io.*;
import java.util.*;

public class File {
    public static String readFile(String nombreFichero) {
        String cadena = "";
        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            byte[] leido = new byte[4096];
            int bytesLeidos = 0;
            while (bytesLeidos != -1) {
                bytesLeidos = fis.read(leido);
                if (bytesLeidos != -1) {
                    cadena += new String(leido, 0, bytesLeidos);
                }
            }
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit( -1);
        }
        return cadena;
    }

    public static void writeFile(String nombreFichero, String cadena) {
        try {
            FileOutputStream f = new FileOutputStream(nombreFichero);
            DataOutputStream fis = new DataOutputStream((OutputStream) f);
            fis.writeBytes(cadena);
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit( -1);
        }
    }

    public static void AddtoFile(String nombreFichero, String cadena) {
        try {
            RandomAccessFile fis = new RandomAccessFile(nombreFichero, "rw");
            fis.seek(fis.length());
            fis.writeBytes(cadena);
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit( -1);
        }
    }
}
