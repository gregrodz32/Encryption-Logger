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
                    passkey = argument.toUpperCase();
                    System.out.println("RESULT");
                    break;
                case "ENCRYPT":
                    if (passkey == null) {
                        System.out.println("ERROR Password was not set");
                    } else {
                        System.out.println("RESULT " + vCipher(argument.toUpperCase(), passkey, true));
                    }
                    break;
                case "DECRYPT":
                    if (passkey == null) {
                        System.out.println("ERROR Password was not set");
                    } else {
                        System.out.println("RESULT " + vCipher(argument.toUpperCase(), passkey, false));
                    }
                    break;
                case "QUIT":
                    return;
                default:
                    System.out.println("ERROR");
            }
        }
    }

    private static String vCipher(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int keyLength = key.length();
        int keyIndex = 0;

        for (char tChar : text.toCharArray()) {
            if (tChar < 'A' || tChar > 'Z') {
                result.append(tChar);
                continue;
            }

            char kChar = key.charAt(keyIndex % keyLength);
            int shift = kChar - 'A'; 

            if (!encrypt) shift = -shift;

            char newChar = (char) (((tChar - 'A' + shift + 26) % 26) + 'A');
            result.append(newChar);
            keyIndex++;
        }

        return result.toString();
    }
}
