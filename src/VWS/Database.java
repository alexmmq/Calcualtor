package VWS;

import java.util.HashMap;

public class Database {
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> mapResult = new HashMap<>();
    public void setMap(HashMap<String, String> map) {
        map.put("0", "0");
        map.put("I","1");
        map.put("II", "2");
        map.put("III", "3");
        map.put("IV", "4");
        map.put("V", "5");
        map.put("VI", "6");
        map.put("VII", "7");
        map.put("VIII", "8");
        map.put("IX", "9");
        map.put("X", "10");
    }

    public void setMapResult(HashMap<String, String> map) {
        this.mapResult = map;
        map.put("XX", "20");
        map.put("XXX", "30");
        map.put("XL", "40");
        map.put("L", "50");
        map.put("LX", "60");
        map.put("LXX", "70");
        map.put("LXXX", "80");
        map.put("XC", "90");
        map.put("C", "100");
        //результат не может быть больше ста
    }

    public HashMap<String, String> getMap() {
        setMap(map);
        return map;
    }

    public HashMap<String, String> getMapResult() {
        setMapResult(getMap());
        return mapResult;
    }
}
