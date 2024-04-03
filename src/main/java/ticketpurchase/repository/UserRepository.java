package ticketpurchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ticketpurchase.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String USER_QUERY = "from User where seatAllocation=:section";

    @Query(value = USER_QUERY)
    List<User> getUserBySection(@Param("section") String section);

}
