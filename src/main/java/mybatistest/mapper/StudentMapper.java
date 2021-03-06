package mybatistest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mybatistest.pojo.Gender;
import mybatistest.pojo.Student;

public interface StudentMapper {
	List<Student> findAll();
	
	// 当返回类型不是List时，结果集行数必须<=1，当行数=0时返回null，当行数>1时抛异常（TooManyResultsException）
	// 传参情形a：当只有一个简单类型的参数时，mapper.xml中使用#{参数名}取值
	Student findOne(Long id);
	
	// 传参情形b：当只有一个pojo类型的参数时，mapper.xml中使用#{属性名}取值
	void create(Student student);
	
	void delete(Long id);
	
	void update(Student student);
	
	// 传参情形c：当有多个简单类型的参数时，需要给每个参数加@Param(参数名)才能在mapper.xml中使用#{参数名}取值
	List<Student> findByGenderAndMajor(
			@Param("gender") Gender gender, 
			@Param("major") String major);
	
	// 单列情形1：结果集是单行单列
	Long count();
	
	// 单列情形2：结果集是多行单列
	List<String> findAllMajors();
	
	// 注意：此处虽然符合传参情形a，但是因为name是用于OGNL表达式中（<bind value>），所以需要@Param注解
	List<Student> findByNameLike(@Param("name") String name);
	
	void batchDelete(@Param("ids") List<Long> ids);
	
	List<Student> search(Student student);
}
