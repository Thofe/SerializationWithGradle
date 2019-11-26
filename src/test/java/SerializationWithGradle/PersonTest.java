/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationWithGradle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bmitr
 */
public class PersonTest {
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCSVSerializationAndDeserialization() throws Exception{
        Person initialPerson = new Person("First", "Last", "1", "2", "3");
        Person.serializeToCSV("data.csv", initialPerson);
        
        Person replicaPerson =  Person.deserializeFromCSV("data.csv");
        
        assertEquals(initialPerson, replicaPerson);
    }

    @Test 
    public void binarySerializationAndDeserialization() throws Exception{
        Person initialPerson = new Person("First", "Last", "1", "2", "3");
        Person.serializeToBinary("data.bin", initialPerson);
        
        Person replicaPerson = Person.deserializeFromBinary("data.bin");
        
        assertEquals(initialPerson, replicaPerson);
    }
    
    @Test 
    public void binarySerializationAndDeserializationWithSerializerClass() throws Exception{
        Person initialPerson = new Person("First", "Last", "1", "2", "3");
        Serializer.serializeToBinary("data.bin", initialPerson);
        
        Person replicaPerson = (Person) Serializer.deserializeFromBinary("data.bin");
        
        assertEquals(initialPerson, replicaPerson);

    }
//    /**
//     * Test of serializeToCSV method, of class Person.
//     */
//    @Test
//    public void testSerializeToCSV() throws Exception {
//        System.out.println("serializeToCSV");
//        String file = "";
//        Person person = null;
//        Person.serializeToCSV(file, person);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deserializeFromCSV method, of class Person.
//     */
//    @Test
//    public void testDeserializeFromCSV() throws Exception {
//        System.out.println("deserializeFromCSV");
//        String file = "";
//        Person expResult = null;
//        Person result = Person.deserializeFromCSV(file);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of prettyPrint method, of class Person.
//     */
//    @Test
//    public void testPrettyPrint() {
//        System.out.println("prettyPrint");
//        Person instance = new Person();
//        String expResult = "";
//        String result = instance.prettyPrint();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
