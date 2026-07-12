class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int step = 1; // 1 = moving down, -1 = moving up

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // Change direction at top or bottom
            if (row == 0) step = 1;
            else if (row == numRows - 1) step = -1;

            row += step;
        }

        // Combine rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}