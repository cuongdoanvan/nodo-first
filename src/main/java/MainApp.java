import entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();


        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Item> root = criteriaQuery.from(Item.class);


        //select all records
        System.out.println("tim kiem full");
        CriteriaQuery<Object> select = criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("itemId"),1));
        TypedQuery<Object> typedQuery = em.createQuery(select);
        List<Object> resultlist = typedQuery.getResultList();

        for(Object o:resultlist) {
            Item e = (Item) o;
            System.out.println("EID : " + e.getItemId() + " Ename : " + e.getItemName());
        }

        CriteriaQuery<Object> select1 = criteriaQuery.select(root);
        select1.orderBy(criteriaBuilder.asc(root.get("itemDescription")));
        TypedQuery<Object> typedQuery1 = em.createQuery(select1);
        List<Object> resultlist1 = typedQuery1.getResultList();

        for(Object o:resultlist1) {
            Item e = (Item) o;
            System.out.println(e);
        }


        CriteriaUpdate<Item> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Item.class);
        Root<Item> root1 = criteriaUpdate.from(Item.class);
        criteriaUpdate.set("itemPrice", 312123);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("itemPrice"), 3));

         em.getTransaction().begin();
        em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();

        em.close( );
        entityManagerFactory.close( );
    }
}
