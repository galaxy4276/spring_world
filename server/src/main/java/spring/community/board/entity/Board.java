package spring.community.board.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.FullTimeBaseEntity;
import spring.community.user.entity.User;

import javax.persistence.*;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "boards")
public class Board extends FullTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", length = 50, nullable = false)
  private String title;

  @Column(name = "content", length = 500, nullable = false)
  private String content;

  @Enumerated(EnumType.ORDINAL)
  private BoardType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

}
