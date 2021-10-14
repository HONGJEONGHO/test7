package itor.example.test7.database;


import itor.example.test7.controller.FreeboardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class FreeboardDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<FreeboardVO> selectFreeboard(String queryId, FreeboardVO vo){

        return sqlSessionTemplate.selectList(queryId);

    }

}
