/**
 * The `AllCaesar` class is a testing class for `CipherUtil` that encodes or decodes a target string
 * using Caesar cipher for all 26 shifts based on user input.
 */
package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Testing class for the CipherUtil and also handles illegal input.
 */
public class AllCaesar {

  /**
   * @param args first argument is encode/decode. second argument is the target string.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    } //If statement

    String mode = args[0];
    String str = args[1];

    if (!("encode".equals(mode) || "decode".equals(mode))) {
      System.err.printf("Error: Invalid option: \"%s\"."
          + "Valid options are \"encode\" or \"decode\".\n", mode);
    } //If statement

    // Validate the second argument (only lowercase letters)
    for (char ch : str.toCharArray()) {
      if (!Character.isLowerCase(ch)) {
        System.err.println("Error: String contains characters other than lowercase letters.");
      } //If statement
    } //for loop

    // Depending on the mode, either encode or decode the string for all 26 shifts
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if ("encode".equals(mode)) {
        pen.printf("n = %c: %s\n\n", ch, CipherUtils.caesarEncrypt(str, ch));
        //pen.println();
      } else {
        pen.printf("n = %c: %s\n\n", ch, CipherUtils.caesarDecrypt(str, ch));
        //pen.println();
      } //If statement
    } //for loop

    pen.close();
  } //main
} //AllCaeser class
