package spring.community.helper.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class FullTimeStamp {

  @Temporal(TemporalType.TIMESTAMP)
  @Generated(GenerationTime.INSERT)
  @Column(name = "created_at", updatable = false, insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  @Generated(GenerationTime.ALWAYS)
  @Column(name = "updated_at", insertable = false, nullable = false,
          columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at")
  private Date deletedAt;
}
