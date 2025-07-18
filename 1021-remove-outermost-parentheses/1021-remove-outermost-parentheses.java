class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0; 

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If count > 0, it's not an outer parenthesis
                if (count > 0) {
                    result.append(c);
                }
                count++;
            } else {
                count--;
                // If count > 0 after decrement, it's not an outer parenthesis
                if (count > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
