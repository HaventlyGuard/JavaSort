package filterapp.cli;
import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {
    private String outputPath = "./output";
    private List<String> inputFiles = new ArrayList<>();
    private String prefix = "";
    private boolean appendMode =false;
    private boolean stats =false;
    private boolean fullStats = false;

    public  CommandLineParser(String[] args){
        for(int i=0; i< args.length; i++){
            switch (args[i]){
                case "-o":
                    outputPath = args[++i];
                    break;
                case "-p":
                    prefix = args[++i];
                    break;
                case "-f":
                    fullStats = true;
                    break;
                case "-s":
                    stats = true;
                    break;
                case "-a":
                    appendMode=true;
                    break;
                default:
                    inputFiles.add(args[i]);

            }
        }
    }

}
