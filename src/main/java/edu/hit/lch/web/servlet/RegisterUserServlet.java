package edu.hit.lch.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hit.lch.domain.ResultInfo;
import edu.hit.lch.domain.User;
import edu.hit.lch.service.UserService;
import edu.hit.lch.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerUserServlet")

public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // 获取数据
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        UserService userService = new UserServiceImpl();
        // 调用service 完成注册逻辑
        boolean flag = userService.register(user);
        ResultInfo resultInfo = new ResultInfo();
        if(flag) {
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }

        // 将提示信息转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        // 设置响应头
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
