package teaurnrush;

public class TeaUrnRush {

    // Brute force: simulate minute by minute.
    // Each minute, pour one cup from each of the two drinks with the most cups left.
    public static int brute(int[] orders) {
        int[] left = {orders[0], orders[1], orders[2]};
        int minutes = 0;

        while (left[0] + left[1] + left[2] > 0) {
            // drink with the most cups left
            int first = 0;
            for (int i = 1; i < 3; i++) {
                if (left[i] > left[first]) {
                    first = i;
                }
            }
            // a different drink with the second most cups left (if any)
            int second = -1;
            for (int i = 0; i < 3; i++) {
                if (i != first && left[i] > 0) {
                    if (second == -1 || left[i] > left[second]) {
                        second = i;
                    }
                }
            }
            left[first]--;
            if (second != -1) {
                left[second]--;
            }
            minutes++;
        }
        return minutes;
    }

    // Optimized: formula.
    public static int optimized(int[] orders) {
        int total = orders[0] + orders[1] + orders[2];
        int largest = Math.max(orders[0], Math.max(orders[1], orders[2]));
        int half = (total + 1) / 2;   // total / 2 rounded up
        return Math.max(largest, half);
    }

    public static void main(String[] args) {
        int[] orders = {3, 5, 1};
        System.out.println(brute(orders) + " " + optimized(orders)); // 5 5
 }

}
