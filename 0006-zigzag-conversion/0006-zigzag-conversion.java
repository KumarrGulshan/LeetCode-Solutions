class Solution {
    public String convert(String s, int numRows) {
        // Edge case: No zigzagging possible
        if (numRows == 1 || s.length() <= numRows) return s;

        // Create a list of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // If we are at the top or bottom, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}