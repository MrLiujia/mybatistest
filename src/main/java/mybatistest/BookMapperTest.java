package mybatistest;

import mybatistest.mapper.BookMapper;
import mybatistest.pojo.Author;
import mybatistest.pojo.Book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookMapper mapper = context.getBean(BookMapper.class);
		
		Book book = mapper.findOne(1L);
		System.out.println("findOne: " + book.getTitle() + ", " + 
				// 对一关系Book.publisher
				book.getPublisher().getName());
		// 对多关系Book.authors
		for (Author author : book.getAuthors()) {
			System.out.println(author.getName() + "," + author.getGender());
		}
	}
}
