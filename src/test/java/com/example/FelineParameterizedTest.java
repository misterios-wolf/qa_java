package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {5},
                {10}
        };
    }

    // Проверка, что метод getKittens(int) возвращает переданное количество котят.
    @Test
    public void getKittensReturnsPassedCount() {
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        Assert.assertEquals(kittensCount, actual);
    }
}
