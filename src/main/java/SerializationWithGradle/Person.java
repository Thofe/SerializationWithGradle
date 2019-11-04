/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationWithGradle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;


//Hash code comparison override 
/**
 *
 * @author Bmitr
 */
public class Person implements Comparable<Person>, Serializable{
    private static final long serialVersionUID = 1L;
            
    private String firstName;
    private String lastName;
    private String birthMonth;
    private String birthDay;
    private String birthYear;
    
    /**
     * Constructs a person with no state
     */
    public Person(){
        this("","","","","");
    }
    
    /**
     * Constructs a person with a given state 
     * 
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param birthMonth the person's birth month
     * @param birthDay the person's birth day
     * @param birthYear the person's birth year
     */
    public Person(String firstName, String lastName, String birthMonth, String birthDay, String birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }
    
    /**
     * Serializes a person to a given file
     * 
     * @param file the file to which the data will be saved 
     * @throws IOException 
     */
    public static void serializeToCSV(String fileName, Person person) throws IOException{
        FileWriter fw = new FileWriter(new File(fileName));
        fw.write("firstName, lastName, birthMonth, birthDay, birthYear" + System.getProperty( "line.separator" ));  
        fw.write(person.getFirstName() + ", " + person.getLastName() + ", " + person.getBirthMonth() + ", " + person.getBirthDay() + ", " + person.getBirthYear());
        fw.close();  
    }
  
    /**
     * Deserializes a person from a given file
     * 
     * @param file the file to pull the data from
     * @throws IOException 
     */
    public static Person deserializeFromCSV(String file) throws IOException{
        Person person = new Person();
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine(); //Reads the first line without recording it 
        String state = br.readLine();
         
        String[] stateArray = state.split(",");
        
        person.setFirstName(stateArray[0].trim());
        person.setLastName(stateArray[1].trim());
        person.setBirthMonth(stateArray[2].trim());
        person.setBirthDay(stateArray[3].trim());
        person.setBirthYear(stateArray[4].trim());
        return person;
    }
    
    /**
     * Serializes a person in binary
     * 
     * @param oos the output stream for the data
     * @param person the person to be serialized
     * @throws IOException 
     */
    public static void writeObject(ObjectOutputStream objectOutputStream, Person person)throws IOException{
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(person.getFirstName() + ", " + person.getLastName() + ", " + person.getBirthMonth() + ", " + person.getBirthDay() + ", " + person.getBirthYear());

    }
    
    /**
     * Deserializes a person
     * @param ois the input stream for the data
     * @return a person with the data from a given file
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static Person readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        Person person = (Person) ois.readObject();
        return person;
    }
    
    /**
     * Prints out the state of the Person
     * 
     * @return a string formatted to print the persons state in a easily read format
     */
    public StringBuilder prettyPrint(){
        StringBuilder prettyString = new StringBuilder("");
        prettyString.append("First Name: ");
        prettyString.append(getFirstName());
        prettyString.append(System.getProperty( "line.separator" ));
        prettyString.append("Last Name: ");
        prettyString.append(getLastName());
        prettyString.append(System.getProperty( "line.separator" ));
        prettyString.append("Birth Month: ");
        prettyString.append(getBirthMonth());
        prettyString.append(System.getProperty( "line.separator" ));
        prettyString.append("Birth Day: ");
        prettyString.append(getBirthDay());
        prettyString.append(System.getProperty( "line.separator" ));
        prettyString.append("Birth Year: ");
        prettyString.append(getBirthYear());
        return prettyString;
    }
    
    @Override
    public boolean equals(Object p){
        if (p instanceof Person) {
            Person pp = (Person)p;
            
            boolean comparison = (this.firstName.compareToIgnoreCase(pp.getFirstName()) == 0);
            comparison = comparison && (this.lastName.compareToIgnoreCase(pp.getLastName()) == 0);
            comparison = comparison && (this.birthMonth.compareToIgnoreCase(pp.getBirthMonth()) == 0);
            comparison = comparison && (this.birthDay.compareToIgnoreCase(pp.getBirthDay()) == 0);
            comparison = comparison && (this.birthYear.compareToIgnoreCase(pp.getBirthYear()) == 0);
            
            return comparison;
        }
        return false;
    }
    
    @Override
    public int compareTo(Person otherPerson) {
        return this.lastName.compareToIgnoreCase(otherPerson.getLastName());
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthYear() {
        return birthYear;
    }
    
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
}
