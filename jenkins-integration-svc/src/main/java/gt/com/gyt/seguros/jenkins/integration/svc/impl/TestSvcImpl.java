package gt.com.gyt.seguros.jenkins.integration.svc.impl;

import gt.com.gyt.seguros.jenkins.integration.dao.TestDao;
import gt.com.gyt.seguros.jenkins.integration.svc.TestSvc;
import gt.com.gyt.seguros.jenkins.integration.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author descolin
 */
public class TestSvcImpl implements TestSvc {

    @Inject
    TestDao dao;

    @Override
    public List<User> findAllUser() {
        return dao.findAllUsers();
    }

}
