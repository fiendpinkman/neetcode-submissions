class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i<str.length(); i++) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j+1, j+1+length));
            i = j + length;
        }
        return result;
    }
}
