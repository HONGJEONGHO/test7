package itor.example.test7.service;

import itor.example.test7.controller.FreeboardVO;
import itor.example.test7.controller.ResultVO;
import itor.example.test7.controller.UserVO;
import itor.example.test7.dao.FreeboardListDao;
import itor.example.test7.dao.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class FreeboardService {


    @Autowired
    private FreeboardListDao freeboardListDao;
    @Autowired
    private UserLoginDao userLoginDao;

    public List<ResultVO> getFreeboard() {

        List<ResultVO> result = new ArrayList<>();

        List<FreeboardVO> freeboardlist = freeboardListDao.getFreeboard();


        for(FreeboardVO freeboardVO : freeboardlist){

            ResultVO resultVo = new ResultVO();

            int userNo = freeboardVO.getUser_no();

            UserVO userVO = userLoginDao.selectByNo(userNo);


            resultVo.setUserVO(userVO);
            resultVo.setFreeboardVO(freeboardVO);

            result.add(resultVo);

        }
        return result;
    }

    //Thymeleaf 에서 인식을 못함.
//    public ArrayList<HashMap<String, Object>> getFreeboard() {
//
//        ArrayList<HashMap<String , Object>> result = new ArrayList<>() ;
//
//        List<FreeboardVO> freeboardlist = freeboardListDao.getFreeboard();
//
//            for(FreeboardVO freeboardVO : freeboardlist){
//
//                HashMap<String , Object> map = new HashMap<>();
//
//                int userNo = freeboardVO.getUser_no();
//
//                UserVO userVO = userLoginDao.selectByNo(userNo);
//
//
//
//                map.put("userVO", userVO);
//                map.put("freeboardVO",freeboardVO);
//
//                result.add(map);
//
//            }
//
//
//            return result;
//    }

    public void writeContent(FreeboardVO freeboardVO) {



    }


//    public ArrayList<Map<String,Object>> getFreeboardList(int page_num) throws Exception {
//
//        ArrayList<Map<String, Object>> result = new ArrayList<>();
//
//        ArrayList<FreeboardVO> freeboardlist = freeboardMapper.getList(page_num);
//
//        for(FreeboardVO freeboardVO : freeboardlist){
//
//            Map<String , Object> map = new Map<String, Object>();
//
//            int userVO = freeboardVO.getUser_no();
//
//            UserVO uservo =  userDao.selectByNo();
//
//            map.put("userVO",uservo);
//            map.put("freeboardVO", )
//
//        }
//
//        return freeboardMapper.getList(page_num);
//    }
//

}
