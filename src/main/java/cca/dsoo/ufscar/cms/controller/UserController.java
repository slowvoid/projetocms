package cca.dsoo.ufscar.cms.controller;

import cca.dsoo.ufscar.cms.data.DBManager;
import cca.dsoo.ufscar.cms.model.Model;
import cca.dsoo.ufscar.cms.model.UserModel;
import cca.dsoo.ufscar.cms.util.ConfigManager;
import cca.dsoo.ufscar.cms.util.Logger;
import cca.dsoo.ufscar.cms.view.*;
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
        Logger.getInstance().log("Acessando /user/create");
        IView view = ViewFactory.createCreateUserView();
//        CreateUserView view = new CreateUserView();
        return view.render(new HashMap<String, Object>());
    }

    @PostMapping("/user/create")
    public String postCreateUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws InvalidObjectException {
        Logger logger = Logger.getInstance();
        logger.log("Acessando [POST] /user/create");
        logger.log(String.format("Data, name: %s | email: %s | password: %s", name, email, password));

        UserModel u = new UserModel();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.create();

        return "redirect:/user/view";
    }

    @GetMapping("/user/update")
    public String updateUser() {
        Logger.getInstance().log("Acessando /user/update");
        IView view = ViewFactory.createUpdateUserView();
        return view.render(new HashMap<String, Object>());
    }

    @GetMapping("/user/view")
    public String viewUser(org.springframework.ui.Model model) {
        Logger.getInstance().log("Acessando /user/view");
        // Procura usuários
        ArrayList<Model> users = (new UserModel()).find();
        HashMap<String, Object> viewData = new HashMap<>();
        viewData.put("users", users);

        model.addAttribute("users", users);
        IView view = ViewFactory.createViewUserView();
        return view.render(viewData);
    }
}
