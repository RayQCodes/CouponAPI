package ECommerce.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryLayer extends JpaRepository<UserDTO, Long> {
}


