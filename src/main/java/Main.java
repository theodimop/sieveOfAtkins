/**
 * Created by dj_di_000 on 14/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        int N;
        if (args.length < 1) {
            if ((N = Integer.getInteger(args[0], -1)) < 0) {
                printUsage();
            }
        }

        
    }

    private static void printUsage() {
        System.err.println("Usage: program parameter1. \n" +
                "Parameter1 should be a positive integer.");
    }
}
