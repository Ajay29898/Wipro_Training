package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class allUnit 
{
    @Test
    @Order(1)
    void testSquare() {
        int result = square(4);
        assertEquals(16, result);
    }

    @Test
    @Order(2)
    void testSum() {
        int result = sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    @Order(3)
    void testSub() {
        int result = sub(5, 3);
        assertEquals(2, result);
    }

    @Test
    @Order(4)
    void testMul() {
        int result = mul(2, 3);
        assertEquals(6, result);
    }

    @Test
    @Order(5)
    void testDiv() {
        int result = div(6, 3);
        assertEquals(2, result);
    }

    @Test
    @Order(6)
    void testMod() {
        int result = mod(5, 2);
        assertEquals(1, result);
    }

    @Test
    @Order(7)
    void testAddwithzero() {
        int result = addwithzero(0, 5);
        assertEquals(5, result);
    }

    @Test
    @Order(8)
    void testAddwithlargno() {
        int result = addwithlargno(1000000, 2000000);
        assertEquals(3000000, result);
    }

    public int square(int n) {
        return n * n;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public int addwithzero(int a, int b) {
        return a + b;
    }

    public int addwithlargno(int a, int b) {
        return a + b;
    }
}
