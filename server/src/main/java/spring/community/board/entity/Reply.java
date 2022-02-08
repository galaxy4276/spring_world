package spring.community.board.entity;

import spring.community.helper.entity.FullTimeStamp;
import spring.community.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "replies")
public class Reply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String content;

  @Embedded
  private FullTimeStamp fullTimeStamp;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "board", referencedColumnName = "id")
  private Board board;

}
