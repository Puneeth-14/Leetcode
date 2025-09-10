import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        List<Set<Integer>> langs = new ArrayList<>();
        for (int[] personLangs : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : personLangs) {
                set.add(l);
            }
            langs.add(set);
        }

        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; 
            int v = f[1] - 1;
            Set<Integer> setU = langs.get(u);
            Set<Integer> setV = langs.get(v);

            boolean canTalk = false;
            for (int l : setU) {
                if (setV.contains(l)) {
                    canTalk = true;
                    break;
                }
            }

            if (!canTalk) {
                candidates.add(u);
                candidates.add(v);
            }
        }

       
        if (candidates.isEmpty()) return 0;

        int res = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int teachCount = 0;
            for (int person : candidates) {
                if (!langs.get(person).contains(lang)) {
                    teachCount++;
                }
            }
            res = Math.min(res, teachCount);
        }

        return res;
    }
}
