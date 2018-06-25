package mybatistest.mapper;

import mybatistest.pojo.Author;

public interface AuthorMapper {
	Author findOne(Long id);
}
