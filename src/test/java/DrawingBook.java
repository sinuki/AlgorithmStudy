import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawingBook {

    private int pageCount(int n, int p) {
        int diff = n - p;
        int fromBack = n % 2 == 0 ? (int) Math.ceil(diff / 2.0) : diff / 2;
        int fromFront = p / 2;

        return fromBack < fromFront ? fromBack : fromFront;
    }

    @Test
    public void test1() {
        assertEquals(1, pageCount(6, 2));
    }

    @Test
    public void test2() {
        assertEquals(0, pageCount(5, 4));
    }

    @Test
    public void test3() {
        assertEquals(1, pageCount(6, 5));
    }
}