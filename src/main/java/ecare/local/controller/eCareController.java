package ecare.local.controller;

import ecare.local.model.User;
import ecare.local.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class eCareController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() { return "index"; }

    @GetMapping("/error")
    public ResponseEntity<String> no_such_page() {
        return ResponseEntity.ok("No such page");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello admin");
    }

    @GetMapping("/manager")
    public ResponseEntity<String> getManager() {
        return ResponseEntity.ok("Hello manager");
    }

    @GetMapping("/customer")
    public ResponseEntity<String> getCustomer() {
        return ResponseEntity.ok("Hello customer");
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser() { return ResponseEntity.ok("Hello User"); }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
}
