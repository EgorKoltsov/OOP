package Logger;

// A class for logging user actions
public abstract class Logger {
    // Class constructor method - "screen"|"file". file name - log file name
    public Logger(String method, String fileName) {}

    public abstract void log(String message);
}