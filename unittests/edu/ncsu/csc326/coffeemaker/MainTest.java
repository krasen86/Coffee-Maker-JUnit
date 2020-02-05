package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MainTest{

    Assertions a;
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testExitMethodMainMenu() throws IOException {
//        setInputStream("1\nA Recipe\n23\n2\n2\n1\n0\n0");
//        main.mainMenu();
    }

    @Test
    void addRecipe() {
    }

    @Test
    void deleteRecipe() {
    }

    @Test
    void editRecipe() {
    }

    @Test
    void addInventory() {
    }

    @Test
    void checkInventory() {
    }

    @Test
    void makeCoffee() {
    }

    @Test
    void main() {
    }

    void setInputStream(String input) throws IOException {
        InputStream inputStream;
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(br.readLine());
    }
}
