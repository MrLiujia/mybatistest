package mybatistest.mapper;

import java.util.List;

import mybatistest.pojo.Publisher;

public interface PublisherMapper {
	Publisher findOne(Long id);
	
	List<Publisher> findAll();
}
