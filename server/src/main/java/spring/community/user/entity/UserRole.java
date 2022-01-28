package spring.community.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user_roles")
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "role", referencedColumnName = "id")
  private Role role;
}
