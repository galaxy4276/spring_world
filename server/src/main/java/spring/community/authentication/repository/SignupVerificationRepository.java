package spring.community.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.community.authentication.entity.SignupVerification;

@Repository
public interface SignupVerificationRepository extends JpaRepository<SignupVerification, Long> {

  public SignupVerification findByToken(String token);

  public SignupVerification findByEmail(String email);

}
