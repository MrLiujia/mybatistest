package mybatistest.mapper;

import java.util.List;

import mybatistest.pojo.Author;

public interface AuthorMapper {
	Author findOne(Long id);
	
	List<Author> findAll();
}
