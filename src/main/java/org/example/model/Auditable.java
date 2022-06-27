package org.example.model;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedBy
    @Column(columnDefinition = "bigint default 1", updatable = false)
    protected Long createdBy;

    @LastModifiedBy
    @Column(columnDefinition = "bigint default 1")
    protected Long updatedAt;
}