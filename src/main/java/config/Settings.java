package config;

import java.util.ArrayList;
import java.util.List;

public class Settings {

    private List<String> inputFiles = new ArrayList<>();
    private String outputPath = "";
    private String filePrefix = "";
    private boolean fullStat = false;
    private boolean shortStat = false;
    private boolean appendMode = false;

    public List<String> getInputFiles(){
        return new ArrayList<>(inputFiles);
    }
    public void addInputFile(String fileName){
        inputFiles.add(fileName);
    }

    public String getOutputPath(){
        return outputPath;
    }
    public void setOutputPath(String newPath){
        outputPath = newPath;
    }

    public String getFilePrefix(){
        return filePrefix;
    }
    public void setFilePrefix(String newPrefix){
        filePrefix = newPrefix;
    }

    public boolean isAppendMode(){
        return appendMode;
    }
    public void setAppendMode(boolean newAppendMode){
        appendMode = newAppendMode;
    }

    public boolean isShortStat(){
        return shortStat;
    }
    public void setShortStat(boolean newShortStat){
        shortStat = newShortStat;
    }

    public boolean isFullStat(){
        return fullStat;
    }
    public void setFullStat(boolean newFullStat){
        fullStat = newFullStat;
    }
}