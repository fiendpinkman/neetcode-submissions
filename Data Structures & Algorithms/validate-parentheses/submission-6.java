class Solution {
    public boolean isValid(String s) {
        Stack<Character> sChar = new Stack<>();
        Map<Character, Character> cMap = new HashMap<>();
        cMap.put(')', '(');
        cMap.put('}', '{');
        cMap.put(']', '[');
        for (int i=0; i<s.length(); i++) {
            if (cMap.get(s.charAt(i))!=null && !sChar.isEmpty()) {
                Character c = sChar.peek();
                if (c == cMap.get(s.charAt(i))) {
                    sChar.pop();
                } else{
                    return false;
                }
            } else {
                sChar.push(s.charAt(i));
            }
        }
        if (!sChar.isEmpty()) {
            return false;
        }
        return true;
    }
}
