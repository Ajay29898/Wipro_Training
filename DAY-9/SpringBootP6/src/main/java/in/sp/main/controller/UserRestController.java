package in.sp.main.controller;

import in.sp.main.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/myuser")
public class UserRestController {

    @PostMapping("/user")
    public String saveUser(@RequestBody User u) {
        System.out.println(u);
        return "User is saved";
    }

    @GetMapping("/user/{uid}")
    public User getUser(@PathVariable Integer uid) {
        User u = new User(100, "John Doe", "john@example.com", "1234567890");
        return u;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        User u1 = new User(100, "John Doe", "john@example.com", "1234567890");
        User u2 = new User(101, "Jane Doe", "jane@example.com", "0987654321");
        return Arrays.asList(u1, u2);
    }
}

