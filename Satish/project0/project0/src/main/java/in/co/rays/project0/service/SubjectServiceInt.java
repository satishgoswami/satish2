package in.co.rays.project0.service;

import java.util.List;

import in.co.rays.project0.dto.SubjectDTO;
import in.co.rays.project0.exception.DuplicateRecordException;

/**
 * The Interface of SubjectServiceInt
 *
 */

public interface SubjectServiceInt {

	/**
	 * Adds a Subject.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 */
	public long add(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Subject.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 */
	public void update(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Subject
	 * 
	 * param id
	 */
	public void delete(long id);

	/**
	 * Finds a Subject by name.
	 * 
	 * param subjectName
	 * return
	 */
	public SubjectDTO findByName(String subjectName);

	/**
	 * Finds a Subject by ID
	 * 
	 * param id
	 * return
	 */
	public SubjectDTO findById(long id);

	/**
	 * Searches Subject with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 */
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Subject
	 * 
	 * param dto
	 * return
	 */
	public List<SubjectDTO> search(SubjectDTO dto);
}
