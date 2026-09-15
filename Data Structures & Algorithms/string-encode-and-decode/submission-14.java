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
                System.out.println("Found char At" + i + " j" + j);
                int length = Integer.parseInt(str.substring(j, i));
                System.out.println("Length" + length);
                int startIndex = i + 1;
                System.out.println("Start " + startIndex);
                int endIndex = startIndex + length;
                System.out.println("End Index " + endIndex);
                System.out.println(str.substring(startIndex, endIndex));
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
