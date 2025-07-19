package filterapp.cli;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessor {
    private final CommandLineParser cliArgs;
    private final DataWriter dataWriter;
    private final Statistics statistics;

    public FileProcessor(CommandLineParser cliArgs) {
        this.cliArgs = cliArgs;
        this.dataWriter = new DataWriter(cliArgs);
        this.statistics = new Statistics();
    }

    public void processFiles() throws IOException {
        for (String filePath : cliArgs.getInputFiles()) {
            processSingleFile(filePath);
        }
    }

    private void processSingleFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            classifyAndProcessLine(line);
        }
    }

    private void classifyAndProcessLine(String line) throws IOException {
        if (DataValidator.isInteger(line)) {
            int number = Integer.parseInt(line);
            statistics.addInteger(number);
            dataWriter.writeInteger(number);
        }
        else if (DataValidator.isFloat(line)) {
            double number = Double.parseDouble(line);
            statistics.addDouble(number);
            dataWriter.writeDouble(number);
        }
        else {
            statistics.addString(line);
            dataWriter.writeString(line);
        }
    }

    public Statistics getStatistics() {
        return statistics;
    }
}