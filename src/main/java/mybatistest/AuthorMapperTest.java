package mybatistest;

import java.util.List;

import mybatistest.mapper.AuthorMapper;
import mybatistest.pojo.Author;
import mybatistest.pojo.Book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AuthorMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		AuthorMapper mapper = context.getBean(AuthorMapper.class);
		
		Author author = mapper.findOne(6L);
		System.out.println("findOne: ");
		printAuthor(author);
		
		System.out.println();
		
		System.out.println("findAll:");
		List<Author> authors = mapper.findAll();
		for (Author a : authors) {
			printAuthor(a);
		}
	}

	private static void printAuthor(Author author) {
		String authorInfo = String.format("%s[%s]（%s）", 
				author.getName(), 
				author.getGender(),
				author.getDescription());
		System.out.println(authorInfo);
		
		// 对多关系author.books
		for (Book book : author.getBooks()) {
			System.out.println(String.format("\t《%s》【%s】（%s）", 
					book.getTitle(),
					book.getPublisher().getName(),
					book.getDescription()));
		}
	}
}
