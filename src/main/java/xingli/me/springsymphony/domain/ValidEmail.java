package xingli.me.springsymphony.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author xingli13
 * @date 2018/11/8
 */
@Entity
@Table
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ValidEmail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	private String uuid;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;
}
