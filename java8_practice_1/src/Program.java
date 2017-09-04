import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public final static int NUMBERS_IN_LIST = 10;
    public final static int MAX_NUMBER_IN_LIST = 100;

    public static void main(String[] args) {
        List<Integer> numbers = getRandomNumbers();
        System.out.println("Our random list: " + numbers);

        System.out.println("Average: " + getAverage(numbers));
        System.out.println("Max number: " + getMaxNumber(numbers));
        System.out.println("Sum: " + getSum(numbers));
        System.out.println("Count number of values that are bigger than average: " + getCountOfValuesWhichBiggerThanAverage(numbers));
    }

    public static double getAverage(List<Integer> list) {
        return list.stream().mapToDouble(e -> e).average().getAsDouble();
    }

    public static int getMaxNumber(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get();
    }

    public static int getSum(List<Integer> list) {
        return list.stream().mapToInt(e -> e).sum();
    }

    public static int getSumWithReduce(List<Integer> list) {
        return list.stream().reduce(0, (x,y) -> x*y);
    }

    public static long getCountOfValuesWhichBiggerThanAverage(List<Integer> list) {
        double average = getAverage(list);
        return list.stream().filter(e -> e > average).count();
    }

    public static List<Integer> getRandomNumbers() {
        List<Integer> result = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < NUMBERS_IN_LIST; i++) {
            result.add(random.nextInt(MAX_NUMBER_IN_LIST));
        }
        return result;
    }
}