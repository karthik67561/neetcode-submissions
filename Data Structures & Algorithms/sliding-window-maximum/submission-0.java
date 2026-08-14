class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        java.util.Deque<Integer> dq = new java.util.ArrayDeque<>();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                ans[j++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}