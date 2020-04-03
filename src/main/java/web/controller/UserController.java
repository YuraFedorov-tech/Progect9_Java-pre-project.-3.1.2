package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.config.model.User;
import web.service.UserService;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class UserController {
    final private
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }




    @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {
        modelMap.addAttribute("user",  authentication.getPrincipal());
        return "seeUser";
    }

    @PostMapping(value = "admin/add")
    public String addUser(User user, @RequestParam(required = false, name = "ids") Long id) {
        userService.add(user, id);
        return "redirect:/admin/admin";
    }

    @GetMapping(value = "admin/admin")
    public String getAdminPanel(ModelMap modelMap, Authentication authentication) {
        modelMap.addAttribute("user",  authentication.getPrincipal());
        modelMap.addAttribute("users", userService.findAll());
        return "crud";
    }

    @PostMapping(value = "admin/update")
    public String postUpdateUser(User user,@RequestParam(required = false, name = "RoleUpdateID")Long [] ids){
        userService.update(user, ids);
        return "redirect:/admin/admin";
    }

    @PostMapping(value = "admin/delete")
    public String deleteUser(@RequestParam(required = false, name = "idDelete") Long id) {
        userService.delete(userService.findById(id));
        return "redirect:/admin/admin";
    }
}