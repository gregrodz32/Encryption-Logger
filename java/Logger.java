import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logger {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Logger <logfile>");
            return;
        }

        String logFile = args[0];

        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true));
             Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("QUIT")) break;

                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
                logWriter.println(timestamp + " " + input);
                logWriter.flush();
            }

        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
