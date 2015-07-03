<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="pagination">
	<ul><li>当前${page.pageNo }页/共${page.totalPage  }页</li>
		<li class="nextpage"><a href="${page.url }&pageNo=1">首页
				&lt;&lt;</a></li>
		<li class="nextpage"><a href="${page.url }&pageNo=${page.prep}">上一页
				&lt;&lt;</a></li>
		<li class="nextpage"><a href="${page.url }&pageNo=${page.nextp}">下一页&gt;&gt;</a>
		<li class="nextpage"><a	href="${page.url }&pageNo=${page.totalPage}">尾页 &lt;&lt;</a></li>
		
	</ul>
</div>