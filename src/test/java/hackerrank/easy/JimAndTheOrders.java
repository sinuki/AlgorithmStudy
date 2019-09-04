package hackerrank.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/jim-and-the-orders/problem?isFullScreen=true
 */
public class JimAndTheOrders {

    static class Order {
        Integer customerNo;
        Integer serveTime;

        Order(int customerNo, int[] times) {
            this.customerNo = customerNo;
            this.serveTime = IntStream.of(times).sum();
        }
    }

    private int[] jimOrders(int[][] orders) {
        List<Order> list = new ArrayList<>();
        int i = 1;
        for (int[] order : orders) {
            list.add(new Order(i++, order));
        }

        return list.stream().sorted((o1, o2) -> {
            int order = o1.serveTime.compareTo(o2.serveTime);

            if (0 == order) {
                return o1.customerNo.compareTo(o2.customerNo);
            }

            return order;
        }).mapToInt(order -> order.customerNo).toArray();
    }

    @Test
    public void test1() {
        int[][] orders = new int[][] {
            new int[] {8, 3},
            new int[] {5, 6},
            new int[] {6, 2},
            new int[] {2, 3},
            new int[] {4, 3}
        };
        assertArrayEquals(new int[] {4, 5, 3, 1, 2,}, jimOrders(orders));
    }
}