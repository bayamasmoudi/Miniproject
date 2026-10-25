

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeaUrnTester {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("tests/1A_large.txt"));
        String name = "";
        int[] orders = new int[3];
        int passed = 0;
        int total = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();

            if (line.startsWith("case:")) {
                name = line.substring(5).trim();
            } else if (line.startsWith("orders:")) {
                String[] parts = line.substring(7).trim().split("\\s+");
                for (int i = 0; i < 3; i++) {
                    orders[i] = Integer.parseInt(parts[i]);
                }
            } else if (line.startsWith("expect:")) {
                int expected = Integer.parseInt(line.substring(7).trim());
                int b = TeaUrn.brute(orders);
                int o = TeaUrn.optimized(orders);
                total++;

                if (b == expected && o == expected) {
                    passed++;
                    System.out.println("PASS  " + name);
                } else {
                    System.out.println("FAIL  " + name + " | expected " + expected
                            + ", brute " + b + ", optimized " + o);
                }
            }
        }
        in.close();
        System.out.println(passed + "/" + total + " tests passed");
    }
}
