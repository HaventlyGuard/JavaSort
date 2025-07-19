package filterapp.cli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataWriter {
    private final String outputPath;
    private final String prefix;
    private final boolean appendMode;
    private final Map<String, List<String>> dataCache = new HashMap<>();

    public DataWriter(CommandLineParser cliArgs) {
        this.outputPath = cliArgs.getOutputPath();
        this.prefix = cliArgs.getPrefix();
        this.appendMode = cliArgs.isAppendMode();
    }

    public void writeInteger(int number) throws IOException {
        writeToFile(number, "integers.txt");
    }

    public void writeDouble(double number) throws IOException {
        writeToFile(number, "floats.txt");
    }

    public void writeString(String text) throws IOException {
        writeToFile(text, "strings.txt");
    }

    private void writeToFile(Object data, String fileName) throws IOException {
        if (appendMode) {

            Path filePath = Paths.get(outputPath, prefix + fileName);
            Files.createDirectories(filePath.getParent());

            Files.writeString(
                    filePath,
                    data.toString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } else {

            dataCache.computeIfAbsent(fileName, k -> new ArrayList<>())
                    .add(data.toString());
        }
    }

    public void flushAll() throws IOException {
        if (appendMode) {
            return;
        }

        for (Map.Entry<String, List<String>> entry : dataCache.entrySet()) {
            Path filePath = Paths.get(outputPath, prefix + entry.getKey());
            Files.createDirectories(filePath.getParent());

            // Записываем все данные одним вызовом
            Files.write(
                    filePath,
                    entry.getValue(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );
        }
        dataCache.clear();
    }
}