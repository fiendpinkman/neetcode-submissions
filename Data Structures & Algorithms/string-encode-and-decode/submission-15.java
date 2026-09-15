class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<str.length()) {
            if (str.charAt(i) == '#') {
                int length = Integer.parseInt(str.substring(j, i));
                int startIndex = i + 1;
                int endIndex = startIndex + length;
                result.add(str.substring(startIndex, endIndex));
                i = endIndex;
                j = endIndex;
            } else {
                i++;
            }
        }
        return result;
    }
}
