package gt.com.gyt.seguros.jenkins.integration.svc;

import gt.com.gyt.seguros.jenkins.integration.model.User;
import java.util.List;

/**
 *
 * @author descolin
 */
public interface TestSvc {
    
    List<User> findAllUser();
}
