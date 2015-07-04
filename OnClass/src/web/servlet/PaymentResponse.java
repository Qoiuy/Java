package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrdersService;
import service.impl.OrdersServiceImpl;
import utils.PaymentUtil;
import utils.PropertiesUtil;
/**
 * 接收第三方响应的结果 
 * @author wangli
 *
 */
public class PaymentResponse extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd= request.getParameter("r0_Cmd");
		String r1_Code= request.getParameter("r1_Code");//1表示支付成功
		String r2_TrxId= request.getParameter("r2_TrxId");
		String r3_Amt= request.getParameter("r3_Amt");
		String r4_Cur= request.getParameter("r4_Cur");
		String r5_Pid= request.getParameter("r5_Pid");
		String r6_Order= request.getParameter("r6_Order");//订单号（是指id,还是流水号ordernum）
		String r7_Uid= request.getParameter("r7_Uid");
		String r8_MP= request.getParameter("r8_MP");
		String r9_BType= request.getParameter("r9_BType");//如果是2是点对点
		String hmac = request.getParameter("hmac");

		boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, PropertiesUtil.getValue("keyValue"));
		
		//2.判断第三方响应给网站的结果是否存在数据被篡改？？？？   true代表没有被篡改
		if(!b){
			//被 篡改
			response.getWriter().write("对不起，支付失败，数据可能被篡改，请联系网站的客服：400-5566-7788");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/index.jsp");
			return;
		}
		
		//3.判断支付是否成功
		if("1".equals(r1_Code)){
			//说明付款成功
			//4.修改订单状态 
			OrdersService ordersService = new OrdersServiceImpl();
			ordersService.updateStatusByOrderNum(r6_Order);
			response.sendRedirect(request.getContextPath()+"/paysuccess.jsp");
		}else{
			//说明付款失败
			response.getWriter().write("对不起，支付失败，您的余额可能不足，请重试");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
