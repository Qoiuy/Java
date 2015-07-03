package web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import domain.Book;
import domain.Category;
import domain.Customer;
import domain.Orders;
import domain.OrdersItem;
import service.BookService;
import service.CategoryService;
import service.CustomerService;
import service.OrdersService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.OrdersServiceImpl;
import utils.IDGenerator;
import utils.PageBean;
import utils.PaymentUtil;
import utils.PropertiesUtil;
import web.form.Cart;
import web.form.CartItem;
/**
 * 前端控制器
 * @author root
 *
 */
@SuppressWarnings("serial")
public class ClientServlet extends HttpServlet {
       
	private CustomerService customerService = new CustomerServiceImpl();
	private CategoryService categoryservice = new CategoryServiceImpl();
	private BookService bookService = new BookServiceImpl();
	private OrdersService ordersService = new OrdersServiceImpl();
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
				}else if("register".equals(op)){
					//注册
					register(request,response);
				}
				else if("findAllCategories".equals(op)){
					//查询分类列表
					findAllCategories(request,response);
				}
				else if("findBooksByCategoryID".equals(op)){
					//分页查询，指定分类下的记录
					findBooksByCategoryID(request,response);
				}
				else if("findBookDetailById".equals(op)){
					//根据图书编号 查看详情
					findBookDetailById(request,response);
				}
				else if("buyBook".equals(op)){
					//购买
					buyBook(request,response);
				}
				else if("deleteBookInCart".equals(op)){
					//购物车中删除一个条目
					deleteBookInCart(request,response);
				}else if("generatorOrders".equals(op)){
					//生成订单
					generatorOrders(request,response);
				}
				else if("payMoney".equals(op)){
					//付款 组织数据发给第三方
					payMoney(request,response);
				}
				else if("queryOrders".equals(op)){
					//查询我的订单
					queryOrders(request,response);
				}
				
			}
	//查询我的订单
	private void queryOrders(HttpServletRequest request,HttpServletResponse response) 
	 		throws ServletException, IOException{  //1.得到当前登录的用户信息
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        if(customer==null){
                //说明没有登录
                response.getWriter().write("对不起，您没有登录，请先登录，再查询我的订单！");
                response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
                return ;
        }
        //2.调用业务，查询当前用户的订单信息
        List<Orders> list = ordersService.findOrdersByCustomerID(customer.getId());
        //3.将订单信息放入request域中
        request.setAttribute("list",list);
        request.setAttribute("count",list.size());
        //4.转发orderlist.jsp
        request.getRequestDispatcher("/orderlist.jsp").forward(request, response);

				
	}

			//付款 组织数据发给第三方
			private void payMoney(HttpServletRequest request,HttpServletResponse response) 
			 		throws ServletException, IOException{
				 //1.接收参数
                String ordernum = request.getParameter("oid");
                String money = request.getParameter("money");
                String pd_FrpId = request.getParameter("yh");//选择的银行

                //2.将所有的参数保存到request域中   
                String p0_Cmd = "Buy";
                String p1_MerId = PropertiesUtil.getValue("p1_MerId");
                String p2_Order = ordernum;
                String p3_Amt = money;
                String p4_Cur = "CNY";
                String p5_Pid = "";
                String p6_Pcat = "";
                String p7_Pdesc = "";
                String p8_Url = PropertiesUtil.getValue("responseURL");//告知第三方在支付完成后，交给网站的哪个页面
                String p9_SAF = "1";
                String pa_MP = "";
                String pr_NeedResponse = "1";
                String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, PropertiesUtil.getValue("keyValue"));

                request.setAttribute("p0_Cmd",p0_Cmd );
                request.setAttribute("p1_MerId",p1_MerId );
                request.setAttribute("p2_Order",p2_Order );
                request.setAttribute("p3_Amt", p3_Amt);
                request.setAttribute("p4_Cur",p4_Cur );
                request.setAttribute("p5_Pid",p5_Pid );
                request.setAttribute("p6_Pcat",p6_Pcat );
                request.setAttribute("p7_Pdesc",p7_Pdesc );
                request.setAttribute("p8_Url",p8_Url );
                request.setAttribute("p9_SAF",p9_SAF );
                request.setAttribute("pa_MP",pa_MP );
                request.setAttribute("pd_FrpId",pd_FrpId );
                request.setAttribute("pr_NeedResponse",pr_NeedResponse );
                request.setAttribute("hmac",hmac );

                /**
                 *  转发sure.jsp
                 *  <form method="post"   action="https://www.yeepay.com/app-merchant-proxy/node">
                 *   <input type="hiddent" name="p0_Cmd" value=${p0_Cmd}"/>
                 *   
                 *   
                 *   </form>
                 * 
                 */

                request.getRequestDispatcher("/sure.jsp").forward(request, response);
		
	}

			private void generatorOrders(HttpServletRequest request,HttpServletResponse response) 
			 		throws ServletException, IOException{
				   //1. 判断 用户是否登录过了
                HttpSession session = request.getSession();
                Customer customer = (Customer) session.getAttribute("user");
                if(customer==null){
                        //说明没有登录
                        response.getWriter().write("对不起，您没有登录，请先登录，再进行结算！");
                        response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
                        return ;
                }
                //2.生成订单(Cart--------------------Orders表              CartItem------------>ordersItem表)
                Cart cart = (Cart) session.getAttribute("cart");
                 //2.1Cart--------------------Orders表   
                  Orders orders = new Orders();
                  orders.setId(IDGenerator.genID());
                  orders.setNum(cart.getTotalNum());//总数量
                  orders.setPrice((float)cart.getTotalPrice());//总价格
                  orders.setOrdernum(IDGenerator.genCode());//流水号
                  orders.setStatus(0);//0代表未付款   1已付款   2已发货
                  orders.setC(customer);//代表下单人
                  // CartItem------------>ordersItem表
                  Map<String,CartItem> map = cart.getMap();
                  List<OrdersItem> list = new ArrayList<OrdersItem>();//订单明细列表
                  for(Map.Entry<String,CartItem> entry :map.entrySet()){
                          CartItem ci =  entry.getValue();
                          OrdersItem oi = new OrdersItem();//生成订单明细对象
                          oi.setBook(ci.getBook());
                          oi.setId(IDGenerator.genID());
                          oi.setNum(oi.getNum());
                          oi.setPrice((float)ci.getPrice());

                          list.add(oi);//添加一个明细元素
                  }

                //3.设置订单与订单明细之间的关系 （一个订单中可以包含多个明细）
                orders.setItems(list);
                //4.级联保存（Hibernate中有）
                ordersService.addCascade(orders);

                session.removeAttribute("cart");//清空购物车
                //5.将订单对象存入request域中，转发到支付页面
                request.setAttribute("o", orders);
                request.getRequestDispatcher("/pay.jsp").forward(request, response);



			}

			//购物车中删除一个条目
			private void deleteBookInCart(HttpServletRequest request,HttpServletResponse response) 
			 		throws ServletException, IOException{
				  //1.获取参数id
                String id = request.getParameter("id");
                //2.在购物车中找到要删除的条目，并进行删除
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("cart");
                if(cart.getMap().containsKey(id)){
                        cart.getMap().remove(id);
                }
                //3.再跳到cart.jsp
                response.sendRedirect(request.getContextPath()+"/cart.jsp");

			}

			private void buyBook(HttpServletRequest request,HttpServletResponse response) 
			 		throws ServletException, IOException{
				   //1.获取要购买书籍的id
	                String id = request.getParameter("id");
	                //2.调用业务方法，得到这本书的对象
	                Book book = bookService.findBookById(id);
	                //3.将书籍加入购物车,购物车经典代码 
	                HttpSession session = request.getSession();
	                Cart cart = (Cart) session.getAttribute("cart");
	                if(cart==null){
	                        //第一次
	                        cart = new Cart();
	                        session.setAttribute("cart", cart);
	                }
	                cart.addBook2Cart(book, 1);
	
	                //5.添加到购物车完成跳到显示购物车中商品的页面  cart.jsp
	                response.sendRedirect(request.getContextPath()+"/cart.jsp");//重定向

			}

			//根据图书编号，查看详情
			private void findBookDetailById(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException{
				  //1.先得到参数id
                String id = request.getParameter("id");
                //2.根据id,得到一个Book对象
                Book book = bookService.findBookById(id);
                //3.将这个Book对象，保存到request域中
                request.setAttribute("book", book);
                //4.转发product_info.jsp
                request.getRequestDispatcher("/product_info.jsp").forward(request,response);

	}

			//分页查询，指定分类下的记录
			private void findBooksByCategoryID(HttpServletRequest request,HttpServletResponse response)
					throws ServletException, IOException{
		                //1.获取参数id
		                String id = request.getParameter("id");
		                //2.生成分页组件对象
		                PageBean page = new PageBean();
		                //3.设置新的当前页
		                String pageNo = request.getParameter("pageNo");//当点击页面上的分页条时，所传递的参数
		                if(pageNo!=null && pageNo.trim().length()>0){
		                        page.setPageNo(Integer.parseInt(pageNo));
		                }
		                //4.调用业务方法，实现分页功能 
		                bookService.findBooksByCategoryIdAndPage(page, id);
		                //5.设置新的url地址
		                page.setUrl(request.getContextPath()+"/servlet/ClientServlet?op=findBooksByCategoryID&id="+id);
		                //6.将分页组件对象放入request域中
		                request.setAttribute("page", page);
		                //7.转发
		                request.getRequestDispatcher("/product_list.jsp").forward(request, response);
					}
			

			//查询分类列表
			private void findAllCategories(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException{
				//1调用业务方法，实现查询分类列表
				List<Category> list = categoryservice.findAll();
				//2将查询结果放入request域中
				request.setAttribute("categories", list);
				//3转发index2.jsp
				//response.sendRedirect("/OnClass/index2.jsp");//值放在request域中不转发不行
			    request.getRequestDispatcher("/index2.jsp").forward(request, response);
	}

			//注册
			private void register(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException{
				Customer  customer= new Customer();
			//1获取每个文本框的值  beanUtils框架实现封装 commons-beanutils.jar commmons-logging-xx.jar
				try {
					BeanUtils.populate(customer, request.getParameterMap());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			//2校验
			//3判断用户输入验证码是否正确
				String inputcode = request.getParameter("captchaImage");
				String code = (String)request.getSession().getAttribute("code");
				if (inputcode.equals(code)){
					
					//4调用业务方法，实现添加功能				
						//对于没有赋值的属性进行手动赋值
					customer.setId(IDGenerator.genID());
					customer.setActived(0);
					customer.setId(IDGenerator.genCode());
					customer.setRole(0);
					customerService.regist(customer);
					//5跳转到registersuccess.jsp
					response.sendRedirect(request.getContextPath() + "/registersuccess.jsp");
				}else {
					//6验证码输入有误
					response.getWriter().write("对不起，验证码输入有误！请重试");
					response.setHeader("Refresh","2;URL="+request.getContextPath()+"/register.jsp");
				}
			}

			private void modifyUserinfo(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException{
			//1获取文本框的取值
				String password =request.getParameter("password");
				String sex = request.getParameter("sex");
				String telephone = request.getParameter("telephone");
				String id = request.getParameter("id");
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
				response.sendRedirect("/OnClass/modifyUserInfoSuccess.jsp");
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
