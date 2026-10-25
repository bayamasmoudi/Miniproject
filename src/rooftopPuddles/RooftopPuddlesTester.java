package rooftopPuddles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RooftopPuddlesTester {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "tests/1C_large.txt";
        boolean runBrute = true;   

        Scanner in = new Scanner(new File(fileName));
        String name = "";
        int[] input = new int[0];
        int passed = 0;
        int total = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();

            if (line.isEmpty() || line.startsWith("#")) {
               
            	
            } else if (line.startsWith("case:")) {
                name = line.substring(5).trim();
            } else if (line.startsWith("tags:")) {
                // on ignore les tags
            } else if (line.startsWith("expect:")) {
                int expected = Integer.parseInt(line.substring(7).trim());
                int o = RooftopPuddles.optimized(input);
                int b = expected;
                if (runBrute) {
                    b = RooftopPuddles.brute(input);
                }
                total++;

                if (b == expected && o == expected) {
                    passed++;
                    System.out.println("PASS  " + name);
                } else {
                    System.out.println("FAIL  " + name + " | expected " + expected
                            + ", brute " + b + ", optimized " + o);
                }
            } else if (line.contains(":")) {
                
                input = parseNumbers(line.substring(line.indexOf(":") + 1));
            }
        }
        in.close();
        System.out.println(passed + "/" + total + " tests passed");
    }

    // transforme "3 0 2" en tableau {3, 0, 2}
    static int[] parseNumbers(String text) {
        text = text.trim();
        if (text.isEmpty()) {
            return new int[0];
        }
        String[] parts = text.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }
}


