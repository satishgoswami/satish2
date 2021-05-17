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

import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class SubjectTest {
	@Autowired
	SubjectServiceInt service;

	@Ignore
	public void add(){
		SubjectDTO dto=new SubjectDTO();
		dto.setName("English");
		dto.setCourseId(3);
		dto.setSemester("6");
		dto.setDescription("General literature");
		dto.setCreatedBy("root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
	try {
		long pk=service.add(dto);
		System.out.println("=========Subject Add Success====== "+pk);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Ignore
	public void update(){
		SubjectDTO dto=new SubjectDTO();
		dto.setName("cse");
		dto.setId(1);
		dto.setCourseId(1);
		dto.setSemester("I");
		dto.setDescription("Computer");
		dto.setCreatedBy("Root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			service.update(dto);
			System.out.println("=======Subject Update Success=========");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Ignore
	public void delete(){
		service.delete(3);
	System.out.println("Data deleted successfully");
	}
	@Ignore
	public void findByPk(){
		SubjectDTO dto=service.findById(1);
		System.out.println("=======Subject findByPk success===="+dto.getName() );
	}
	@Ignore
	public void findByName(){
		SubjectDTO dto=service.findByName("Mech");
		System.out.println("=======Subject findByName Success======"+dto.getId());
	}
	@Ignore
	public void search(){
		SubjectDTO dto=new SubjectDTO();
		List<SubjectDTO> l=service.search(dto);
		System.out.println("==========Subject search success====="+l.size());
	}
	@Ignore
	public void searchPage(){
		SubjectDTO dto=new SubjectDTO();
		//dto.setId(1);
	dto.setCourseId(1);
		//dto.setName("cse");
		List<SubjectDTO> l=service.search(dto,1,10);
		
	System.out.println("==========Subject searchPagination success====="+l.size());
	}
}
