package spring.community.board.entity;

import lombok.*;
import spring.community.user.entity.User;

import javax.persistence.*;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "likes")
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "board", referencedColumnName = "id")
  private Board board;

  @ManyToOne
  @JoinColumn(name = "user", referencedColumnName = "id")
  private User user;
}
