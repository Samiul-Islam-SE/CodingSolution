
class Solution {

    // GfG EXPECTS THIS EXACT METHOD NAME
    @SuppressWarnings("unchecked")
    public String removeKdig(String nums, int k) {

        List<Integer>[] arr = new ArrayList[12];
        for (int i = 0; i < 12; i++) {
            arr[i] = new ArrayList<>();
        }

        // Store positions of each digit
        for (int i = 0; i < nums.length(); i++) {
            int digit = nums.charAt(i) - '0';
            arr[digit].add(i);
        }

        int need = nums.length() - k;
        int taken = 0;
        int lastI = -1;
        StringBuilder ans = new StringBuilder();

        while (taken < need) {
            for (int d = 0; d <= 9; d++) {

                int pos = upperBound(arr[d], lastI);
                if (pos == arr[d].size()) continue;

                int index = arr[d].get(pos);
                int nextI = index + (need - taken - 1);

                if (nextI < nums.length()) {
                    // avoid leading zero
                    if (!(d == 0 && ans.length() == 0)) {
                        ans.append(nums.charAt(index));
                    }
                    lastI = index;
                    taken++;
                    break;
                }
            }
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }

    // upper_bound implementation
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}