package VWS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Validate {
    private final String input;
    public String operand1Input;
    public String operand2Input;
    public ArrayList<String> operatorInput = new ArrayList<>();
    public String [] operators = {"/","+","-","*"};
    public boolean needsToBeRomanOutput;
    public Validate (String input){
        this.input = input;
    }
    public void validateOperator(){
        //ищем операторы, совпадения - в ArrayList
        int count = 0;
        for(String operator:operators){
            for(int i = 0; i < input.length(); i++){
                if(operator.charAt(0)==input.charAt(i)){
                    count++;
                    operatorInput.add(operator);
                }
            }
        }
        //выбрасываем исключение - примеры, где больше одного оператора не подходят
        if(count > 1){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Формат математической операции " +
                        "не удовлетворяет заданию - два операнда и один оператор");
            }
            //если нет искомых операторов - выбрасываем исключение
        }else if(count == 0){
            try{
                throw new Exception();
            } catch (Exception e){
                System.out.println("Строка не является математической " +
                        "операцией");
            }
            //проводим сплит полученного String по значению из ArrayList
            //инициализируем значения за 1-й и 2-й операнд
        }else {

            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i)==operatorInput.get(0).charAt(0)){
                    operand1Input = input.substring(0,i);
                    operand2Input = input.substring(i+1);
                }
            }
        }
    }
    public Integer[] validateOperands(){
        int firstValue = 0;
        int secondValue = 0;
        boolean firstArabic = false;
        boolean secondArabic = false;
        boolean firstRoman = false;
        boolean secondRoman = false;

        //инициализируем копию нашей "базы данных", первый вариант - цифры до 10
        //для валидации инпута
        Database database = new Database();
        HashMap<String, String> map = database.getMap();
        //сканируем нашу мапу на предмет совпадения, при совпадении инициализируем
        //соответствующие значения, парсим сразу в int;
        //параллельно присваиваем соответсвующие значения boolean при совпадении
        for(Map.Entry<String,String> set:map.entrySet()){
            if(operand1Input.equals(set.getValue())){
                firstArabic = true;
                firstValue = Integer.parseInt(set.getValue());
            }
            if(operand2Input.equals(set.getValue())){
                secondArabic = true;
                secondValue = Integer.parseInt(set.getValue());
            }
            if(operand1Input.equals(set.getKey())&&!operand1Input.equals("0")){
                firstRoman = true;
                firstValue = Integer.parseInt(set.getValue());
            }
            if(operand2Input.equals(set.getKey())&&!operand2Input.equals("0")){
                secondRoman = true;
                secondValue = Integer.parseInt(set.getValue());
            }
        }
        //кейс №1 - обе цифры арабские, возвращаем массив String
        if(firstArabic&&secondArabic){
        return new Integer[] {firstValue, secondValue};
        //кейс №2 - обе цифры римские, возвращаем массив String
        //вводится boolean для определения необходимости транскрипции в римские цифры
        }else if(firstRoman&&secondRoman){
            needsToBeRomanOutput = true;
            return new Integer[] {firstValue, secondValue};
        //кейс №3 - разные цифры, выбрасываем исключение
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Используются разные системы исчисления " +
                        "или один из операндов больше 10");
            }
        }
        return null;
    }
}
