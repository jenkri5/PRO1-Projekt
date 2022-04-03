package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyDiceTest {
    private final YatzyDice dice = new YatzyDice();

    @Test
    public void testSameFaceValuePoints() {
        int[] values = {1, 2, 3, 4, 5};
        dice.setValues(values);
        int[] expected = {0, 1, 2, 3, 4, 5, 0};
        int[] results = new int[7];
        for (int value = 1; value <= 6; value++) {
            results[value] = dice.sameValuePoints(value);
        }
        assertArrayEquals(expected, results);

        int[] values1 = {3, 4, 6, 6, 3};
        dice.setValues(values1);
        int[] expected1 = {0, 0, 0, 6, 4, 0, 12};
        int[] results1 = new int[7];
        for (int value = 1; value <= 6; value++) {
            results1[value] = dice.sameValuePoints(value);
        }
        assertArrayEquals(expected1, results1);
    }

    @Test
    public void testOnePairPoints() {
        int[] values = {1, 6, 5, 4, 3};
        dice.setValues(values);
        int result = dice.onePairPoints();
        assertEquals(0, result);

        int[] values1 = {4, 6, 5, 4, 3};
        dice.setValues(values1);
        int result1 = dice.onePairPoints();
        assertEquals(8, result1);

        int[] values2 = {3, 3, 6, 3, 6};
        dice.setValues(values2);
        int result2 = dice.onePairPoints();
        assertEquals(12, result2);

        int[] values3 = {3, 3, 6, 3, 5};
        dice.setValues(values3);
        int result3 = dice.onePairPoints();
        assertEquals(6, result3);
    }

    @Test
    public void testTwoPairPoints() {
        int[] values = {1, 2, 3, 5, 6};
        dice.setValues(values);
        int result = dice.twoPairPoints();
        assertEquals(0, result);

        int[] values1 = {4, 2, 3, 4, 2};
        dice.setValues(values1);
        int result1 = dice.twoPairPoints();
        assertEquals(12, result1);

        int[] values2 = {5, 5, 6, 6, 5};
        dice.setValues(values2);
        int result2 = dice.twoPairPoints();
        assertEquals(22, result2);

        int[] values3 = {5, 1, 5, 5, 5};
        dice.setValues(values3);
        int result3 = dice.twoPairPoints();
        assertEquals(0, result3);
    }

    @Test
    public void testThreeSamePoints() {
        int[] values = {2, 3, 6, 6, 5};
        dice.setValues(values);
        int result = dice.threeSamePoints();
        assertEquals(0, result);

        int[] values1 = {6, 3, 6, 6, 5};
        dice.setValues(values1);
        int result1 = dice.threeSamePoints();
        assertEquals(18, result1);

        int[] values2 = {6, 3, 6, 6, 6};
        dice.setValues(values2);
        int result2 = dice.threeSamePoints();
        assertEquals(18, result2);
    }

    @Test
    public void testFourSamePoints() {
        int[] values = {1, 2, 5, 6, 3};
        dice.setValues(values);
        int result = dice.fourSamePoints();
        assertEquals(0, result);

        int[] values1 = {2, 6, 5, 2, 2};
        dice.setValues(values1);
        int result1 = dice.fourSamePoints();
        assertEquals(0, result1);

        int[] values2 = {2, 2, 5, 2, 2};
        dice.setValues(values2);
        int result2 = dice.fourSamePoints();
        assertEquals(8, result2);

        int[] values3 = {2, 2, 2, 2, 2};
        dice.setValues(values3);
        int result3 = dice.fourSamePoints();
        assertEquals(8, result3);
    }

    @Test
    public void testFullHousePoints() {
        int[] values = {6, 5, 4, 2, 1};
        dice.setValues(values);
        int result = dice.fullHousePoints();
        assertEquals(0, result);

        int[] values1 = {3, 3, 2, 3, 1};
        dice.setValues(values1);
        int result1 = dice.fullHousePoints();
        assertEquals(0, result1);

        int[] values2 = {3, 3, 5, 3, 5};
        dice.setValues(values2);
        int result2 = dice.fullHousePoints();
        assertEquals(19, result2);

        int[] values3 = {5, 5, 5, 5, 5};
        dice.setValues(values3);
        int result3 = dice.fullHousePoints();
        assertEquals(0, result3);
    }

    @Test
    public void testSmallStraightPoints() {
        int[] values = {1, 2, 3, 4, 6};
        dice.setValues(values);
        int result = dice.smallStraightPoints();
        assertEquals(0, result);

        int[] values1 = {1, 3, 5, 2, 4};
        dice.setValues(values1);
        int result1 = dice.smallStraightPoints();
        assertEquals(15, result1);

        int[] values2 = {1, 3, 6, 2, 4};
        dice.setValues(values2);
        int result2 = dice.smallStraightPoints();
        assertEquals(0, result2);
    }

    @Test
    public void testLargeStraightPoints() {
        int[] values = {1, 2, 3, 4, 6};
        dice.setValues(values);
        int result = dice.largeStraightPoints();
        assertEquals(0, result);

        int[] values1 = {6, 3, 5, 2, 4};
        dice.setValues(values1);
        int result1 = dice.largeStraightPoints();
        assertEquals(20, result1);

        int[] values2 = {1, 3, 5, 2, 4};
        dice.setValues(values2);
        int result2 = dice.largeStraightPoints();
        assertEquals(0, result2);
    }

    @Test
    public void testChancePoints() {
        int[] values = {3, 6, 2, 3, 4};
        dice.setValues(values);
        int result = dice.chancePoints();
        assertEquals(18, result);

        int[] values1 = {6, 6, 6, 6, 6};
        dice.setValues(values1);
        int result1 = dice.chancePoints();
        assertEquals(30, result1);
    }

    @Test
    public void testYatzyPoints() {
        int[] values = {3, 3, 3, 3, 5};
        dice.setValues(values);
        int result = dice.yatzyPoints();
        assertEquals(0, result);

        int[] values1 = {3, 3, 3, 3, 3};
        dice.setValues(values1);
        int result1 = dice.yatzyPoints();
        assertEquals(50, result1);
    }
}
