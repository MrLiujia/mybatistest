package mybatistest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

	public static void main(String[] args) throws IOException {
		// 创建SqlSessionFactory（SQL会话工厂）
		String resource = "mybatis-config.xml"; // mybatis配置文件路径
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		SqlSession session = sqlSessionFactory.openSession(); // 打开会话
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class); // 获取Mapper
			List<Student> list = mapper.findAll();  // 调用CRUD方法
			System.out.println(list);
		} finally { // 释放资源 - 关闭会话
			session.close();
		}
	}

}
