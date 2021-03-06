package cn.cc.servlet;

import cn.cc.domain.User;
import cn.cc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取传输过来的对象id
        String id = request.getParameter("id");


        //查询用户对象
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.find(id);

        //查询出来之后 转发到修改界面并展示数据
        request.setAttribute("user", user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
