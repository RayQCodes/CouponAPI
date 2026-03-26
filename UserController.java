package ECommerce.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;

@RequestMapping("/user")
@RestController
public class UserController {


    //DI
    OnboardingService onboardingService;
    ViewUserService viewUserService;


    @Autowired
    public UserController(ViewUserService viewUserService, OnboardingService onboardingService) {
        this.viewUserService = viewUserService;
        this.onboardingService = onboardingService;
    }

    @PostMapping("/createUser")
    public String creatingUser(@RequestBody UserDTO newUser){
        onboardingService.onboarding(newUser);
        return "user account has been logged ";
    }

    @GetMapping("/viewUser")
    public String viewUserService(){
        return viewUserService.viewUser();
    }
}
