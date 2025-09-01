package cl;
import config.Settings;

public class Parser {

    public void parse(String[] commandLine, Settings options){
        int i = 0;
        while( i < commandLine.length){
            String arg = commandLine[i];

            switch (arg){
                case "-o":
                    if(i+1 < commandLine.length){
                        if(commandLine[i+1].endsWith("/")){
                            options.setOutputPath(commandLine[i+1]);
                        }else{
                            options.setOutputPath(commandLine[i+1] + "/");
                        }
                    i++;
                    }else{
                        System.err.println("После -o укажите путь");
                    }
                    break;
                case "-p":
                    if(i+1 < commandLine.length) {
                        options.setFilePrefix(commandLine[i+1]);
                        i++;
                    }else{
                        System.err.println("После -p укажите префикс");
                    }
                    break;
                case "-a":
                    options.setAppendMode(true);
                    break;
                case "-s":
                    options.setShortStat(true);
                    break;
                case "-f":
                    options.setFullStat(true);
                    break;
                default:
                    if(!commandLine[i].startsWith("-")){
                        options.addInputFile(commandLine[i]);
                    }else{
                        System.err.println("Неизвестная опция: " + commandLine[i]);
                    }
                    break;
            }
            i++;
        }
    }
}
