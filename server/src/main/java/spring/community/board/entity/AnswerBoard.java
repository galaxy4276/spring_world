package spring.community.board.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import spring.community.helper.entity.FullTimeBaseEntity;
import spring.community.user.entity.User;

import javax.persistence.*;

@SuperBuilder(setterPrefix = "set")
@Entity
@Getter
@Table(name = "answer_boards")
public class AnswerBoard extends FullTimeBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", length = 500, nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board", referencedColumnName = "id")
  private Board board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

}
