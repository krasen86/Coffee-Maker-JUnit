package edu.ncsu.csc326.coffeemaker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;

import static org.mockito.Mockito.*;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(Main.class)
public class MainTest{

    private Assertions a;
    private Main mock;

    @BeforeEach
    void setUp() throws Exception {
//        Main main = mock(Main.class);
//        mock = PowerMockito.spy(main);
//        mock = PowerMockito.spy(new Main());
//        PowerMockito.doReturn(returnValue()).when(mock, "inputOutput", ArgumentMatchers.any()); //(mock, "inputOutput", ArgumentMatchers.anyString());
//        PowerMockito.verifyPrivate(mock, Mockito.times(1).)
    }

    String returnValue(){
         return "0";
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testExitMethodMainMenu() throws IOException {
 //     Main.mainMenu();
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
