package ua.goit.homework13;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String URI_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_SITE = "https://jsonplaceholder.typicode.com/";


    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User();
        user.setId(1);
        user.setName("Maks Babenko");
        user.setUserName("Maks");
        user.setEmail("Maks@i.ua");
        user.setAddress("Street", "suite", "Kyiv", "09100", "-37.021", "48.1234");
        user.setPhone("12345-456384651");
        user.setWebsite("hasfidfha");
        user.setCompany("nameCompany", "catchPhrase", "bs");

        User user1 = HttpUtil.createUser(URI.create(URI_USERS), user);

        System.out.println("\n-----Task1-----\n");
        System.out.println(user1);

        System.out.println("\n-----Task2-----\n");
        user1.setName("MAXXXXXXX");
        User user2 = HttpUtil.updateUser(URI.create(URI_USERS), user1);
        System.out.println(user2);

        System.out.println("\n-----Task3-----\n");
        System.out.println(HttpUtil.deleteUser(URI.create(URI_USERS), user2));

        System.out.println("\n-----Task4-----\n");
        System.out.println(HttpUtil.getAllUsers(URI.create(URI_USERS)).toString());

        System.out.println("\n-----Task5-----\n");
        User user5 = HttpUtil.getUserWithId(URI.create(URI_USERS), 1);
        System.out.println(user5);

        System.out.println("\n-----Task6-----\n");
        System.out.println(HttpUtil.getUserWithUsername(URI.create(URI_USERS), "Bret").toString());

        System.out.println("\n-----Task7-----\n");
        HttpUtil.getAllCommentsWithLastPost(URI.create(URI_SITE));

        System.out.println("\n-----Task8-----\n");
        HttpUtil.printAllUserTask(URI.create(URI_USERS));
    }
}
