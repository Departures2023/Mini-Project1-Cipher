package edu.grinnell.csc207.util;

/**
 * Provides methods for Caesar and Vigenere encryption and decryption.
 */
public class CipherUtils {

  /**
   * number of letters from a to z.
   */
  private static final int SIZE = 26;

  /**
   * Field Declaration.
   */
  private static final int BASE = (int) 'a';

  private static int letter2int(char letter) {
    return (int) letter - BASE;
  } //letter2int

  private static char int2letter(int i) {
    return (char) ((i + SIZE) % SIZE + BASE);
  } //int2letter

  private static int modAdjust(int num, int key) {
    return (num % key + key) % key;  // Ensures positive results
  } //modAdjust

  /**
   * @param str
   * @param letter
   * @return the encoded string with the key "letter" in caesarEncrypt
   */
  public static String caesarEncrypt(String str, char letter) {
    int len = str.length();
    int key = letter2int(letter);

    char[] encryptStr = str.toCharArray();
    for (int i = 0; i < len; i++) {
      encryptStr[i] = int2letter(modAdjust(letter2int(encryptStr[i]) + key, SIZE));
    } //for loop
    return new String(encryptStr);
  } //caesarEncrypt

  /**
   * @param str
   * @param letter
   * @return the decoded string with the key "letter" in caesarEncrypt
   */
  public static String caesarDecrypt(String str, char letter) {
    int len = str.length();
    int key = letter2int(letter);

    char[] decryptStr = str.toCharArray();
    for (int i = 0; i < len; i++) {
      decryptStr[i] = int2letter(modAdjust(letter2int(decryptStr[i]) - key, SIZE));
    } //for loop
    return new String(decryptStr);
  } //caesarDecrypt

  /**
   * @param str
   * @param key
   * @return the encoded string with the key "letter" in vigenereDecrypt
   */
  public static String vigenereEncrypt(String str, String key) {
    int strLen = str.length();
    int keyLen = key.length();
    char[] encryptStr = str.toCharArray();

    for (int i = 0; i < strLen; i++) {
      encryptStr[i] = int2letter(modAdjust(letter2int(encryptStr[i])
        + letter2int(key.charAt(i % keyLen)), SIZE));
    } //for loop
    return new String(encryptStr);
  } //vigenereEncrypt

  /**
   * @param str
   * @param key
   * @return the decoded string with the key "letter" in vigenereDecrypt
   */
  public static String vigenereDecrypt(String str, String key) {
    int strLen = str.length();
    int keyLen = key.length();
    char[] decryptStr = str.toCharArray();

    for (int i = 0; i < strLen; i++) {
      decryptStr[i] = int2letter(modAdjust(letter2int(decryptStr[i])
        - letter2int(key.charAt(i % keyLen)), SIZE));
    } //for loop
    return new String(decryptStr);
  } //vigenereDecrypt
} //whole class
