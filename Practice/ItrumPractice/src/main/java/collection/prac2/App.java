package collection.prac2;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Object[] array = new Object[]{1, 2, 3 ,5, -1 ,1 ,1};
        System.out.println(App.arrayToMapMethod(array));

    }

    public static Map<Object, Integer> arrayToMapMethod(Object[] array) {
        Map<Object, Integer> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!result.containsKey(array[i])) {
                result.put(array[i], 1);
            } else {
                result.put(array[i], result.get(array[i]) + 1);
            }
        }
        return result;
    }
}
