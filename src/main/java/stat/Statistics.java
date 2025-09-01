package stat;

import config.Settings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    public void getStat(List<String> strings, List<BigInteger> integers, List<BigDecimal> floats, Settings options){
        if(options.isShortStat()){
            printShortStat(strings, integers,floats);
        }
        if(options.isFullStat()){
            printFullStat(strings,integers,floats);
        }
    }

    public void printShortStat(List<String> strings, List<BigInteger> integers, List<BigDecimal> floats){
        System.out.println("Краткая статистика");
        if(!integers.isEmpty()){
            System.out.println("    Кол-во целых чисел: " + integers.size());
        }
        if(!floats.isEmpty()){
            System.out.println("    Кол-во вещественных чисел: " + floats.size());
        }
        if(!strings.isEmpty()){
            System.out.println("    Кол-во строк: " + strings.size());
        }
    }

    public void printFullStat(List<String> strings, List<BigInteger> integers, List<BigDecimal> floats){
        System.out.println("Полная статистика");
        if(!integers.isEmpty()){
            System.out.println("Целые числа:");
            List<BigInteger> sortedIntegers = new ArrayList<>(integers);
            Collections.sort(sortedIntegers);
            System.out.println("    Минимальное целое число: " + sortedIntegers.get(0));
            System.out.println("    Максимальное целое число: " + sortedIntegers.get(sortedIntegers.size()-1));
            BigInteger sum = new BigInteger("0");
            for (BigInteger bigInt : sortedIntegers) {
                sum = sum.add(bigInt);
            }
            System.out.println("    Сумма целых чисел: " + sum);
            BigDecimal avg = new BigDecimal(sum).divide(new BigDecimal(sortedIntegers.size()+""),5, RoundingMode.HALF_UP);
            System.out.println("    Среднее арифметическое целых чисел: " + avg);
        }
        if(!floats.isEmpty()){
            System.out.println("Вещественные числа:");
            List<BigDecimal> sortedFloats = new ArrayList<>(floats);
            Collections.sort(sortedFloats);
            System.out.println("    Минимальное вещественное число: " + sortedFloats.get(0));
            System.out.println("    Максимальное вещественное число: " + sortedFloats.get(sortedFloats.size()-1));
            BigDecimal sum = new BigDecimal(0);
            for (BigDecimal bigDec : sortedFloats) {
                sum = sum.add(bigDec);
            }
            System.out.println("    Сумма вещественных чисел: " + sum);
            BigDecimal avg = sum.divide(new BigDecimal(sortedFloats.size()+""),5, RoundingMode.HALF_UP);
            System.out.println("    Среднее арифметическое вещественных чисел: " + avg);
        }
        if(!strings.isEmpty()){
            System.out.println("Строки:");
            System.out.println("    Кол-во строк: " + strings.size());
            int min = strings.get(0).length();
            int max = strings.get(0).length();
            for(int i = 1; i < strings.size(); i++){
                min = Math.min(min, strings.get(i).length());
                max = Math.max(max, strings.get(i).length());
            }
            System.out.println("    Минимальная длина строки: " + min);
            System.out.println("    Максимальная длина строки: " + max);
        }
    }
}
