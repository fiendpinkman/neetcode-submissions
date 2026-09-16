class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> iMap = new HashMap<>();
        iMap.put(')', '(');
        iMap.put(']', '[');
        iMap.put('}', '{');

        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (isValidOpening(currentChar)) {
                st.add(currentChar);
            } else {
                Character getClosing = iMap.get(currentChar);
                if (!st.isEmpty() && st.peek() == getClosing) {
                    st.remove(st.peek());
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }

    public boolean isValidOpening(Character c) {
        if ( c == '(' || c == '{' || c == '[') return true;
        return false;
    }
}
