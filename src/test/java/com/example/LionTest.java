package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    // Проверка, что у льва-самца есть грива
    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);

        Assert.assertTrue(lion.doesHaveMane());
    }

    // Проверка, что у льва-самки нет гривы
    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);

        Assert.assertFalse(lion.doesHaveMane());
    }

    // Проверка, что при передаче некорректного значения выбрасывается исключение
    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", feline);
    }

    // Проверка, что метод getKittens() возвращает количество котят от Feline
    @Test
    public void getKittensReturnsKittensCountFromPredator() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", feline);

        Assert.assertEquals(5, lion.getKittens());

        Mockito.verify(feline).getKittens();
    }

    // Проверка, что метод getFood() возвращает список еды от Feline
    @Test
    public void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);

        Assert.assertEquals(expectedFood, lion.getFood());

        Mockito.verify(feline).eatMeat();
    }
}
