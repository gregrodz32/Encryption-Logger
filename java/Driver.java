import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Driver <logfile>");
            return;
        }

        String logFile = args[0];
        List<String> history = new ArrayList<>();

        try {
            // Start logger and encryption as child processes
            Process logger = new ProcessBuilder("java", "Logger", logFile).start();
            Process encryption = new ProcessBuilder("java", "Encryption").start();

            // Set up pipes
            PrintWriter toLogger = new PrintWriter(new OutputStreamWriter(logger.getOutputStream()), true);
            PrintWriter toEncryption = new PrintWriter(new OutputStreamWriter(encryption.getOutputStream()), true);
            BufferedReader fromEncryption = new BufferedReader(new InputStreamReader(encryption.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Driver started. Enter commands: password, encrypt, decrypt, history, quit.");

            // Log the start of the driver
            toLogger.println("START - Driver started.");
            toLogger.flush();

            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine().trim().toLowerCase();

                if (command.equals("password")) {
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine().toUpperCase();
                    toEncryption.println("PASS " + password);
                    toEncryption.flush();
                    String response = fromEncryption.readLine();
                    toLogger.println("password command executed.");
                    toLogger.flush();
                    System.out.println(response);

                } else if (command.equals("encrypt")) {
                    System.out.print("Enter text to encrypt: ");
                    String text = scanner.nextLine().toUpperCase();
                    history.add(text);
                    toEncryption.println("ENCRYPT " + text);
                    toEncryption.flush();
                    String response = fromEncryption.readLine();
                    System.out.println(response);
                    toLogger.println("encrypt " + text);
                    toLogger.flush();
                    history.add(response.substring(7)); // Store the result of encryption

                } else if (command.equals("decrypt")) {
                    System.out.print("Enter text to decrypt: ");
                    String text = scanner.nextLine().toUpperCase();
                    history.add(text);
                    toEncryption.println("DECRYPT " + text);
                    toEncryption.flush();
                    String response = fromEncryption.readLine();
                    System.out.println(response);
                    toLogger.println("decrypt " + text);
                    toLogger.flush();
                    history.add(response.substring(7)); // Store the result of the encryption
                } else if (command.equals("history")) {
                    System.out.println("History:");
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + ". " + history.get(i));
                    }

                } else if (command.equals("quit")) {
                    toLogger.println("EXIT Driver shutting down."); // Store the shut down of the driver
                    toLogger.flush();
                    toEncryption.println("QUIT");
                    toEncryption.flush();
                    toLogger.println("QUIT");
                    toLogger.flush();
                    break;

                } else {
                    System.out.println("Invalid");
                }
            }

            scanner.close();
            logger.waitFor();
            encryption.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
