package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand,Integer>{
	//List<Brand> getAll();
	boolean existsByName(String name); //spring jpa keywords
	//spring jpa otamatik olarak aynı isimde başka var mı yok mu bakıp true veya false dondurur

}
