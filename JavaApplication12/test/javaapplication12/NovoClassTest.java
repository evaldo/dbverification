/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class NovoClassTest {
    
    public NovoClassTest() {
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

    /**
     * Test of calcularAprovacao method, of class NovoClass.
     */
    @Test
    public void testCalcularAprovacao() {
        System.out.println("calcularAprovacao");
        float nota1 = 100.0F;
        float nota2 = 0.0F;
        NovoClass instance = new NovoClass();
        boolean expResult = false;
        boolean result = instance.calcularAprovacao(nota1, nota2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
