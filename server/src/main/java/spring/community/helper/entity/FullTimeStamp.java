package spring.community.helper.entity;

import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Setter
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

  public Date getCreatedAt() { return createdAt; }
  public Date getUpdatedAt() { return updatedAt; }
  public Date getDeletedAt() { return deletedAt; }

}
