package org.shandakova;

import org.junit.Assert;
import org.junit.Test;


public class NumberTaskTest {
    private final NumberTask task = new NumberTask();

    @Test
    public void wrongInput_findLostNumberWithRepeated() {
        int res = task.findLostNumberWithRepeated(null);
        Assert.assertEquals(-1, res);

        res = task.findLostNumberWithRepeated(new int[]{});
        Assert.assertEquals(-1, res);

        res = task.findLostNumberWithRepeated(new int[]{1});
        Assert.assertEquals(-1, res);
    }

    @Test
    public void wrongInput_findLostNumber() {
        int res = task.findLostNumber(null);
        Assert.assertEquals(-1, res);

        res = task.findLostNumber(new int[]{});
        Assert.assertEquals(-1, res);

        res = task.findLostNumber(new int[]{1});
        Assert.assertEquals(-1, res);
    }

    @Test
    public void inputWithoutMissing_findLostNumberWithRepeated() {
        int res = task.findLostNumberWithRepeated(new int[]{1, 2, 3, 4});
        Assert.assertEquals(-1, res);

        res = task.findLostNumberWithRepeated(new int[]{7, 7, 7, 7, 7, 7});
        Assert.assertEquals(-1, res);
    }

    @Test
    public void inputWithoutMissing_findLostNumber() {
        int res = task.findLostNumber(new int[]{1, 2, 3, 4});
        Assert.assertEquals(-1, res);
    }

    @Test
    public void inputWithoutDoubles_findLostNumber() {
        int res = task.findLostNumber(new int[]{5, 0, 1, 3, 2});
        Assert.assertEquals(4, res);

        res = task.findLostNumber(new int[]{7, 9, 10, 11, 12});
        Assert.assertEquals(8, res);
    }

    @Test
    public void inputWithoutDoubles_findLostNumberWithRepeated() {
        int res = task.findLostNumberWithRepeated(new int[]{5, 0, 1, 3, 2});
        Assert.assertEquals(4, res);

        res = task.findLostNumberWithRepeated(new int[]{7, 9, 10, 11, 12});
        Assert.assertEquals(8, res);

        res = task.findLostNumberWithRepeated(new int[]{5, 7, 9, 10, 12});
        Assert.assertEquals(6, res);
    }

    @Test
    public void inputWithDoubles_findLostNumber() {
        int res = task.findLostNumberWithRepeated(new int[]{5, 0, 1, 2, 5, 3, 2});
        Assert.assertEquals(4, res);

        res = task.findLostNumberWithRepeated(new int[]{2, 2, 4, 4, 4, 2, 4, 4, 4});
        Assert.assertEquals(3, res);
    }


}