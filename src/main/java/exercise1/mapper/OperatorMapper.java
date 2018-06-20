package exercise1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import exercise1.Operator;

public interface OperatorMapper {
	List<Operator> findAll();
	
	List<Operator> findByUsernameLike(@Param("username") String username);
	
	void batchDisable(
			@Param("ids") List<Integer> ids, 
			@Param("disabled") Boolean disabled);
}
