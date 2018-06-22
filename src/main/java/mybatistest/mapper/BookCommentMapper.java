package mybatistest.mapper;

import mybatistest.pojo.BookComment;

public interface BookCommentMapper {
	BookComment findOne(Long id);
}
