package com.example.emaillist.dao;

import java.util.List;

import com.example.emaillist.vo.UserVo;

public interface UserDao {
	public UserVo getUserByEmailandPassword(String email, String password);
	public int insert(UserVo vo);
	
}
