package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
/**
 * 前端控制器
 * @author root
 *
 */
@SuppressWarnings("serial")
public class ClientServlet extends HttpServlet {
       
	private CustomerService customerService = new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1.解决乱码问题
				request.setCharacterEncoding("UTF-8");//post乱码 get乱码解决不了
				response.setContentType("text/html;charset=UTF-8");//响应结果没有乱码
				
				// 2.用一个参数op代表用户的操作类型
				String op = request.getParameter("op");
				
				// 3.判断用户的操作类型
				if("login".equals(op)){
					//登录
					login(request,response);
				}
			}
			
			//登录
			private void login(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
				
				//1.获取用户名，密码两个框的值
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//2.调用业务逻辑代码
				Customer customer = customerService.login(username,password);
				
				//3.根据查询的结果，判断用户登录是否成功
				if(customer != null){
					//4.1如果成功，将用户信息保存到session中
						request.getSession().setAttribute("user", customer);
					//4.2跳转到显示商品列表页面
						response.sendRedirect(request.getContextPath() + "/product_list.jsp");
				}
				else{ //5. 如果失败了,
					response.getWriter().write("对不起，登录失败，请重新登录！");
					response.setHeader("Refresh","2;URL=" + request.getContextPath() + "/login.jsp");
				}
			}

}
