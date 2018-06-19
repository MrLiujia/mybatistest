package mybatistest.mapper;

import java.util.List;

import mybatistest.Student;

public interface StudentMapper {
	List<Student> findAll();
	
	// 当返回类型不是List时，结果集行数必须<=1，当行数=0时返回null，当行数>1时抛异常（TooManyResultsException）
	// 传参情形a：当只有一个简单类型的参数时，mapper.xml中使用#{参数名}取值
	Student findOne(Long id);
	
	// 传参情形b：当只有一个pojo类型的参数时，mapper.xml中使用#{属性名}取值
	void create(Student student);
	
	void delete(Long id);
	
	void update(Student student);
}
