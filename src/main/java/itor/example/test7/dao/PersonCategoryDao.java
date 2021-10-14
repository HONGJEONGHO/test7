package itor.example.test7.dao;

import itor.example.test7.controller.PersonVO;
import itor.example.test7.database.PersonDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonCategoryDao extends PersonDao {

    public void insertPersonCategory(PersonVO vo){

        insertPerson("insertPersonCategory" ,vo);
    }



}
