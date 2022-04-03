package VWS;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {

        BufferedReader reader = null;
        while(true){
            try{
                System.out.println("Введите 2 операнда и оператор для вычисления:");
                reader =  new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();
                Validate validate = new Validate(input);
                validate.validateOperator();
                System.out.println(new Result(validate.validateOperands(), validate.operatorInput,
                        validate.needsToBeRomanOutput).getResult());
            }catch (Exception e){
                System.exit(0);
            }
        }
    }
}
