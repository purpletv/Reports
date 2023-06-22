package eStoreProduct.DAO;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import eStoreProduct.model.SlamOrderProduct;
import eStoreProduct.model.orderModel;

@Repository
public class OrderDAOImp implements OrderDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertOrder(orderModel order) {
		entityManager.persist(order);
	}

	@Override
	@Transactional
	public List<orderModel> getAllOrders() {
	    /*
	     * Session currentSession = entityManager.unwrap(Session.class); CriteriaBuilder
	     * criteriaBuilder = currentSession.getCriteriaBuilder();
	     * CriteriaQuery<orderModel> criteriaQuery =
	     * criteriaBuilder.createQuery(orderModel.class); Root<orderModel> root =
	     * criteriaQuery.from(orderModel.class); criteriaQuery.select(root);
	     * 
	     * TypedQuery<orderModel> query = currentSession.createQuery(criteriaQuery);
	     * return query.getResultList();
	     */
	    List<orderModel> slamOrders;
	    try {
	            // Retrieve all SlamOrders
	            TypedQuery<orderModel> query = entityManager.createQuery("SELECT o FROM orderModel o", orderModel.class);
	             slamOrders = query.getResultList();

	            for (orderModel slamOrder : slamOrders) {
	                // Access SlamOrder properties
			
			  double orderId = slamOrder.getId(); 
			  Integer customerId = slamOrder.getOrdr_cust_id();
			  System.out.println("ordr id:"+orderId+"  customerId:"+customerId);
	                // ...

	                // Access related SlamOrderProducts
	                List<SlamOrderProduct> orderProducts = slamOrder.getOrderProducts();
	                for (SlamOrderProduct orderProduct : orderProducts) {
	                    // Access SlamOrderProduct properties
	                    Integer productId = orderProduct.getProductId();
	                    Integer quantity = orderProduct.getQuantity();
	                    System.out.println("in orderprods");
	                    System.out.println("productId:"+productId+"  quantity:"+quantity);
	                    // ...
	                }
	                return slamOrders;
	            }
	        }catch (Exception e) {
	            // Handle the exception appropriately (e.g., logging, throwing custom exception, etc.)
	            e.printStackTrace();
	            return Collections.emptyList(); // or throw an exception if required
	        }
	    return slamOrders;
	    }

	@Override
	@Transactional
	public void updateOrderProcessedBy(Integer orderId, Integer processedBy) {
		// Retrieve the order entity based on the order ID
		orderModel order = entityManager.find(orderModel.class, orderId);

		// Check if the order exists
		if (order != null) {
			// Set the processed by information on the order entity
			order.setOrdr_processedby(processedBy);

			// Save the updated order entity to the database
			entityManager.merge(order);
		}
	}

	@Override
	@Transactional
	public List<orderModel> loadOrdersByDate(Timestamp startDate, Timestamp endDate) {
		System.out.println("loading");
		Session currentSession = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<orderModel> criteriaQuery = criteriaBuilder.createQuery(orderModel.class);
		Root<orderModel> root = criteriaQuery.from(orderModel.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.between(root.get("orderDate"), startDate, endDate));

		TypedQuery<orderModel> query = currentSession.createQuery(criteriaQuery);
		return query.getResultList();
	}

}