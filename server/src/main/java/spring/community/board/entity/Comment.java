package spring.community.board.entity;

import spring.community.helper.entity.FullTimeStamp;
import spring.community.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String content;

  @Embedded
  private FullTimeStamp fullTimeStamp;

  @ManyToOne
  @JoinColumn(name = "board")
  private Board board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user")
  private User user;

}
