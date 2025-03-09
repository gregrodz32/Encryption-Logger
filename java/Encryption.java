import java.util.Scanner;

public class Encryption {
    private static String passkey = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toUpperCase();
            String argument = (parts.length > 1) ? parts[1] : "";

            switch (command) {
                case "PASS":
                    passkey = argument.toUpperCase(); // Store key in uppercase
                    System.out.println("RESULT");
                    break;
                case "ENCRYPT":
                    if (passkey == null) {
                        System.out.println("ERROR Password not set");
                    } else {
                        System.out.println("RESULT " + vigenereCipher(argument.toUpperCase(), passkey, true));
                    }
                    break;
                case "DECRYPT":
                    if (passkey == null) {
                        System.out.println("ERROR Password not set");
                    } else {
                        System.out.println("RESULT " + vigenereCipher(argument.toUpperCase(), passkey, false));
                    }
                    break;
                case "QUIT":
                    return;
                default:
                    System.out.println("ERROR Unknown command");
            }
        }
    }

    private static String vigenereCipher(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int keyLength = key.length();
        int keyIndex = 0; // Tracks which key letter to use

        for (char tChar : text.toCharArray()) {
            if (tChar < 'A' || tChar > 'Z') {
                result.append(tChar); // Preserve spaces and punctuation
                continue;
            }

            char kChar = key.charAt(keyIndex % keyLength);
            int shift = kChar - 'A'; // Convert key letter to shift value

            if (!encrypt) shift = -shift; // Reverse shift for decryption

            char newChar = (char) (((tChar - 'A' + shift + 26) % 26) + 'A');
            result.append(newChar);
            keyIndex++;
        }

        return result.toString();
    }
}
