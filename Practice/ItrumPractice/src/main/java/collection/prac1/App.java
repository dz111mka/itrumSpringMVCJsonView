package collection.prac1;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 6, 4, 1, -5};
        Filter<Integer> filter = (x) -> x * 2;
        Integer[] result = App.filter(a, filter);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static <T> T[] filter(T[] array, Filter<T> filterImplements) {
        T[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = filterImplements.apply(result[i]);
        }
        return result;
    }
}

interface Filter<T> {
    T apply(T t);
}
