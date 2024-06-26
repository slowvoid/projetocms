package cca.dsoo.ufscar.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/create")
    public String createUser() {
        return "Create user view";
    }

    @GetMapping("/user/update")
    public String updateUser() {
        return "Update user view";
    }

    @GetMapping("/user/view")
    public String viewUser() {
        return "View user view";
    }
}
