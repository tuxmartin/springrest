package eu.vancl.martin.springrest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ROLES")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<User> uzivatele;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<User> getUzivatele() {
		return uzivatele;
	}
	
	public void setUzivatele(List<User> uzivatele) {
		this.uzivatele = uzivatele;
	}
	

}