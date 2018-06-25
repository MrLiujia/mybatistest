package mybatistest;

import mybatistest.mapper.BookMapper;
import mybatistest.mapper.PublisherMapper;
import mybatistest.pojo.Author;
import mybatistest.pojo.Book;
import mybatistest.pojo.Publisher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PublisherMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		PublisherMapper mapper = context.getBean(PublisherMapper.class);
		
		Publisher publisher = mapper.findOne(3L);
		
		System.out.println("findOne: " + String.format("%s（%s）", 
				publisher.getName(), 
				publisher.getDescription() != null ? publisher.getDescription() : "无简介"));
		
		// 对多关系Publisher.books
		for (Book book : publisher.getBooks()) {
			System.out.print(String.format("《%s》", book.getTitle()));
			String authors = "【";
			for (int i = 0; i < book.getAuthors().size(); i++) {
				// 对多关系Book.authors
				authors += book.getAuthors().get(i).getName();
				if (i != (book.getAuthors().size() - 1)) {
					authors += "、"; // 如果不是最后一个，就加顿号
				}
			}
			authors += "】";
			System.out.println(authors);
		}
	}
}
