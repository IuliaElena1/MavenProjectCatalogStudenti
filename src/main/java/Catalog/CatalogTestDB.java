package Catalog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CatalogTestDB {
    private SessionFactory sessionFactory;


    //construim factory
    public CatalogTestDB(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build() ;

        MetadataSources sources =new MetadataSources(registry);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public void insertStudent(){
        Session session = sessionFactory.openSession();


        Transaction transaction=session.beginTransaction();


        Student  user =new Student("Popescu Andra", new RezultatGrila(8.5));



        session.persist(user);


        transaction.commit();

        session.close();

    }






}
