class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
