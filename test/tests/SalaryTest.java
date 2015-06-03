/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import bmw.assigment.AbstractEmployee;
import bmw.assigment.BMWAssigment;
import static bmw.assigment.BMWAssigment.populateSubordinate;
import com.google.gson.JsonObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit calls to test the file reading, the recursive method that populates the hierarchy
 * and the salary
 * 
 * @author George
 */
public class SalaryTest {
    
    private BMWAssigment main;
    
    public SalaryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        main = new BMWAssigment();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void companyEmployeeFullSalarySum() {

     JsonObject jsonRoot = main.readJsonFile();
   
     assertNotNull(jsonRoot);
    
     AbstractEmployee root = populateSubordinate(jsonRoot);
     assertNotNull(root);
        
     assertEquals("Full salary must be", 275000, root.getSalaries());

     System.out.println(root.getNames());
 
  }
}
