package cn.itcast.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证码
 * @author wangli
 *
 */
public class CaptchaCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int height=25,width=120;
		//1.得到一个图像缓冲区  BufferedImage
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2.得到一只画笔   Graphics
		Graphics g = bimage.getGraphics();
		//3.画矩形，填背景色   画干扰线条   画字符串
		//3.1画矩形框时，可以先调画笔颜色
		g.setColor(Color.BLUE);//先调画笔颜色
		g.drawRect(0, 0 , width, height);
		
		//3.2填充背景
		g.setColor(Color.YELLOW);//调画笔颜色
		g.fillRect(1,1, width-2, height-2);
		
		//3.3画干扰线条
		g.setColor(Color.GRAY);//调画笔颜色为灰色
		Random random = new Random();//因为要画随机线条，引入随机数
		for (int i = 0; i < 20; i++) {
			//random.nextInt(width)因为要确定x坐标不能超范围
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}
		
		//3.4画随机字符串  先要控制字符颜色，及字体大小
		g.setColor(Color.RED);
		// Font.BOLD|Font.ITALIC 两种类型做迭加
		g.setFont(new Font("黑体",Font.BOLD|Font.ITALIC,20));
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i < 4; i++) {
			
			String str = random.nextInt(9)+"";
			sb.append(str);
			g.drawString(str,20+(i*20), 20);
		}
		request.getSession().setAttribute("code", sb.toString());
		//4.将画好的缓冲区的图像写入到浏览器中
		//4.1服务器要通过响应消息头，告知客户端，给它写的内容是一个一幅图片
		response.setHeader("Content-Type", "image/jpeg");
		
		//为了更好的让验证码，在客户端不要缓存，设置响应头，告诉客户端不要缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		
		//4.2 写数据到浏览器   ImageIO
		ImageIO.write(bimage, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
