public class SorterApp {

    public static void main(String [] args) {
        if(args.length < 2) {
            ErrPrinter.printUsage();
            return;
        }

        String sortType = "";
        boolean asc = true;
        Sorter sorter = new Sorter();

        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--stat":
                    if (i < args.length - 2) {
                        try {
                            int repeats = Integer.parseInt(args[i + 2]);
                            sorter.runStatistics(args[i + 1], repeats);
                        } catch (NumberFormatException ex) {
                            ErrPrinter.printUsage();
                        }
                        return;
                    } else {
                        ErrPrinter.printUsage();
                        return;
                    }
                case "--type":
                    if (i < args.length - 1) {
                        sortType = args[i + 1];
                    } else {
                        ErrPrinter.printUsage();
                        return;
                    }
                    break;
                case "--asc":
                    asc = true;
                    break;
                case "--desc":
                    asc = false;
                    break;
            }
        }

        sorter.runSorting(sortType, asc);
    }

}
