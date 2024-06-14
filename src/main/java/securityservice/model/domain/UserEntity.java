package securityservice.model.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import securityservice.util.constant.ConstantsEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = ConstantsEntity.UserTable.NAME)
public class UserEntity extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ConstantsEntity.UserTable.Id.NAME, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RoleEntity.class)
    @JoinColumn(name = ConstantsEntity.RoleTable.Id.NAME, referencedColumnName = ConstantsEntity.RoleTable.Id.NAME)
    private RoleEntity role;

    @Column(name = ConstantsEntity.UserTable.Username.NAME, length = ConstantsEntity.UserTable.Username.LENGTH, nullable = false)
    private String username;

    @Column(name = ConstantsEntity.UserTable.Password.NAME, length = ConstantsEntity.UserTable.Password.LENGTH, nullable = false)
    private String password;

    @Column(name = ConstantsEntity.UserTable.FirstName.NAME, length = ConstantsEntity.UserTable.FirstName.LENGTH, nullable = false)
    private String firstname;

    @Column(name = ConstantsEntity.UserTable.LastName.NAME, length = ConstantsEntity.UserTable.LastName.LENGTH, nullable = false)
    private String lastName;

    @Lob
    @Column(name = ConstantsEntity.UserTable.Avatar.NAME)
    private String avatar;

    @Column(name = ConstantsEntity.UserTable.Email.NAME, length = ConstantsEntity.UserTable.Email.LENGTH)
    private String email;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = ConstantsEntity.UserTable.IsDeleted.NAME, nullable = false)
    private Boolean isDeleted;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
    }
}
