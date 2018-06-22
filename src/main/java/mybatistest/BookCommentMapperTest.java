package mybatistest;

import mybatistest.mapper.BookCommentMapper;
import mybatistest.mapper.BookMapper;
import mybatistest.pojo.Book;
import mybatistest.pojo.BookComment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookCommentMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookCommentMapper mapper = context.getBean(BookCommentMapper.class);
		
		BookComment comment = mapper.findOne(1L);
		System.out.println("findOne: " + String.format("%s《%s》", 
				comment.getComment(), comment.getBook().getTitle()));
	}
}
