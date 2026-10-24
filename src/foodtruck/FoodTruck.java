package foodtruck;

public class FoodTruck {
		
		// Brute force: try every starting day, extend the streak one day at a time.
	    public static int brute(int[] profit) {
	        int best = profit[0];
	        for (int start = 0; start < profit.length; start++) {
	            int sum = 0;
	            for (int end = start; end < profit.length; end++) {
	                sum += profit[end];
	                best = Math.max(best, sum);
	            }
	        }
	        return best;
	    }

	    // Optimized: Kadane's algorithm.
	    public static int optimized(int[] profit) {
	        int current = profit[0];   // best streak ending at day i
	        int best = profit[0];

	        for (int i = 1; i < profit.length; i++) {
	            // either continue the streak or start fresh at day i
	            current = Math.max(profit[i], current + profit[i]);
	            best = Math.max(best, current);
	        }
	        return best;
	    }

	    public static void main(String[] args) {
	        int[] profit = {3, -5, 4, -1, 2, 6, -9, 5};
	        System.out.println(brute(profit) + " " + optimized(profit)); // 11 11
	    }
}



