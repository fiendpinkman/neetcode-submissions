class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        Map<Character, Integer> mChar = new HashMap<>();
        for(char c:s1.toCharArray()) {
            mChar.put(c, mChar.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <= s2.length() - k; i++) {
            Map<Character, Integer> tChar = new HashMap<>();
            int count = 0;
            while(count != k){
                int index = count + i;
                tChar.put(s2.charAt(index), tChar.getOrDefault(s2.charAt(index),0)+1);
                count++;
            }
            boolean result = true;
            for (Map.Entry<Character, Integer> ch: mChar.entrySet()) {
                Character c = ch.getKey();
                Integer value = ch.getValue();
                if (tChar.get(c) != null && tChar.get(c) == value) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
        }
        return false;
    }
}
