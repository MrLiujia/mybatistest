package mybatistest;

import java.util.Arrays;
import java.util.List;

import mybatistest.mapper.StudentMapper;
import mybatistest.pojo.Gender;
import mybatistest.pojo.Student;

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
		
		System.out.println("findByNameLike: " + mapper.findByNameLike("赵"));
		
//		mapper.batchDelete(Arrays.asList(7L, 11L));
		
		Student searchByName = new Student();
		searchByName.setName("li");
		System.out.println("search 1: " + mapper.search(searchByName));
		
		Student searchByMajor = new Student();
		searchByMajor.setMajor("Java");
		System.out.println("search 2: " + mapper.search(searchByMajor));
		
		Student searchByGenderAndMajor = new Student();
		searchByGenderAndMajor.setGender(Gender.Female);
		searchByGenderAndMajor.setMajor("Java");
		System.out.println("search 3: " + mapper.search(searchByGenderAndMajor));
	}
}
