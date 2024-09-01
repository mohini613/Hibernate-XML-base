package HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import lombok.Data;

@Data
public class StudentMain {
public static void main(String[] args) {
	
	StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
	MetadataSources ms= new MetadataSources(registry);
	
	Metadata md =ms.getMetadataBuilder().build();
	SessionFactory sf= md.getSessionFactoryBuilder().build();
	Session session = sf.openSession();//opensession returns session object
	//Transaction tx= session.beginTransaction();
	
	Student s = new Student();
	   s.setsId(101);
	   s.setsName("Rani");
	   s.setAddrs("Pune");
	   
	  
	session.save(s);   
	session.beginTransaction().commit();//commit to store data permanently in database
	session.close();
	sf.close();
	
}
}
