package spring.community.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import spring.community.board.entity.Board;
import spring.community.board.entity.Comment;
import spring.community.board.entity.Like;
import spring.community.user.dto.UserDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 12, nullable = false, unique = true)
  private String name;

  @Column(name = "password", length = 64, nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Temporal(TemporalType.TIMESTAMP)
  @Generated(GenerationTime.INSERT)
  @Column(name = "created_at", updatable = false, insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  @Generated(GenerationTime.ALWAYS)
  @Column(name = "updated_at", insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at")
  private Date deletedAt;

  public User() {
  }

  public UserDto toUserDto() {
    return UserDto.builder()
            .id(id)
            .name(name)
            .email(email)
            .password(password)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .deletedAt(deletedAt)
            .build();
  }

  @OneToMany(mappedBy = "user")
  private List<UserRole> userRoleList = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Like> likeList = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Comment> commentList = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "forgotPasswordService", referencedColumnName = "id")
  private ForgotPasswordService forgotPasswordService;

  @ManyToOne
  @JoinColumn(name = "forgotPasswordServiceLog", referencedColumnName = "id")
  private ForgotPasswordServiceLog forgotPasswordServiceLog;

  @ManyToOne
  @JoinColumn(name = "board", referencedColumnName = "id")
  private Board board;

}

