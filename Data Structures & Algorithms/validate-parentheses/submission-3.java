class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> ref = new HashMap<>();
        ref.put(')', '(');
        ref.put(']', '[');
        ref.put('}', '{');
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                Character ch = ref.get(c);
                if (!st.isEmpty() && st.peek() == ch){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
