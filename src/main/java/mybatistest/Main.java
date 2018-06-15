package mybatistest;

import java.util.List;

import mybatistest.mapper.StudentMapper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		StudentMapper mapper = context.getBean(StudentMapper.class);
		List<Student> list = mapper.findAll();
		System.out.println(list);
	}
}
