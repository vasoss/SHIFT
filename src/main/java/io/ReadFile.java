package io;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReadFile {
    public List<String> readFiles(List<String> filePaths){

        List<String> resultLines = new ArrayList<>();
        List<Scanner> fileScanners = new ArrayList<>();

        if (filePaths.isEmpty()){
            System.err.println("Список файлов не может быть пустым, продолжить работу невозможно");
            System.exit(1);
        }

        try{
            for(String inputFilePath : filePaths) {
                if(isValidFile(inputFilePath)){
                    fileScanners.add(new Scanner(new File(inputFilePath)));
                }
            }

            for(Scanner currentFileScanner : fileScanners){
                    while(currentFileScanner.hasNextLine()){
                        resultLines.add(currentFileScanner.nextLine());
                    }
                    currentFileScanner.close();
            }

        }catch (IOException e){
            closeScanners(fileScanners);
            System.err.println("Ошибка при чтении файлов");
        }
        return resultLines;
    }

    private boolean isValidFile(String filePath){
        File currentFile = new File(filePath);

        if(!currentFile.exists()){
            System.err.println("Файл '" + filePath + "' не существует");
            return false;
        }
        if(!currentFile.isFile()){
            System.err.println(filePath + " - не является файлом");
            return false;
        }
        if(!currentFile.canRead()){
            System.err.println("Нет прав на чтение файла - " + filePath);
            return false;
        }
        return true;
    }

    private void closeScanners(List<Scanner> openedScanners){
        for(Scanner openedScanner : openedScanners){
            try{
                if (openedScanner != null){
                    openedScanner.close();
                }
            } catch(Exception ignored){}
        }
    }
}
