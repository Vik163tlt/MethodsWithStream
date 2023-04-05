import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Иван", 24);
        User user2 = new User("Дмитрий", 32);
        User user3 = new User("Иван", 24);
        User user4 = new User("Александр", 19);
        User user5 = new User("Александр", 19);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        List<User> deDuplicates = users.stream().distinct().collect(Collectors.toList());
        System.out.println(deDuplicates);

        Comparator<User> byName = Comparator.comparing(User::getName);
        Comparator<User> byAge = Comparator.comparing(User::getAge);
        Collections.sort(users, byName.thenComparing(byAge));
        System.out.println(users);

        List<User> oldies = users.stream().max(byAge).stream().collect(Collectors.toList());
        System.out.println(oldies);
    }
}