package ua.charity.GetHelpUaBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.charity.GetHelpUaBot.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    @Modifying
    @Query(value = "UPDATE Users " +
            "SET username=:username,first_name=:first_name, last_name=:last_name, phone_number=:phone_number, change_dateime=NOW() " +
            "WHERE id=:id",
            nativeQuery = true)
    public void update(String username, String first_name, String last_name, long phone_number, Long id);

}