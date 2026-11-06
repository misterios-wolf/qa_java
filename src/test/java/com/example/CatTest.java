package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    // Проверка, что метод getSound() возвращает звук кошки
    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(new Feline());

        Assert.assertEquals("Мяу", cat.getSound());
    }

    // Проверка, что метод getFood() возвращает список еды от Feline
    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);

        Assert.assertEquals(expectedFood, cat.getFood());
        Mockito.verify(feline).eatMeat();
    }

    @Mock
    Feline feline;
}
