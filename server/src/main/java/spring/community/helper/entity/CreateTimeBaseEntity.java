package spring.community.helper.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@SuperBuilder(setterPrefix = "set")
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CreateTimeBaseEntity {
  @CreatedDate
  @Column(updatable = false)
  protected LocalDateTime createdAt;
}
