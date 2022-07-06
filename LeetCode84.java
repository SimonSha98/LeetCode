class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i <= heights.length; i ++){// <= heights.length to pop all the remaining items in the stack
            while(!stack.isEmpty() && (i == heights.length ? 0 : heights[i]) < heights[stack.peek()]){
                max = Math.max(max, heights[stack.pop()] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1)); // -1 because for the last height in the stack we don't have anything on the left
            }
            stack.push(i);
        }

        return max;
    }
}
