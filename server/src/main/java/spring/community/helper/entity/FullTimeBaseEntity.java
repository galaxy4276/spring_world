package spring.community.helper.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@SuperBuilder()
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class FullTimeBaseEntity {

  @CreatedDate
  @Column(updatable = false)
  protected LocalDateTime createdAt;

  @LastModifiedDate
  protected LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  protected LocalDateTime deletedAt;

}
