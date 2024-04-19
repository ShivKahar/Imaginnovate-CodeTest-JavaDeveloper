package imaginnovate.shivkahar.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import imaginnovate.shivkahar.model.EmpTaxDetails;
import imaginnovate.shivkahar.model.Employee;
import imaginnovate.shivkahar.repository.EmpRepository;
import imaginnovate.shivkahar.services.EmpService;
import imaginnovate.shivkahar.util.TaxCalc;

public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<EmpTaxDetails> getEmployeesTaxDeduction() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmpTaxDetails> employeeTaxDetailsList = new ArrayList<>();
		for (Employee employee : employees) {
			double tax = TaxCalc.calculateTax(employee.getSalary());
			double cess = TaxCalc.calculateCess(employee.getSalary());
			EmpTaxDetails taxDetails = new EmpTaxDetails();

			taxDetails.setEmployeeId(employee.getEmployeeId());
			taxDetails.setFirstName(employee.getFirstName());
			taxDetails.setLastName(employee.getLastName());

			taxDetails.setYearlySalary(employee.getSalary() * 12);
			taxDetails.setTaxAmount(tax);
			taxDetails.setCessAmount(cess);
			employeeTaxDetailsList.add(taxDetails);
		}
		return employeeTaxDetailsList;
	}
}
