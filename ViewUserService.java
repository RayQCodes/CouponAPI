package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewUserService {

    //Inject repo
    UserRepositoryLayer newRepo;

    public ViewUserService(UserRepositoryLayer newRepo) {
        this.newRepo = newRepo;
    }

    public String viewUser() {
        List<UserDTO> users = newRepo.findAll();
        String result = "";

        for (UserDTO user : users) {
            result += "Email: " + user.getEmail() + "\n";
            result += "Username: " + user.getUsername() + "\n";
        }
        return result;
    }
}
