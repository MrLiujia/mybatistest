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
		System.out.println("findAll: " + list);
		
		System.out.println("findOne: " + mapper.findOne(4L));
		System.out.println("findOne: " + mapper.findOne(3L)); // id不存在时返回null
		
		Student zhaoliu = new Student();
		zhaoliu.setName("赵六");
		zhaoliu.setGender(Gender.Male);
		zhaoliu.setAge(30);
		zhaoliu.setMajor("Hadoop");
//		mapper.create(zhaoliu);
//		System.out.println("create: #" + zhaoliu.getId());
		
//		mapper.delete(6L);
		
		Student zhangsan = mapper.findOne(4L);
//		zhangsan.setMajor("PS");
//		mapper.update(zhangsan);
		
		List<Student> femaleJavaStudents = mapper.findByGenderAndMajor(Gender.Female, "Java");
		System.out.println("findByGenderAndMajor: " + femaleJavaStudents);
		
		System.out.println("count: " + mapper.count());
		System.out.println("findAllMajors: " + mapper.findAllMajors());
	}
}
