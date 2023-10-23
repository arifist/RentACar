package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands")
@Data //getter ve setterlar
@AllArgsConstructor
@NoArgsConstructor
@Entity //veritabani varligi
public class Brand {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	//ID primary key, generatedvalue bir bir id arttır, column veritabanındaki kolon adi
	

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand")
	private List<Model> models;
  	
	/*
	 * public Brand() {
	 * 
	 * }
	 * 
	 * public Brand( int id,String name) { this.name = name; this.id = id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

}
