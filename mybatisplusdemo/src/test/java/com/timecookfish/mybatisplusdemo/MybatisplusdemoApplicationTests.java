package com.timecookfish.mybatisplusdemo;
import java.util.Date;

import com.timecookfish.mybatisplusdemo.dao.UserMapper;
import com.timecookfish.mybatisplusdemo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusdemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindAll() {
		List<User> users = userMapper.selectList(null);
		Assert.assertEquals(5,users.size());
		users.forEach(System.out::println);
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setName("盖伦");
		user.setAge(25);
		user.setEmail("xxx@qq.com");
		user.setManagerId(1088248166370832385L);
		user.setCreateTime(new Date());
		int num = userMapper.insert(user);
		Assert.assertEquals(true,num > 0);
	}

	public void selectMap() {
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("manager_id", 1087982257332887553L);
		List<User> users = userMapper.selectByMap(columnMap);
		users.forEach(System.out::println);
	}



}
