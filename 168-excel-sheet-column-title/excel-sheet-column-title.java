class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);
            result.insert(0, ch); // Add character to the front
            columnNumber /= 26;
        }
        
        return result.toString();
    }
}
