package filterapp.cli;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class DataWriter {
    private final String outputPath;
    private final String prefix;
    private final boolean appendMode;

    public DataWriter(CommandLineParser args) {
        this.outputPath = args.getOutputPath();
        this.prefix = args.getPrefix();
        this.appendMode = args.isAppendMode();
    }

    private void writeToFile(Object data, String fileName) throws IOException {
        Path filePath = Paths.get(outputPath, prefix + fileName);
        Files.createDirectories(filePath.getParent());

        OpenOption mode = appendMode ? StandardOpenOption.APPEND :
                StandardOpenOption.TRUNCATE_EXISTING;

        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardOpenOption.CREATE,
                mode
        )) {
            writer.write(data.toString());
            writer.newLine();
        }
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
}