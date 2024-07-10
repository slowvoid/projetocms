package cca.dsoo.ufscar.cms.controller;

import cca.dsoo.ufscar.cms.view.ViewFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/content/create")
    public String createContent() {
        return "Create content view";
    }

    @GetMapping("/content/view")
    public String viewContent() {
        return "View content view";
    }

    @GetMapping("/content/comment/create")
    public String createCommnet() {
        return "Create comment view";
    }

}
