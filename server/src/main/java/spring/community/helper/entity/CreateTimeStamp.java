package spring.community.helper.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class CreateTimeStamp {
  @Temporal(TemporalType.TIMESTAMP)
  @Generated(GenerationTime.INSERT)
  @Column(name = "created_at", updatable = false, insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;
}
