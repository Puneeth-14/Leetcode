import java.util.*;

public class Solution {
    private static final Set<Character> VOWELS = new HashSet<>(
        Arrays.asList('a','e','i','o','u')
    );

    private static String maskVowels(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> maskMap = new HashMap<>();

        for (String w : wordlist) {
            exact.add(w);
        }
        for (String w : wordlist) {
            String lower = w.toLowerCase();
            lowerMap.putIfAbsent(lower, w);
            String masked = maskVowels(lower);
            maskMap.putIfAbsent(masked, w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }
            String qLower = q.toLowerCase();
            if (lowerMap.containsKey(qLower)) {
                ans[i] = lowerMap.get(qLower);
                continue;
            }
            String qMask = maskVowels(qLower);
            if (maskMap.containsKey(qMask)) {
                ans[i] = maskMap.get(qMask);
                continue;
            }
            ans[i] = "";
        }
        return ans;
    }
}
