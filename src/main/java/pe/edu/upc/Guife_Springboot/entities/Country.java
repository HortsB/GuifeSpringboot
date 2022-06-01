package pe.edu.upc.guife.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCountry;
	
	@Column(name="NameCountry", length=45, nullable=false)
	private String NameCountry;
	
	@Column(name="AbbreviationCountry", length= 5, nullable=false)
	private String AbbreviationCountry;
	
	@Column(name="Continent", length=45, nullable=false)
	private String Continent;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Country(int idCountry, String nameCountry, String abbreviationCountry, String continent) {
		super();
		this.idCountry = idCountry;
		NameCountry = nameCountry;
		AbbreviationCountry = abbreviationCountry;
		Continent = continent;
	}



	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getNameCountry() {
		return NameCountry;
	}

	public void setNameCountry(String nameCountry) {
		NameCountry = nameCountry;
	}


	public String getAbbreviationCountry() {
		return AbbreviationCountry;
	}

	public void setAbbreviationCountry(String abbreviationCountry) {
		AbbreviationCountry = abbreviationCountry;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String continent) {
		Continent = continent;
	}
	

}
