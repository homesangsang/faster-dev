package xyz.homesangsang.sessionbase.modules.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserEntity;
import xyz.homesangsang.sessionbase.modules.sys.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser (UserEntity user) {
        userService.saveUser(user);
        return "login";
    }
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/user")
    public String uesr() {
        return "user";
    }

    @RequestMapping("/header")
    public String header() {
        return "header";
    }

    @RequestMapping("/sys/role")
    public String rolePage() {
        return "modules/sys/role";
    }
}
