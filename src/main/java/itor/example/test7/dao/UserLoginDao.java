package itor.example.test7.dao;

import itor.example.test7.controller.UserVO;
import itor.example.test7.database.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginDao extends UserDao {


    public UserVO login(UserVO vo){

        return selectIdAndPw("selectIdAndPw" , vo);

    }
    public UserVO selectByNo(int vo){

        return selectByNo("selectByNo", vo);

    }





}
