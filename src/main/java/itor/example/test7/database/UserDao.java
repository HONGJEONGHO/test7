package itor.example.test7.database;



import itor.example.test7.controller.FreeboardVO;
import itor.example.test7.controller.UserVO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;



public class UserDao {
    protected Log log = LogFactory.getLog(UserDao.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    protected void printQueryId(String queryId){
        if(log.isDebugEnabled()){
            log.debug("|t QueryId |t:" + queryId);
        }
    }

    public UserVO selectIdAndPw(String queryId , Object params){
        printQueryId(queryId);

        return sqlSessionTemplate.selectOne(queryId , params);
    }
    public UserVO selectByNo(String queryId , Object params){

        return sqlSessionTemplate.selectOne(queryId,params);
    }



}
