package spring.community.board.entity;

import lombok.*;
import spring.community.helper.entity.FullTimeStamp;
import spring.community.user.entity.User;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "answer_boards")
public class AnswerBoard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", length = 500, nullable = false)
  private String content;

  @Embedded
  private FullTimeStamp fullTimeStamp;

  @ManyToOne
  @JoinColumn(name = "board", referencedColumnName = "id")
  private Board board;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;
}