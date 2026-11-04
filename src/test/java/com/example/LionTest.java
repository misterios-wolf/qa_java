package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;

    // Проверка, что у льва-самца есть грива
    @Test
    public void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);

        Assert.assertTrue(lion.doesHaveMane());
    }

    // Проверка, что у льва-самки нет гривы
    @Test
    public void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);

        Assert.assertFalse(lion.doesHaveMane());
    }

    // Проверка, что при передаче некорректного значения выбрасывается исключение
    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", predator);
    }

    // Проверка, что метод getKittens() возвращает количество котят от Predator
    @Test
    public void getKittensReturnsKittensCountFromPredator() throws Exception {
        Mockito.when(predator.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", predator);

        Assert.assertEquals(5, lion.getKittens());

        Mockito.verify(predator).getKittens();
    }

    // Проверка, что метод getFood() возвращает список еды от Predator
    @Test
    public void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", predator);

        Assert.assertEquals(expectedFood, lion.getFood());

        Mockito.verify(predator).eatMeat();
    }
}
