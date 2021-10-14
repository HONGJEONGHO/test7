package itor.example.test7.database;

import itor.example.test7.controller.FreeboardVO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseDao {

    protected Log log = LogFactory.getLog(BaseDao.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    protected void printQueryId(String queryId){
        if(log.isDebugEnabled()){
            log.debug("|t QueryId |t:" + queryId);
        }
    }

    public Object insert(String queryId, Object params){
        printQueryId(queryId);

        return sqlSessionTemplate.insert(queryId,params);
    }
    public Object update(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.update(queryId,params);
    }
    public Object update(String queryId){
        return sqlSessionTemplate.update(queryId);
    }
    public Object delete(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.delete(queryId,params);
    }
    public Object delete(String queryId){
        return sqlSessionTemplate.delete(queryId);
    }
    public Object select(String queryId){
        printQueryId(queryId);
        return sqlSessionTemplate.selectOne(queryId);
    }
    public Object select(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.selectOne(queryId,params);
    }
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
        printQueryId(queryId);
        return sqlSessionTemplate.selectList(queryId);
    }
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId , Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.selectList(queryId,params);
    }


}
