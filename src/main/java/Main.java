import cl.Parser;
import config.Settings;
import filter.DataFilter;
import io.ReadFile;
import io.WriteFile;
import stat.Statistics;

public class Main {
    public static void main(String[] args) {

        Settings options = new Settings();
        Parser parser = new Parser();
        parser.parse(args, options);

        ReadFile readFile = new ReadFile();
        DataFilter filter = new DataFilter();
        filter.filter(readFile.readFiles(options.getInputFiles()));

        WriteFile writeFile = new WriteFile();
        writeFile.writeToPath(filter.getResultStrings(),filter.getResultInts(),filter.getResultFloats(),options);

        Statistics statistics = new Statistics();
        statistics.getStat(filter.getResultStrings(),filter.getResultInts(),filter.getResultFloats(),options);
    }
}
