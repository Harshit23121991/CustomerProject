package com.customer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.model.Internalization;



/**
 * @author Pavan
 *
 */
@Repository
public interface InternalizationRepository extends JpaRepository<Internalization, Long>{
	 
	@Query(value = "select s.labelCode, s.english from Internalization s")
	public List<Object[]> getLabelCodeAndEngLanguage();
	@Query(value = "select s.labelCode, s.german from Internalization s")
	public	List<Object[]> getLabelCodeAndGerLanguage();
	@Query(value = "select s.labelCode, s.french from Internalization s")
	public	List<Object[]> getLabelCodeAndFreLanguage();
	@Query(value = "select s.labelCode, s.spanish from Internalization s")
	public	List<Object[]> getLabelCodeAndSpaLanguage();

}
 