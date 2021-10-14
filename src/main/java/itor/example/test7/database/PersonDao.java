package itor.example.test7.database;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;



public class PersonDao {
    protected Log log = LogFactory.getLog(PersonDao.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    protected void printQueryId(String queryId){
        if(log.isDebugEnabled()){
            log.debug("|t QueryId |t: " + queryId);
        }
    }


   public Object insertPerson(String queryId , Object params) {
       printQueryId(queryId);

        return sqlSessionTemplate.insert(queryId, params);
    }

    


}
