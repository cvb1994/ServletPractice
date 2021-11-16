package dao;

import model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ProductDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<Product> getList(){
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("Select p from Product p",Product.class);
            List<Product> list = query.getResultList();
            return list;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Product getProduct(int id){
        try {
            em = emf.createEntityManager();
            Product product = em.find(Product.class, id);
            return  product;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public boolean save(Product product){
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int id = product.getId();
            if(id != 0){
                Product productEdit = em.find(Product.class, id);
                productEdit.setName(product.getName());
                productEdit.setPrice(product.getPrice());
                productEdit.setAmount(product.getAmount());
                productEdit.setDetail(product.getDetail());
            } else {
                em.persist(product);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(int id){
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Product product = em.find(Product.class, id);
            em.remove(product);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
