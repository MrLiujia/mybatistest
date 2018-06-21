package mybatistest;

import mybatistest.mapper.BookMapper;
import mybatistest.pojo.Book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookMapper mapper = context.getBean(BookMapper.class);
		
		Book book = mapper.findOne(1L);
		System.out.println("findOne: " + book.getTitle() + ", " + book.getPublisher().getName());
	}
}
