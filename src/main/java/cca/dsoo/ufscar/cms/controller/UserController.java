package cca.dsoo.ufscar.cms.controller;

import cca.dsoo.ufscar.cms.data.DBManager;
import cca.dsoo.ufscar.cms.model.Model;
import cca.dsoo.ufscar.cms.model.UserModel;
import cca.dsoo.ufscar.cms.util.ConfigManager;
import cca.dsoo.ufscar.cms.view.CreateUserView;
import cca.dsoo.ufscar.cms.view.UpdateUserView;
import cca.dsoo.ufscar.cms.view.ViewUserView;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
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
    public String postCreateUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws InvalidObjectException {
        System.out.println("Acessing [POST] /user/create");
        System.out.println(String.format("Data, name: %s | email: %s | password: %s", name, email, password));

        UserModel u = new UserModel();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.create();

        return "redirect:/user/view";
    }

    @GetMapping("/user/update")
    public String updateUser() {
        System.out.println("Accessing/user/update");
        UpdateUserView view = new UpdateUserView();
        return view.render(new HashMap<String, Object>());
    }

    @GetMapping("/user/view")
    public String viewUser(org.springframework.ui.Model model) {
        System.out.println("Accessing/user/view");
        // Procura usuários
        ArrayList<Model> users = (new UserModel()).find();
        HashMap<String, Object> viewData = new HashMap<>();
        viewData.put("users", users);

        model.addAttribute("users", users);
        ViewUserView view = new ViewUserView();
        return view.render(viewData);
    }

    @GetMapping("/user/debug")
    public String debug() throws IOException, ParseException {
        System.out.println("Accessing /user/debug");
        DBManager db = DBManager.getInstance();
        db.execute("SELECT * FROM users");
        return "view-user";
    }
}
