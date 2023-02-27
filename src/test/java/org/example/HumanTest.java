package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class HumanTest {
    private static Human testHuman;

    @BeforeAll
    public static void setBeforeTestHuman() {
        testHuman = new Human("test");
    }

    @AfterAll
    public static void setAfterTestHuman() {
        testHuman = null;
    }

    @Test
    public void testGetter() {
        String expected = testHuman.getName();
        Assertions.assertEquals(expected, testHuman.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"munir", "andrey", "anna"})
    public void testSetterName(String name) {
        testHuman.setName(name);
        Assertions.assertEquals(name, testHuman.getName());
    }

    @Test
    public void testSetterNull() {
        Class<? extends Throwable> expected = NullPointerException.class;
        Executable executable = () -> testHuman.setName(null);
        Assertions.assertThrowsExactly(expected, executable);
    }

    @ParameterizedTest
    @CsvSource({"a, 3", "aa, 2", "aaa, 1", "aaaa, 0", "aaaaa, -1"})
    public void testCompareTo(String name, int expected) {
        Human tempHuman = new Human(name);
        int actual = testHuman.compareTo(tempHuman);
        Assertions.assertEquals(expected, actual);
    }
}