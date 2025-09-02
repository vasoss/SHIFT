package cl;
import config.Settings;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    public void parse(String[] commandLine, Settings options){
        int i = 0;
        while( i < commandLine.length){
            String arg = commandLine[i];

            switch (arg){
                case "-o":
                    if(i+1 < commandLine.length){
                        String path = commandLine[i + 1];
                        Path outputDir = Paths.get(path).toAbsolutePath();
                        if (!Files.exists(outputDir)) {
                            System.err.println("Директория '"+ outputDir +"' не существует");
                            System.err.println("Файлы будут записаны в текущую папку");
                        } else {
                            options.setOutputPath(outputDir + File.separator);
                        }
                        i++;
                    }else{
                        System.err.println("После опции '-o' не указан путь, файлы будут записаны в текущую папку");
                    }
                    break;
                case "-p":
                    if(i+1 < commandLine.length) {
                        options.setFilePrefix(commandLine[i+1]);
                        i++;
                    }else{
                        System.err.println("После опции '-p' не указан префикс, файлы будут названы по умолчанию");
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
