public class ErrPrinter {
    public static void printCompare(String x, String y) {
        System.err.println("Compare: " + x + " with " + y);
    }

    public static void printCompare(int x, int y) {
        System.err.println("Compare: " + x + " with " + y);
    }

    public static void printCompare(int x, int y, String additionalInfo) {
        System.err.println("Compare: " + x + " with " + y + " (" + additionalInfo + ")");
    }

    public static void printSwap(int x, int y) {
        System.err.println("Swap: " + x + " <=> " + y);
    }

    public static void printSwap(int x, int y, String additionalInfo) {
        System.err.println("Swap: " + x + " <=> " + y + " (" + additionalInfo + ")");
    }

    public static void printCompareCount(int compareCounter) {
        System.err.println("Total number of compares: " + compareCounter);
    }

    public static void printSwapCount(int swapCounter) {
        System.err.println("Total number of swaps: " + swapCounter);
    }

    public static void printTotalTime(long elapsedTime) {
        System.err.println("Total time: " + elapsedTime/1000000 + " ms");
    }

    static void printUsage() {
        System.out.println("Usage: ");
        System.out.println("SorterApp --type select|insert|heap|quick|mquick --asc|--desc");
        System.out.println("SorterApp --stat file_name number_of_repeats");
    }
}
