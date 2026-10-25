

public class RooftopPuddles {
	
	
    public static int brute(int[] heights) {
        int water = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }
            int rightMax = 0;
            for (int j = i; j < heights.length; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }
            water += Math.min(leftMax, rightMax) - heights[i];
        }
        return water;
    }

    // Optimized: two pointers moving toward each other.
    public static int optimized(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                // the right side has a taller wall, so leftMax decides the water here
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    water += leftMax - heights[left];
                }
                left++;
            } else {
                // the left side has a wall at least as tall, so rightMax decides
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    water += rightMax - heights[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] heights = {3, 0, 2, 0, 4, 1, 2};
        System.out.println(brute(heights) + " " + optimized(heights)); 
    }
}
	
