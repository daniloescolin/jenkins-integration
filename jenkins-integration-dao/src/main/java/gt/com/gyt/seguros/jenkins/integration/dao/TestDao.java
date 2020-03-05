package gt.com.gyt.seguros.jenkins.integration.dao;

import java.util.List;
import gt.com.gyt.seguros.jenkins.integration.model.User;

/**
 *
 * @author descolin
 */
public interface TestDao {
    
   public List<User> findAllUsers();
}
