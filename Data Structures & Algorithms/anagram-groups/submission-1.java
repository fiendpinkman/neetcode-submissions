class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList<>();
      Map<String, List<String>> subResult = new HashMap<>();

      for (String str: strs) {
        int[] cArray = new int[26];
        for (char c: str.toCharArray()) {
          cArray[c-'a']++;
        }
        List<String> currentResult = subResult.getOrDefault(Arrays.toString(cArray), new ArrayList<>());
        currentResult.add(str);
        subResult.put(Arrays.toString(cArray), currentResult);
      }

      for (Map.Entry s:subResult.entrySet()) {
        result.add((List<String>) s.getValue());
      }

      return result;
    }
}
