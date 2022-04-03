package VWS;

import java.util.HashMap;
import java.util.Map;

public class ArabicToRoman {
    private final int number;
    public String result;
    public ArabicToRoman(int number){
        this.number = number;
    }
    public void translateToRoman(){
        if(number<0){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Не существует отрицательных римских цифр");
                System.exit(0);
            }
        }
        if(number<=10&&number>=0){
            Database database = new Database();
            HashMap<String, String> map = database.getMap();
            for(Map.Entry<String, String> set: map.entrySet()){
                if(Integer.parseInt(set.getValue())==number){
                    result = set.getKey();
                }
            }
        }
        if(number>10&&number<100){
            Database database = new Database();
            HashMap<String,String> map = database.getMapResult();
            String firstPart = null;
            String secondPart = null;
            int additional = number%10;
            int dozen = number - additional;
            for(Map.Entry<String, String> set: map.entrySet()){
                if(Integer.parseInt(set.getValue())==dozen){
                    firstPart = set.getKey();
                }
                if(Integer.parseInt(set.getValue())==additional){
                    secondPart = set.getKey();
                }
            }
            if(additional!=0) {
                result = firstPart + secondPart;
            } else{
                result = firstPart;
            }
        }
        //нет необходимости продолжать, максимальное возможное значение - 100
        if(number>=100){
            result = "C";
        }
    }
}
