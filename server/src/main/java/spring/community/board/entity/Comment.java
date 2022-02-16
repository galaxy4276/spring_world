package spring.community.board.entity;

import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.FullTimeBaseEntity;
import spring.community.user.entity.User;

import javax.persistence.*;

@SuperBuilder(setterPrefix = "set")
@Entity
@Table(name = "comments")
public class Comment extends FullTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String content;

  @ManyToOne
  @JoinColumn(name = "board")
  private Board board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user")
  private User user;

}
