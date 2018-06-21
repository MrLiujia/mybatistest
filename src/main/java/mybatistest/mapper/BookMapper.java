package mybatistest.mapper;

import mybatistest.pojo.Book;

public interface BookMapper {
	Book findOne(Long id);
}
