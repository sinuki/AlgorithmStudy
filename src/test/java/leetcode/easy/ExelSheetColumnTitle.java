package leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 **/
public class ExelSheetColumnTitle {

    private String convertToTitle(int n) {
        if (26 >= n)    return convertAlphabet(n);
        int val = n / 26;
        int rest = n % 26;
        // 26보다 큰 수이면서 나머지가 0인 경우, 끝에 항상 Z가 붙는다.
        if (0 == rest) {
            return convertToTitle(val - 1) + "Z";
        }
        // 그 외는 재귀적으로 호출
        return convertToTitle(val) + convertToTitle(rest);
    }

    private String convertAlphabet(int n) {
        switch (n) {
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            case 5: return "E";
            case 6: return "F";
            case 7: return "G";
            case 8: return "H";
            case 9: return "I";
            case 10: return "J";
            case 11: return "K";
            case 12: return "L";
            case 13: return "M";
            case 14: return "N";
            case 15: return "O";
            case 16: return "P";
            case 17: return "Q";
            case 18: return "R";
            case 19: return "S";
            case 20: return "T";
            case 21: return "U";
            case 22: return "V";
            case 23: return "W";
            case 24: return "X";
            case 25: return "Y";
            case 26: return "Z";
        }
        return "";
    }
}
