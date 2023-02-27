package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {
    private static Human testHuman;

    @BeforeAll
    public static void setBeforeTestHuman() {
        testHuman = new Human("test");
    }

    @AfterAll
    public static void setAfterTestHuman() {
        testHuman = null;
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "", "@"})
    public void testConvert(String name) {
        String expected = String.format("{\"name\":\"%s\"}", name);
        testHuman.setName(name);
        String actual = Parser.toJSON(testHuman);
        Assertions.assertEquals(expected, actual);
    }
}
