package com.fann.dao;

import com.fann.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username")String username,@Param("password") String password);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username,@Param("question") String question,@Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("md5Pwd") String md5Pwd);

    int checkPassword(@Param("password")String password,@Param("userId") Integer userId);

    int checkEmailByUserId(@Param("email")String email, @Param("id")Integer id);
}