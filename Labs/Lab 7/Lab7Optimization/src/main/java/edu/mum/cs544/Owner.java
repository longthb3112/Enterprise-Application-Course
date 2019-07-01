package edu.mum.cs544;

import org.hibernate.annotations.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
//@NamedQueries(@NamedQuery(name="Owner.pets",query = "select o from Owner o JOIN FETCH o.pets"))
public class Owner {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
	@OneToMany (cascade={CascadeType.PERSIST})
	//@LazyCollection(LazyCollectionOption.EXTRA)
	@BatchSize(size = 50)
	//@Fetch(FetchMode.SUBSELECT)

	@JoinColumn (name="clientid")

    private List<Pet> pets;
    
	public Owner() {
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
    
	
    
}
