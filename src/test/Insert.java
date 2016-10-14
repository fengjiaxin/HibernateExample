package test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import pojo.News;

public class Insert {

	@Test
	public void test() {
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
				
		//4. 执行保存操作
		News news = new News("新闻", "内容", new Date());
		try {
			session.save(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
				
		//5. 提交事务 
		transaction.commit();
				
		//6. 关闭 Session
		session.close();
				
		//7. 关闭 SessionFactory 对象
		sessionFactory.close();
		
	}

}
