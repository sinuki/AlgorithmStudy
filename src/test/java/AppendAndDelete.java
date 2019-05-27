import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppendAndDelete {

    private String appendAndDelete(String s, String t, int k) {
        if (s.length() + t.length() <= k) return "Yes";
        if (s.length() > t.length()) {
            k -= s.length() - t.length();

            if (0 > k)  return "No";
        }

        int index = Math.min(s.length(), t.length());
        StringBuilder sb = new StringBuilder();

        while (0 <= index && 0 <= k) {
            String sub = s.substring(0, index);

            if (sub.equals(t.substring(0, index))) {
                sb.append(sub);
                break;
            }

            index--;
            k--;
        }

        if (sb.length() < t.length()) {
            int limit = Math.min(index + k, t.length());
            sb.append(t.substring(index, limit));
            k -= (limit - index);
        }

        return sb.toString().equals(t) && (k % 2 == 0) ? "Yes" : "No";
    }

    @Test
    public void test1() {
        assertEquals("Yes", appendAndDelete("abc", "def", 6));
    }

    @Test
    public void test2() {
        assertEquals("Yes", appendAndDelete("hackerhappy", "hackerrank", 9));
    }

    @Test
    public void test3() {
        assertEquals("Yes", appendAndDelete("aba", "aba", 7));
    }

    @Test
    public void test4() {
        assertEquals("No", appendAndDelete("ashley", "ash", 2));
    }
}