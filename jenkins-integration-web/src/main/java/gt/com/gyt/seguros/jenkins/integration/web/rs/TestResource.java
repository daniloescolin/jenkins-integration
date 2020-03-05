package gt.com.gyt.seguros.jenkins.integration.web.rs;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gt.com.gyt.seguros.jenkins.integration.model.User;
import gt.com.gyt.seguros.jenkins.integration.svc.TestSvc;


@Stateless
@Path("rs/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource implements Serializable{
	
	private static final Logger logger = LoggerFactory.getLogger(TestResource.class);
	
	@Inject
	private TestSvc testSvc;
	
	
	@GET
    @Path("service")
    public List<User> findAllUsers() {
        logger.debug("find all users ");
        return testSvc.findAllUser();
    }
	
}