package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

@Service

public class OnboardingService {

    //Inject UserRepo
    UserRepositoryLayer newUserREPO;

    public OnboardingService( UserRepositoryLayer newUserREPO) {
        this.newUserREPO = newUserREPO;
    }

    public String onboarding(UserDTO newUser){
        newUserREPO.save(newUser);
        return "user saved";
    }

}
