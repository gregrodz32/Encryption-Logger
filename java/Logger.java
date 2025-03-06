import java.io.FileWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Logger { 
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("java logger <log file>");
            return;
        }
        String logFile = args[0];

        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true)))
            Scanner scanner = new scanner(System.in)) {



            }
    }
}