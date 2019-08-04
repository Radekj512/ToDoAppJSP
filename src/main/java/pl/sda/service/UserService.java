package pl.sda.service;

import pl.sda.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private static List<User> users = loadMockData();

    public static User findUser(String login){
        System.out.println(users);
        Optional<User> user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }
    public static void addUser(User user){
        users.add(user);
    }


    private static List<User> loadMockData() {
        List<User> users = new ArrayList<>();
        User u = User.builder()
                .login("kowalski")
                .password("kowalski").build();
        users.add(u);
        return users;
    }

}
