package SerializationWithGradle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bmitr
 */
public class Serializer {
    
    /**
     * Serializes an object to a file
     * 
     * @param objectOutputStream
     * @param o
     * @throws IOException 
     */
    public static void writeObject(ObjectOutputStream objectOutputStream, Object o)throws IOException{
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(o);
    }
    
    /**
     * Returns an object based on data stored in a file 
     * 
     * @param ois
     * @return an object constructed by the data in the file
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static Object readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        Object o = (Object) ois.readObject();
        return o;
    }
}
