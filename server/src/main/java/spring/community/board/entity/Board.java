package spring.community.board.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import spring.community.helper.entity.FullTimeStamp;
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

  @Embedded
  private FullTimeStamp fullTimeStamp;

  @OneToMany(mappedBy = "board")
  List<User> users = new ArrayList<>();

  @OneToMany(mappedBy = "board")
  List<Like> likeList = new ArrayList<>();
}
