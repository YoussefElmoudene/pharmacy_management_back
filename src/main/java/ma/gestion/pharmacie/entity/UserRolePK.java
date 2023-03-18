package ma.gestion.pharmacie.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@Getter
@Setter
public class UserRolePK implements Serializable {

    private  Long user;
    private Long role;
}
