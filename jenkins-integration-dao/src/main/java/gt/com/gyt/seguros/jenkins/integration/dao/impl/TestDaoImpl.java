package gt.com.gyt.seguros.jenkins.integration.dao.impl;

import gt.com.gyt.seguros.jenkins.integration.dao.TestDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import gt.com.gyt.seguros.jenkins.integration.model.User;

/**
 *
 * @author descolin
 */
@Stateless
public class TestDaoImpl implements Serializable, TestDao {

    private static final Logger logger = LoggerFactory.getLogger(TestDaoImpl.class.getName());

    @PersistenceContext(unitName = "TestPU")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    @Override
    public List<User> findAllUsers() {
        Query query = getEntityManager().createNamedQuery("User.findAll");
        return query.getResultList();
    }

}
