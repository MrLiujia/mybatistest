package mybatistest.mapper;

import mybatistest.pojo.Publisher;

public interface PublisherMapper {
	Publisher findOne(Long id);
}
