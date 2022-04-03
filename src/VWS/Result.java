package VWS;

import java.util.ArrayList;

public class Result {
    private final int operand1;
    private final int operand2;
    private final ArrayList <String> operator;
    private final boolean needsToBeRomanOutput;
    public Result(Integer[] operands, ArrayList<String> operator, boolean needsToBeRomanOutput){
        this.operand1 = operands[0];
        this.operand2 = operands[1];
        this.operator = operator;
        this.needsToBeRomanOutput = needsToBeRomanOutput;
    }
    //в результате работы метода должен вернуться String

    public String getResult() {
        int intermediateResult = 0;
        if(operator.get(0).charAt(0)=='+'){
            intermediateResult = operand1 + operand2;
        }
        else if(operator.get(0).charAt(0)=='-'){
            intermediateResult = operand1 - operand2;
        }
        else if(operator.get(0).charAt(0)=='*'){
            intermediateResult = operand1 * operand2;
        }
        else if(operator.get(0).charAt(0)=='/'&&operand2!=0){
            intermediateResult = operand1/operand2;
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("На ноль делить нельзя");
                System.exit(0);
            }
        }
        //определяем необходимость транскрипции аутпута в римские цифры
        if(!needsToBeRomanOutput){
            return String.valueOf(intermediateResult);
        }
        else {
            ArabicToRoman roman = new ArabicToRoman(intermediateResult);
            roman.translateToRoman();
            return roman.result;
        }
        }
}
