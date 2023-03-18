package ma.gestion.pharmacie.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Userrole {
    @EmbeddedId
    private UserRolePK userRolePK;

    @ManyToOne
    @JoinColumn(name = "user", insertable = false, nullable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "role", insertable = false, nullable = false, updatable = false)
    private Role role;
}