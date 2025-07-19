package filterapp.cli;


public class Main {
    public static void main(String[] args) {
        try {
            CommandLineParser cliArgs = new CommandLineParser(args);
            FileProcessor processor = new FileProcessor(cliArgs);

            processor.processFiles();

            if (cliArgs.isFullStats()) {
                processor.getStatistics().printFullStats();
            } else if (cliArgs.isStats()) {
                processor.getStatistics().printShortStats();
            }

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}