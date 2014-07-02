/* "Matches.java" allows users to search a word in a given word list and a list of letters. It detects all the words in the list that
can be generated from the given letters. 

For example if I give the letters "maa"
the program prints out:
maa
aam
ama*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matches {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Enter the string: ");
        String givenName = null;
        /*
         * Throws an IOException if there is a problem with given command-line
         * input.
         */
        try {
            // Reading input from command-line.
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            /*
             * Throws an IOException if there is a problem in reading the
             * command-line input.
             */
            try {
                givenName = br.readLine();
            } catch (IOException e1) {
                System.err.println("Error1: " + e1);
                e1.printStackTrace();
            }
            /*
             * Reads the file named "kotus_sanat.txt" located at location
             * "/home/mankas/Documents/code/".
             */
            BufferedReader br_file = new BufferedReader(new FileReader(
                    new File("/home/mankas/Documents/code/kotus_sanat.txt")));
            String line = null;

            /*
             * Throws an FileNotFoundException if there is a problem with
             * reading the given file.
             */
            try {
                /*
                 * When there are no more lines to read from file
                 * "br_file.readLine" returns null.
                 */
                while ((line = br_file.readLine()) != null) {
                    if (givenName.length() == line.length()) {
                        isMatch(givenName, line);
                    }
                }

                // Displays below statement when done with searching the file.
                System.out.println("Reached End of File. "
                        + "No more results to display ");
                // Close buffered reader after use.
                br.close();
                br_file.close();

            } catch (IOException e2) {
                System.err.println("Error2: " + e2);
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("error trying to read a file");
            e.printStackTrace();
        }
    }

    /*
     * "isMatch" method compares the given string with the list of strings from
     * file and displays the anagrams of the given string.
     */

    public static void isMatch(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String str1 = new String(c1);
        String str2 = new String(c2);
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(s2); // Displays matching string from file.
        }
    }

}
