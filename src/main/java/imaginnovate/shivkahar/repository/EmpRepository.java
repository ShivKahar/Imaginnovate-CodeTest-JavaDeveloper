package imaginnovate.shivkahar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import imaginnovate.shivkahar.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {
}