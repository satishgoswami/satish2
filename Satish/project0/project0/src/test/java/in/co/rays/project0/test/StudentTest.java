package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class StudentTest {
	@Autowired
	StudentServiceInt service;

	@Ignore
	public void add() throws ParseException {
		StudentDTO dto = new StudentDTO();
		dto.setFirstName("Rani");
		dto.setLastName("Khanam");
		dto.setCollegeId(3l);
		dto.setGender("F");
		dto.setMobileNo("9089097873");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("28/02/1988"));
		dto.setEmail("rani@gmail.com");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			long pk = service.add(dto);
			System.out.println("Add Success=" + pk);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	public void update() throws ParseException {

		StudentDTO dto = new StudentDTO();
		dto.setFirstName("Raj");
		dto.setId(1);
		dto.setLastName("Seth");
		dto.setCollegeId(2l);
		dto.setGender("M");
		dto.setMobileNo("8635986535");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("31/02/1995"));
		dto.setEmail("rajseth@gmail.com");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			service.update(dto);
			System.out.println("Update Success");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void delete() {

		service.delete(4);
		System.out.println("Deleted successfully");
	}

	@Ignore
	public void findByPk() {
		StudentDTO dto = service.findById(1);
		System.out.println("find by pk Success " + dto.getFirstName());
	}

	@Ignore
	public void findByEmail() {

		StudentDTO dto = service.findByEmail("rajk@gmail.com");
		System.out.println("Find by Email Success " + dto.getFirstName());
	}

	@Ignore
	public void searchPagination() {
		StudentDTO dto = new StudentDTO();
		// dto.setId(1);
		dto.setCollegeId(3l);
		// dto.setFirstName("raj");
		// dto.setLastName("Kumar");

		List<StudentDTO> list = service.search(dto, 1, 10);
		System.out.println("Search pagination success " + list.size());

	}

	@Test
	public void search() {
		StudentDTO dto = new StudentDTO();

		List<StudentDTO> list = service.search(dto);
		System.out.println("Search  success " + list.size());
	}

}
