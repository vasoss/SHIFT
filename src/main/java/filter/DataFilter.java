package filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DataFilter {

    private List<BigInteger> resultInts = new ArrayList<>();
    private List<String> resultStrings = new ArrayList<>();
    private List<BigDecimal> resultFloats = new ArrayList<>();

    public void filter(List<String> rawLines){
        int k = 0;
        while (k < rawLines.size()) {
            String s = rawLines.get(k++).trim();
            try{
                resultInts.add(new BigInteger(s));
            } catch (Exception e) {
                try{
                    resultFloats.add(new BigDecimal(s));
                }catch (Exception a){
                    resultStrings.add(s);
                }
            }
        }
    }

    public List<BigInteger> getResultInts(){
        return resultInts;
    }
    public List<String> getResultStrings() {
        return resultStrings;
    }
    public List<BigDecimal> getResultFloats() {
        return resultFloats;
    }
}