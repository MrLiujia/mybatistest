package exercise1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exercise1.mapper.OperatorMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		OperatorMapper mapper = context.getBean(OperatorMapper.class);
		List<Operator> list = mapper.findAll();  // 调用CRUD方法
		System.out.println("findAll: " + list);
		
		System.out.println("findByUsernameLike: " + mapper.findByUsernameLike("is"));
		
//		mapper.batchDisable(Arrays.asList(2), true); // 禁用
		mapper.batchDisable(Arrays.asList(2), false); // 启用
	}

}
