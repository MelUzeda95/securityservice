package securityservice.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import securityservice.util.constant.ConstantsEntity;


import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {
    @CreatedDate
    @Column(name = ConstantsEntity.AuditTable.CreatedDate.NAME)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = ConstantsEntity.AuditTable.ModifiedDate.NAME)
    private LocalDateTime modifiedDate;
}
