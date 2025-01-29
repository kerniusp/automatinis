package lt.techin.stream;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPraktiniai {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){

        return numbers.stream()
                .map(numb -> (int) Math.sqrt(numb))
                .toList();




    }

    public static List<Integer> getAgeFromUsers(List<User> users){

        return users.stream()
                .map(User::getAge)
                .toList();

    }

    public static List<Integer> getDistinctAges(List<User> users){

        return users.stream()
                .map(User::getAge)
                .distinct()
                .toList();

    }

    public static List<User> getLimitedUserList(List<User> users, int limit){

        return users.stream()
                .limit(limit)
                .toList();
    }

    public static Integer countUsersOlderThen25(List<User> users){


        return (int)users.stream()
                .filter(user -> user.getAge() > 25)
                .count();
    }

    public static List<String> mapToUpperCase(List<String> strings){

        return strings.stream()
                .map(String::toUpperCase)
                .toList();

    }

    public static Integer sum(List<Integer> integers){

        return integers.stream()
                .mapToInt(numb -> numb)
                .sum();

    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){

        return integers.stream().filter(numb -> numb.intValue() > toSkip.intValue()).toList();

    }

    public static List<String> getFirstNames(List<String> names){

        return names;

    }

    public static List<String> getDistinctLetters(List<String> names){
        throw new UnsupportedOperationException("Not implemented");
    }


    public static String separateNamesByComma(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static double getAverageAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer getMaxAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer getMinAge(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean anyMatch(List<User> users, int age){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean noneMatch(List<User> users, int age){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Optional<User> findAny(List<User> users, String name){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<User> sortByAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static User findOldest(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static int sumAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    //Pvz.:
    //Java 8 Streams API: Grouping and Partitioning a Stream
    //https://www.javacodegeeks.com/2015/11/java-8-streams-api-grouping-partitioning-stream.html

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

}
