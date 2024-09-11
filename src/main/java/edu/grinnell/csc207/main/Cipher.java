package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Class that handles user input for all kind of ciphers.
 */
public class Cipher {
  /**
   * length of the input.
   */
  public static final int LENGTH = 4;

  /**
   * @param args main function for the cipher class
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.err, true);
    String mode = null;
    String type = null;
    String input = null;
    String key = null;

    // Validate the number of arguments
    if (args.length != LENGTH) {
      pen.println("Error: Incorrect number of parameters.");
      return;
    } //If statement

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-encode") && mode == null) {
        mode = "encode";
      } else if (args[i].equals("-decode") && mode == null) {
        mode = "decode";
      } else if (args[i].equals("-caesar") && type == null) {
        type = "caesar";
      } else if (args[i].equals("-vigenere") && type == null) {
        type = "vigenere";
      } else if (input != null && key == null) {
        key = args[i];
      } else {
        if (input == null) {
          input = args[i]; // First non-dash argument is the string to encode/decode
        } else {
          pen.println("Error: Input arguments not correct.");
          return;
        } //If statement
      } //If statement
    } //For loop

    // Validate the arguments
    if (mode == null) {
      pen.println("Error: Missing cipher mode (-encode or -decode).");
      return;
    } //If statement
    if (type == null) {
      pen.println("Error: Missing cipher type (-caesar or -vigenere).");
      return;
    } //If statement
    if (input == null) {
      pen.println("Error: Missing string for cipher.");
      return;
    } //If statement

    if (key == null) {
      pen.println("Error: Missing cipher key.");
      return;
    } //If statement


    String output = null;

    // Validate the key length for Caesar cipher
    if (type.equals("caesar") && key.length() != 1) {
      pen.println("Error: Caesar cipher key must be a single letter.");
      return;
    } else if (type.equals("caesar")) {
      if (mode.equals("encode")) {
        output = CipherUtils.caesarEncrypt(input, key.charAt(0));
      } else {
        output = CipherUtils.caesarDecrypt(input, key.charAt(0));
      } //If statement
    } else if (type.equals("vigenere")) {
      if (mode.equals("encode")) {
        output = CipherUtils.vigenereEncrypt(input, key);
      } else {
        output = CipherUtils.vigenereDecrypt(input, key);
      } //If statement
    } //If statement

    if (output != null) {
      pen.printf("The encoded/decoded string is: %s\n", output);
    } else {
      pen.println("Error: Your input shouldn't be nothing.");
    } //If statement

    pen.close();

  } //main
} //The whole class
