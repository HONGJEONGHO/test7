package itor.example.test7.dao;



import itor.example.test7.controller.FreeboardVO;
import itor.example.test7.database.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FreeboardListDao extends BaseDao {




    public List<FreeboardVO> getFreeboard(){



        return selectList("selectList");
    }
    public int getContentCount(int page_num){

        return (int) select("selectContentCount",page_num);
    }



}
