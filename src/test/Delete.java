package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pojo.News;

public class Delete {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

	@Before
	public void setUp() throws Exception {
		//1. 创建一个 SessionFactory 对象(4.3以后新用法)
		SessionFactory sessionFactory = null;
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		                                       .applySettings(configuration.getProperties());
		StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder.build();
		sessionFactory = configuration.buildSessionFactory(registry);	
			
		//2. 创建一个 Session 对象
		Session session = sessionFactory.openSession();
				
		//3. 开启事务
		Transaction transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		//5. 提交事务 
		transaction.commit();
				
		//6. 关闭 Session
		session.close();
				
		//7. 关闭 SessionFactory 对象
		sessionFactory.close();
	}

	@Test
	public void test() {
		session.delete(session.get(News.class, 1));
	}

}
