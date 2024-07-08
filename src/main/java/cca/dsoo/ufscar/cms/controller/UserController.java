package cca.dsoo.ufscar.cms.controller;

import cca.dsoo.ufscar.cms.model.UserModel;
import cca.dsoo.ufscar.cms.view.CreateUserView;
import cca.dsoo.ufscar.cms.view.UpdateUserView;
import cca.dsoo.ufscar.cms.view.ViewUserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@Controller
public class UserController {
    @GetMapping("/user/create")
    public String createUser() {
        System.out.println("Accessing /user/create");
        CreateUserView view = new CreateUserView();
        return view.render(new HashMap<String, Object>());
    }

    @PostMapping("/user/create")
    public String postCreateUser(@RequestParam String name, @RequestParam String useremail, @RequestParam String userpassword) {
        System.out.println("Acessing [POST] /user/create");
        System.out.println(String.format("Data, name: %s | email: %s | password: %s", name, useremail, userpassword));
        ViewUserView view = new ViewUserView();
        return view.render(new HashMap<String, Object>());
    }

    @GetMapping("/user/update")
    public String updateUser() {
        System.out.println("Accessing/user/update");
        UpdateUserView view = new UpdateUserView();
        return view.render(new HashMap<String, Object>());
    }

    @GetMapping("/user/view")
    public String viewUser() {
        System.out.println("Accessing/user/view");
        ViewUserView view = new ViewUserView();
        return view.render(new HashMap<String, Object>());
    }
}
