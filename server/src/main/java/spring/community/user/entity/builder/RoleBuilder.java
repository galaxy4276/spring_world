package spring.community.user.entity.builder;

import spring.community.exception.FaultSetBuilderAttributesException;
import spring.community.user.entity.Role;

import java.util.Objects;
import java.util.stream.Stream;

public class RoleBuilder {
  private final Role role;

  public RoleBuilder() {
    this.role = new Role();
  }

  public RoleBuilder setId(Long id) {
    role.setId(id);
    return this;
  }

  public RoleBuilder setName(String name) {
    role.setName(name);
    return this;
  }

  public Role build() throws FaultSetBuilderAttributesException {
    try {
      if (Stream.of(role.getId(), role.getName()).anyMatch(Objects::isNull))
        throw new FaultSetBuilderAttributesException();
      return role;
    } catch (NullPointerException e) {
      throw new FaultSetBuilderAttributesException();
    }
  }

}
