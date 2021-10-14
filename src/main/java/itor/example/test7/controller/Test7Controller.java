package itor.example.test7.controller;


import itor.example.test7.dao.PersonCategoryDao;
import itor.example.test7.dao.UserLoginDao;


import itor.example.test7.service.FreeboardService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller

public class Test7Controller {

    @Autowired
    protected UserLoginDao userLoginDao;

    @RequestMapping("/test7" )
    public String Test7(Model model, HttpServletRequest request){

        List<PersonVO> userList = new ArrayList<>();


        model.addAttribute("userList", userList);

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        model.addAttribute("name", name);
        model.addAttribute("age",age);



        return "test7";

    }
    @RequestMapping("/test8")
    public String test8(){






        return "test8";
    }

    @Autowired
     protected PersonCategoryDao personCategoryDao;

    @RequestMapping(value="/test9" , method= RequestMethod.POST)
    public String test9(String person_name , String person_gender , String person_addr ,Model model){




        model.addAttribute("person_name" , person_name);
        model.addAttribute("person_gender" , person_gender);
        model.addAttribute("person_addr" , person_addr);

        System.out.println(model);





        try {
            log.debug("OK1");
            PersonVO vo = new PersonVO();
            vo.setPersonName(person_name);
            vo.setPersonGender(person_gender);
            vo.setPersonAddr(person_addr);



            log.debug("OK2");

            personCategoryDao.insertPersonCategory(vo);
        }catch(Exception e){
            e.printStackTrace();
            log.debug("OK3");
        }

        log.debug("OK4");

        return "test9";
    }

    @RequestMapping(value = "UserLoginPage")
    public String UserLoginPage(){

        return "UserLoginPage";
    }

    protected Log log = LogFactory.getLog(Test7Controller.class);
    @RequestMapping(value="UserLoginProcess")
    public String UserLoginProcess(UserVO userVO , HttpSession session) {



            UserVO sessionUser = userLoginDao.login(userVO);
            log.info("test");
            if (sessionUser != null) {
                log.info("test1");
                session.setAttribute("sessionUser", sessionUser);
                log.info("접속");



                // HttpServletResponse response
                // redirect ( "/UserFreeboard" ) 강제로 URL 변경
                // response.sendRedirect("/UserFreeboard");

                return "redirect:UserFreeboard";
            } else {
                // redirect ( 이전 페이지 );
                return "UserLoginPage";
            }




    }


    @Autowired
    private FreeboardService freeboardService;


    @RequestMapping(value = "UserFreeboard")
    public String UserFreeboard(Model model, HttpSession session) {

        //ArrayList<HashMap<String,Object>> freeboardList = freeboardService.getFreeboard();
        // model.addAttribute("List",freeboardList);


        UserVO sessionUser = (UserVO) session.getAttribute("sessionUser");

        List<ResultVO> freeboardList = freeboardService.getFreeboard();
        log.info(freeboardList);

        model.addAttribute("sessionUser" ,sessionUser);
        model.addAttribute("List",freeboardList);

//        ArrayList<Map<String,Object>> freeboardList = freeboardService.getFreeboardList(page_num);
//
//        int count = freeboardService.getContentCount();
//        int totalPageCount = (int)Math.ceil(count/10.0);
//
//        int currentPage = page_num;
//
//        int beginPage = ((currentPage-1)/5) * 5 + 1 ;
//        int endPage = ((currentPage=1)/5 + 1) * (5);
//
//        if(endPage > totalPageCount){
//            endPage = totalPageCount;
//        }
//
//        model.addAttribute("beginPage", beginPage);
//        model.addAttribute("endPage", endPage);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("contentCount", count);
//        model.addAttribute("freeboardlist", freeboardList);

        return "UserFreeboard";

    }

    @RequestMapping("writePage")
    public String writePage(){

        return "writePage";
    }
    @RequestMapping("writeProcess")
    public String writeProcess(HttpSession session, FreeboardVO freeboardVO){

        UserVO sessionUser = (UserVO) session.getAttribute("sessionUser");

        int sessionNo = sessionUser.getUser_no();

        freeboardVO.setUser_no(sessionNo);

        freeboardService.writeContent(freeboardVO);

        return "redirect:UserFreeboard";
    }




}
