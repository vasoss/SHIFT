package io;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import config.Settings;

public class WriteFile {

    public void writeToPath(List<String> strings, List<BigInteger> integers, List<BigDecimal> floats, Settings options) {
        if(!strings.isEmpty()){
            writeToFile(strings, "strings.txt", options);
        }
        if(!integers.isEmpty()){
            writeToFile(integers, "integers.txt", options);
        }
        if(!floats.isEmpty()){
            writeToFile(floats, "floats.txt", options);
        }
    }

    public void writeToFile(List<?> data, String fileName, Settings options){
        try(FileWriter writer = new FileWriter(options.getOutputPath() + options.getFilePrefix() + fileName, options.isAppendMode())){
            for(Object line : data){
                writer.write(line+"\n");
            }
        }catch(IOException e){
            System.err.println("Ошибка записи " + fileName);
        }
    }
}