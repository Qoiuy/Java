package web.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		this.doPost(request,response);
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
				}else if("logout".equals(op)){
					//注销
					logout(request,response);
				}else if("modifyUserinfo".equals(op)){
					//修改用户信息
					modifyUserinfo(request,response);
				}
				
				
			}
			
			private void modifyUserinfo(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException{
			//1获取文本框的取值
				String password =request.getParameter("password");
				String sex =request.getParameter("sex");
				String telephone =request.getParameter("telephone");
				String id =request.getParameter("id");
			//2更新对象中的属性值
				HttpSession session = request.getSession();
				Customer customer = (Customer)session.getAttribute("user");
				customer.setPassword(password);
				customer.setSex(sex);
				customer.setTelephone(telephone);
			//3调用业务方法，实现更新操作
				customerService.update(customer);
			//4将session中用户信息更新
				session.setAttribute("user", customer);//没有必要
			//5跳转到更新成功页面
				request.getRequestDispatcher("/modifyUserInfoSuccess.jsp").forward(request, response);//转发
				
			} 

			private void logout(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
			//1. 将session域中的用户信息清除
				request.getSession().removeAttribute("user");
				response.sendRedirect(request.getContextPath());
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
