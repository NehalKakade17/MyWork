package assign.pending;
import java.util.*;
public class LogSingleton {
	    private static LogSingleton instance;
	    private String logMsg;
	    private LogSingleton() {
	        logMsg = "";
	    }
	    public static LogSingleton getInstance() {
	        if (instance == null) {
	            instance = new LogSingleton();
	        }
	        return instance;
	    }
	    public void log(String msg) {
	        if (msg != null && !msg.trim().isEmpty()) {
	            if (!logMsg.isEmpty()) {
	                logMsg += System.lineSeparator(); 
	            }
	            logMsg += msg;
	        }
	    }
	    public String getLog() {
	        return logMsg;
	    }
	    public void clearLog() {
	        logMsg = "";
	    }
	    public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	        LogSingleton logger = LogSingleton.getInstance();
	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("1. Log a message");
	            System.out.println("2. Display log");
	            System.out.println("3. Clear log");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter message to log: ");
	                    String message = scanner.nextLine();
	                    logger.log(message);
	                    break;
	                case 2:
	                    System.out.println("Current Log:");
	                    System.out.println(logger.getLog());
	                    break;
	                case 3:
	                    logger.clearLog();
	                    System.out.println("Log cleared.");
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
	                    break;
	            }
	        }
	    }
	}



