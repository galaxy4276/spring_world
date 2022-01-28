package spring.community.board.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import spring.community.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "boards")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", length = 50, nullable = false)
  private String title;

  @Column(name = "content", length = 500, nullable = false)
  private String content;

  @Enumerated(EnumType.ORDINAL)
  private BoardType type;

  @Temporal(TemporalType.TIMESTAMP)
  @org.hibernate.annotations.Generated(GenerationTime.INSERT)
  @Column(name = "created_at", updatable = false, insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
  @Column(name = "updated_at", insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at")
  private Date deletedAt;

  @OneToMany(mappedBy = "board")
  List<User> users = new ArrayList<>();

}
