package fish.payara.micro.sample.service;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import fish.payara.micro.sample.dao.EmployeeDAO;
import fish.payara.micro.sample.model.Employee;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Produces(APPLICATION_JSON)
@Path("employee")
public class EmployeeREST {

  @Inject
  private EmployeeDAO employeeDAO;

  @GET
  public Response findRange(@QueryParam("start") int start, @QueryParam("count") int count){
    List<Employee> list = employeeDAO.findRange(start, count);
    return Response.ok(list).build();
  }
}
