package imaginnovate.shivkahar.services;

import java.util.List;

import imaginnovate.shivkahar.model.EmpTaxDetails;
import imaginnovate.shivkahar.model.Employee;

public interface EmpService {
	void addEmployee(Employee employee);
    List<EmpTaxDetails> getEmployeesTaxDeduction();
}
