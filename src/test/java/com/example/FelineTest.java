package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    // Проверка, что метод getFamily() возвращает название семейства кошачьих
    @Test
    public void getFamilyReturnsCatFamily() {
        Feline feline = new Feline();

        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверка, что метод eatMeat() возвращает список пищи для хищника
    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expectedFood, feline.eatMeat());
    }
}
