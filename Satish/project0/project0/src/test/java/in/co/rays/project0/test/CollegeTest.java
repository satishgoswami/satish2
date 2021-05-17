package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.CollegeDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.CollegeServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class CollegeTest {
	@Autowired
	CollegeServiceInt service;

	@Ignore
	public void add() {
		CollegeDTO dto = new CollegeDTO();
		dto.setName("AITR");
		dto.setPhoneNo("78786953567");
		dto.setAddress("Ujjain");
		dto.setState("MP");
		dto.setCity("Ujjain");
		dto.setCreatedBy("Root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			long pk = service.add(dto);
			System.out.println("College Add Success=  " + pk);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Ignore
	public void update() {
		CollegeDTO dto = new CollegeDTO();
		dto.setId(3);
		dto.setName("AITR");
		dto.setPhoneNo("8256953586");
		dto.setAddress("Dewas");
		dto.setState("MP");
		dto.setCity("Dewas");
		dto.setCreatedBy("Root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());

		try {
			service.update(dto);
			System.out.println("Student Upadte Success");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	public void delete() {
		
		service.delete(1);
		System.out.println("Data Deleted successfully");
	}

	@Ignore
	public void findByName() {
		CollegeDTO dto = service.findByName("AITR");
		System.out.println("Find By name Success= " + dto.getId());
	}

	@Ignore
	public void findById() {
		CollegeDTO dto = service.findById(2);
		System.out.println("Find By ID Success= " + dto.getName());
	}

	@Ignore
	public void searchPagination() {
		CollegeDTO dto = new CollegeDTO();
		//dto.setId(1);
		//dto.setName("pcst");
		List list = service.search(dto, 0, 10);
		System.out.println("Search Pagination Method Success ListSize= " + list.size());
	}

	@Ignore
	public void search() {
		CollegeDTO dto = new CollegeDTO();
		List list = service.search(dto);
		System.out.println("Search Method Success ListSize= " + list.size());
	}
}
