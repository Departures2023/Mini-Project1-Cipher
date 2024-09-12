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
    PrintWriter pen = new PrintWriter(System.out, true);
    String mode = null;
    String type = null;
    String input = null;
    String key = null;

    if (args.length != LENGTH) {
      System.err.println("Error: Incorrect number of parameters.");
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
          System.err.println("Error: Input arguments not correct.");
          return;
        } //If statement
      } //If statement
    } //For loop

    if (mode == null) {
      System.err.println("Error: Missing cipher mode (-encode or -decode).");
      return;
    } //If statement
    if (type == null) {
      System.err.println("Error: Missing cipher type (-caesar or -vigenere).");
      return;
    } //If statement
    if (input == null) {
      System.err.println("Error: Missing string for cipher.");
      return;
    } //If statement

    if (key == null || key.equals("")) {
      System.err.println("Error: Missing cipher key.");
      return;
    } //If statement

    for (char ch : input.toCharArray()) {
      if (!Character.isLowerCase(ch)) {
        System.err.println("Error: String for encode/decode aren't all lowercase.");
        return;
      } //If statement
    } //for loop

    for (char ch : key.toCharArray()) {
      if (!Character.isLowerCase(ch)) {
        System.err.println("Error: Key is not all lowercase.");
        return;
      } //If statement
    } //for loop



    String output = null;
    if (type.equals("caesar") && key.length() != 1) {
      System.err.println("Error: Caesar cipher key must be a single letter.");
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
      pen.printf(output);
    } else {
      System.err.println("Error: Your input shouldn't be nothing.");
    } //If statement

    pen.close();

  } //main
} //The whole class
