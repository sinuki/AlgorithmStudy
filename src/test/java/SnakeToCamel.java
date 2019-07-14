import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakeToCamel {

    private String solve(String columnName) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columnName.length(); i++) {
            if ('_' == columnName.charAt(i)) {
                sb.append(String.valueOf(columnName.charAt(++i)).toUpperCase());
            } else {
                sb.append(columnName.charAt(i));
            }
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        assertEquals("memberId", solve("member_id"));
    }

    @Test
    public void test2() {
        assertEquals("taxRegId", solve("tax_reg_id"));
    }

    @Test
    public void test3() {
        assertEquals("delYn", solve("del_yn"));
    }
}