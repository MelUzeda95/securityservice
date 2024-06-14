package securityservice.model.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import securityservice.util.constant.ConstantsEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = ConstantsEntity.RoleTable.NAME)
public class RoleEntity extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ConstantsEntity.RoleTable.Id.NAME, nullable = false)
    private Integer id;

    @Column(name = ConstantsEntity.RoleTable.Name.NAME, length = ConstantsEntity.RoleTable.Name.LENGTH, nullable = false)
    private String name;

    @Column(name = ConstantsEntity.RoleTable.Description.NAME, length = ConstantsEntity.RoleTable.Description.LENGTH)
    private String description;

    @OneToMany(mappedBy = ConstantsEntity.RoleTable.NAME, fetch = FetchType.LAZY, targetEntity = UserEntity.class)
    private List<UserEntity> users;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = ConstantsEntity.RoleTable.IsDeleted.NAME, nullable = false)
    private Boolean isDeleted;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
    }
}
