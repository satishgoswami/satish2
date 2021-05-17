package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.StudentDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

public interface StudentServiceInt {
	/**
	 * Adds a Student.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(StudentDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Student.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(StudentDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Student
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a Student by Email ID.
	 * 
	 * param email
	 * return
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds a Student by ID
	 * 
	 * param id
	 * return
	 */
	public StudentDTO findById(long id);

	/**
	 * Searches Students with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Students
	 * 
	 * param dto
	 * return
	 */
	public List<StudentDTO> search(StudentDTO dto);
}
