package com.layer.junit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.layer.pictureManager.dao.PictureDAOImpl;
import com.layer.pictureManager.entity.Picture;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoAppConfig)
public class PictureDAOImplTest {

	PictureDAOImpl pictureDAO = new PictureDAOImpl();

	Picture picture = new Picture();

	@Autowired
	EntityManager em;

	// private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		List resultList = em.createQuery("Select p From Picture p").getResultList();
		System.out.println(resultList);
	}

	@Test
	public void contextLoads2() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		TypedQuery<Picture> query = em.createQuery("Select p From Picture p", Picture.class);
		List resultList = em.createQuery("Select p From Picture p").getResultList();
		System.out.println(resultList);
	}

	@Test
	public void jpql_basic() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		TypedQuery<Picture> query = em.createQuery("Select p From Picture p where name like'%100 Steps%'",
				Picture.class);
		List resultList = em.createQuery("Select p From Picture p").getResultList();
		System.out.println(resultList);
	}

	@Test
	public void jpql_basic_nativeQueries() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		Query query1 = em.createNativeQuery("SELECT * FROM COURSE", Picture.class);
		List resultList = query1.getResultList();
		System.out.println(resultList);
	}

	@Test
	public void jpql_basic_nativeQueries2() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		Query query1 = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Picture.class);
		query1.setParameter(1, 1);
		List resultList = query1.getResultList();
		System.out.println(resultList);
	}

	@Test
	public void jpql_basic_nativeQueries3() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		Query query1 = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Picture.class);
		query1.setParameter("id", 1);
		List resultList = query1.getResultList();
		System.out.println(resultList);
	}

	@Test
	public void jpql_basic_nativeQueries4() {
		// logger.info("Test is Running");
		System.out.println("Nesto bezveze");
		Query query1 = em.createNativeQuery("Update Course set last_updated_date=", Picture.class);
		query1.setParameter("id", 1);
		List resultList = query1.getResultList();
		System.out.println(resultList);
	}

}
