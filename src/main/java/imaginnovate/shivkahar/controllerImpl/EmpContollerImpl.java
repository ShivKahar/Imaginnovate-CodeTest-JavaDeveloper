package imaginnovate.shivkahar.controllerImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imaginnovate.shivkahar.controller.EmpController;
import imaginnovate.shivkahar.model.EmpTaxDetails;
import imaginnovate.shivkahar.model.Employee;
import imaginnovate.shivkahar.services.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpContollerImpl implements EmpController{

	@Autowired
	private EmpService employeeService;

	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
			return ResponseEntity.ok("Employee added successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Override
	@GetMapping("/tax-deduction")	
	public ResponseEntity<?> getEmployeesTaxDeduction() {
		try {
			List<EmpTaxDetails> taxDeductions = employeeService.getEmployeesTaxDeduction();
			return ResponseEntity.ok(taxDeductions);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
