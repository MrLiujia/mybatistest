package mybatistest.mapper;

import java.util.List;

import mybatistest.Student;

public interface StudentMapper {
	List<Student> findAll();
	
//	Student findOne(Long id);
//	
//	void create(Student student);
//	
//	void delete(Long id);
//	
//	void update(Student student);
}
