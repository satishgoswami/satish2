package in.co.rays.project0.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.dto.TimeTableDTO;
import in.co.rays.project0.exception.DuplicateRecordException;
import in.co.rays.project0.service.TimeTableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class TimeTableTest {
	@Autowired
	TimeTableServiceInt service;

	@Test
	public void add() {
		TimeTableDTO dto = new TimeTableDTO();
		dto.setCourseId(2);
		dto.setSubjectId(2);
		dto.setSemester("I");
		dto.setTime("10 am to 1 pm");
		dto.setExamDate(new Date());
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());
		try {
			service.add(dto);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	public void update() {
		TimeTableDTO dto = new TimeTableDTO();
		dto.setId(1);
		dto.setCourseId(1);
		dto.setSubjectId(1);
		dto.setSemester("I");
		dto.setTime("9 am to 12 pm");
		dto.setExamDate(new Date());
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(dto.getCreatedDateTime());

		try {
			service.update(dto);
			System.out.println("Update successs===========");
		} catch (DuplicateRecordException e) {
			System.out.println("Update " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
