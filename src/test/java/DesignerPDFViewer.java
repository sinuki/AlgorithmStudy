import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?isFullScreen=true
 */
public class DesignerPDFViewer {

    private int designerPdfViewer(int[] h, String word) {
        char[] letters = word.toCharArray();
        int tallest = Integer.MIN_VALUE;

        for (char letter : letters) {
            int value = h[letter - 'a'];

            if (value > tallest) {
                tallest = value;
            }
        }

        return tallest * word.length();
    }

    @Test
    public void test1() {
        assertEquals(9, designerPdfViewer(new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc"));
    }
}
