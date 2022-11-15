package fish.payara.micro.sample.dao;

import fish.payara.micro.sample.model.Employee;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class EmployeeDAO {

  @Inject
  private EntityManager em;

  public List<Employee>  findRange(int start, int count){
    TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class)
        .setMaxResults(count)
        .setFirstResult(start);
    return query.getResultList();
  }
}
