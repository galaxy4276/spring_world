package spring.community.authentication.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenerateAuthKeyServiceImpl implements GenerateAuthKeyService {

  @Override
  public String GenerateSignupToken() {
    return UUID.randomUUID().toString();
  }

}
