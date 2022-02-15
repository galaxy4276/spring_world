package spring.community.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.community.authentication.entity.SignupVerification;

import java.util.Optional;

@Repository
public interface SignupVerificationRepository extends JpaRepository<SignupVerification, Long> {

  public Optional<SignupVerification> findByToken(String token);

  @Query("select sv from SignupVerification sv where sv.user.id = ?1")
  public Optional<SignupVerification> findByUserId(Long userId);

  @Query("select sv from SignupVerification sv join sv.user u where u.email = ?1")
  public Optional<SignupVerification> findByUserEmail(String email);

}
