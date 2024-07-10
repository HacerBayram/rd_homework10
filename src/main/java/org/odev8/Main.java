package org.odev8;

import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static class GenericClass<T> {
        private T value;

        public GenericClass(T value) {
            this.value = value;
        }

        public void printValue() {
            System.out.println(value);
        }
    }

    public static <T> Optional<T> findElement(T[] array, T element) {
        return Arrays.stream(array)
                .filter(e -> e.equals(element))
                .findFirst();
    }

    public static void main(String[] args) {

        GenericClass<Integer> intInstance = new GenericClass<>(123);
        GenericClass<String> stringInstance = new GenericClass<>("Hello");
        GenericClass<Double> doubleInstance = new GenericClass<>(45.67);

        intInstance.printValue();  // Output: 123
        stringInstance.printValue();  // Output: Hello
        doubleInstance.printValue();  // Output: 45.67


        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"apple", "banana", "cherry"};

        Optional<Integer> intResult = findElement(intArray, 3);
        Optional<Integer> intResultNotFound = findElement(intArray, 6);
        Optional<String> stringResult = findElement(stringArray, "banana");
        Optional<String> stringResultNotFound = findElement(stringArray, "grape");

        System.out.println(intResult.orElse(-1));
        System.out.println(intResultNotFound.orElse(-1));
        System.out.println(stringResult.orElse("Not Found"));
        System.out.println(stringResultNotFound.orElse("Not Found"));
    }
}