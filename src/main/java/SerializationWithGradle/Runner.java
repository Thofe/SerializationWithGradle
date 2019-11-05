/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationWithGradle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Bmitr
 */
public class Runner {
    public static void main(){
        Person initialPerson = new Person("First", "Last", "1", "2", "3");
        
        
        System.out.println("CSV TEST:");
        //Attempts to serialize a person to a given CSV file
        try{
            //Serializes a person to a given CSV file
            Person.serializeToCSV("data.csv", initialPerson);
            
            //Attempts to deserialize a person from a given CSV file
            try{
                // Deserializes a person from the data.csv file    
                Person replicaPerson =  Person.deserializeFromCSV("data.csv");
                
                // Prints out the persons info
                System.out.println("Starting person's state:");
                System.out.println(initialPerson.prettyPrint());

                System.out.println();
                System.out.println();

                System.out.println("Replica person's state:");
                System.out.println(replicaPerson.prettyPrint());
                
                System.out.println();
                System.out.println();
                
                System.out.println("Are these 2 people's states equal?");
                System.out.println(replicaPerson.equals(initialPerson));   
            }catch (IOException ex){
                System.out.println("Error in deserialization");
            }
        }catch (IOException ex){
            System.out.println("Error in serialization");
        }
        
        
        System.out.println("CSV TEST CONCLUSION");
        System.out.println();
        System.out.println();
        
        
        System.out.println("BINARY TEST:");
        //Attempts to serialize a person to a given txt file
        try{
            //Serializes a person to a given txt file
            FileOutputStream fileOutputStream = new FileOutputStream("data.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(initialPerson);
            objectOutputStream.flush();
            objectOutputStream.close();
            
            //Attempts to deserialize a person from a given txt file
            try{
                // Deserializes a person from the data.txt file
                FileInputStream fileInputStream = new FileInputStream("data.bin");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Person replicaPerson = (Person) objectInputStream.readObject();
                objectInputStream.close();
                
                // Prints out the persons info
                System.out.println("Starting person's state:");
                System.out.println(initialPerson.prettyPrint());

                System.out.println();
                System.out.println();

                System.out.println("Replica person's state:");
                System.out.println(replicaPerson.prettyPrint());
                
                System.out.println();
                System.out.println();
                
                System.out.println("Are these 2 people's states equal?");
                System.out.println(replicaPerson.equals(initialPerson));
                
            }catch(IOException ex){
                System.out.println("Error in deserialization");
            }catch(ClassNotFoundException e){
                System.out.println("Error in deserialization");
            }
        }catch (IOException ex){
            System.out.println("Error in serialization");
        }
        System.out.println("BINARY TEST CONCLUSION");
    }
}

