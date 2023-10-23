//package kodlama.io.rentACar.dataAccess.concretes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
//import kodlama.io.rentACar.entities.concretes.Brand;
//
//@Repository //bu sinif dataaccess nesnesidir
//public class InMemoryBrandRepository implements BrandRepository{
//
//	List<Brand> brands;
//	public InMemoryBrandRepository() {
//		brands=new ArrayList<Brand>();
//		brands.add(new Brand("bmw",1));
//		brands.add(new Brand("mercedes",2));
//		brands.add(new Brand("audi",3));
//		brands.add(new Brand("renault",4));
//	}
//	public List<Brand> getAll() {
//		// TODO Auto-generated method stub
//		return brands;
//	}
//
//}
