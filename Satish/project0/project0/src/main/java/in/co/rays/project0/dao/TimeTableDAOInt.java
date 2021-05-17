package in.co.rays.project0.dao;

import java.util.Date;
import java.util.List;

import in.co.rays.project0.dto.TimeTableDTO;
import in.co.rays.project0.exception.ApplicationException;


public interface TimeTableDAOInt {

	/**
	 * Adds a TimeTable.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(TimeTableDTO dto);

	/**
	 * Updates a TimeTable.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(TimeTableDTO dto);

	/**
	 * Deletes a TimeTable.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	 /**
     * Find  Duplicate TimeTable
     * 
     * @param name
     *            : get parameter course_id Semester Exam Date
     * @return dto
     * @throws ApplicationException
     */
    public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Date examdate);
			
    /**
     * Find  Duplicate TimeTable
     * 
     * @param name
     *            : get parameter course_id subject_id Exam Date
     * @return dto
     * @throws ApplicationException
     */
	public TimeTableDTO findTimeTableDuplicacy(Long courseId, Long subjectId, Date examDate);
			
    
	/**
     * Find  Duplicate TimeTable
     * 
     * @param name
     *            : get parameter course_id Semester Subject_id
     * @return dto
     * @throws ApplicationException
     */
	public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Long subjectId);
			
	/**
	 * Finds TimeTable by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the role DTO
	 */
	public TimeTableDTO findByPK(long pk);

	/**
	 * Searches TimeTable with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize);

	/**
	 * Seraches TimeTable.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto);
}
