<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr{
		text-align: center;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
function query(){
	window.location.href="queryAll";
}

function addTr() {
    var datatr_counts = $(".tbd").children("tr.datatr").length;
    datatr_counts++;
    var addtrhtml = '<tr class="datatr">\n' +
        '<td class="ordertd">' + datatr_counts + '</td>' +
        '<td></td>' +
        '<td><input type="text" value=""  size="3"></td>' +
        '<td><input type="text" value=""  size="3"></td>' +
        '<td><input type="text" value=""  size="3"></td>' +
        '<td><a href="javascript:void(0)" onclick="save(this)">保存</a>&nbsp;<a href="javascript:void(0)" onclick="removeTr(this)">取消</a></td>' +
        '  </tr> ';
    $(".tbd").append(addtrhtml);


}

function removeTr(obj) {
    var current = $(obj).parent().parent();
 	
    current.remove();
}
	function save(obj){
		var username=$(obj).parent().parent().children().eq(2).children().val(); 
		var department=$(obj).parent().parent().children().eq(3).children().val(); 
		var income=$(obj).parent().parent().children().eq(4).children().val(); 
		var data={"username":username,"department":department,"income":income};
		$.ajax({
			type:"post",
			url:"addAdmin",
			data:data,
			success:function(datamsg){
				$(obj).parent().parent().html('<td>'+datamsg+'</td>' +
				        '<td><input type="checkbox"  class="box" value='+datamsg+'></td>' +
				        '<td>'+username+'</td>' +
				        '<td>'+department+'</td>' +
				        '<td>'+income+'</td>' +
				        '<td><input type="button" value="修改" onclick="update(this)"></td>'); 
			},
		});
		
	}
	
	function update(obj){
		 var current = $(obj).parent().parent();
		 var index=current.children().eq(0).text(); 
		 var id=current.children().eq(1).children().val(); 
		 var username=current.children().eq(2).text(); 
		 var department=current.children().eq(3).text(); 
		 var income=current.children().eq(4).text(); 
		
	 
		   
		    var updatehtml = '<td >' + index + '</td>' +
		        '<td>'+id+'</td>' +
		        '<td><input type="text" value="' + username + '"  size="3"></td>' +
		        '<td><input type="text" value="'+department+'"  size="3"></td>' +
		        '<td><input type="text" value="'+income+'"  size="3"></td>' +
		        '<td><a href="" onclick="updatesave(this)">保存</a>&nbsp;<a href="" onclick="history.go(0)">取消</a></td>' ;
		      
		        current.html(updatehtml); 
	}
	
	function updatesave(obj){

		var index=$(obj).parent().parent().children().eq(0).text(); 
		var id=$(obj).parent().parent().children().eq(1).text(); 
		var username=$(obj).parent().parent().children().eq(2).children().val(); 
		var department=$(obj).parent().parent().children().eq(3).children().val(); 
		var income=$(obj).parent().parent().children().eq(4).children().val(); 
	  	var data={"admin.id":id,"admin.username":username,"admin.department":department,"admin.income":income}; 
		$.ajax({
			type:"post",
			url:"updateAdmin",
			data:data,
			success:function(datamsg){
			 	if (datamsg==1) {
				$(obj).parent().parent().html('<td>'+index+'</td>' +
				        '<td><input type="checkbox"  class="box" value="'+id+'" ></td>' +
				        '<td>'+username+'</td>' +
				        '<td>'+department+'</td>' +
				        '<td>'+income+'</td>' +
				        '<td><input type="button" value="修改" onclick="update(this)"></td>'); 
				}else{
					alert(datamsg);
	
				}  
			},
		}); 
	}
	
	function dels(){
		var list=[];
		var boxs=$(".box");
		for (var i = 0; i < boxs.length; i++) {
			if (boxs[i].checked==true) {
				list[i]=boxs[i].value;
				
			}
		}

		var data={box:list};
	 	$.ajax({
			type:"post",
			url:"delAdmin",
			data:data,
			traditional: true,
			success:function(datamsg){
				alert(datamsg);
				window.location.href="queryAll";
				
			},
			
		}); 
	}
	
	function qx(){
		var boxs=$(".box");
		for (var i = 0; i < boxs.length; i++) {
			boxs[i].checked=true;
		}
	}
	
	function fx(){
		var boxs=$(".box");
		for (var i = 0; i < boxs.length; i++) {
			boxs[i].checked=!boxs[i].checked;
		}
	}
	
	function qbx(){
		var boxs=$(".box");
		for (var i = 0; i < boxs.length; i++) {
			boxs[i].checked=false;
		}
	}
	
	
	function showMain2(context){
		var value=$("#value").val();
		var data={s:$("#form1").serialize(),value:value};
	   	$.ajax({
		    type: 'post',
		    url: context,
		    data: data,
		    success:function(datamsg){
		    	$("#form1").html(datamsg);
	   		}
		});
		    
	}	
</script>
</head>
<body>
<form action=""  method="post" id="form1">

	<table>
		<tr>
			<td colspan="5">模糊查询</td>
			
		</tr>
		
		<tr>
			<td>序号</td>
			<td>多选框</td>
			<td>用户名</td>
			<td>部门</td>
			<td>收入</td>
			<td>操作</td>
		
		</tr>
	<c:forEach var="u" items="${list }" varStatus="i">
		<tr>
			<td>${i.index+1 }</td>
			<td>
			<input type="checkbox"  class="box" value="${u.id }" >
			</td>
			<td>${u.username }</td>
			<td>${u.department }</td>
			<td>${u.income }</td>
			<td><input type="button" value="修改" onclick="update(this)"></td>
		</tr>
	</c:forEach>
	<tbody class="tbd">
	</tbody>
		<tr>
			<td colspan="5">
				<input type="button" value="查询" onclick="query()">
				<input type="button" value="添加一行" onclick="addTr()" >
				<input type="button" value="全选" onclick="qx()">
				<input type="button" value="反选" onclick="fx()">
				<input type="button" value="全不选" onclick="qbx()">
				<input type="button" value="批量删除" onclick="dels()">
			</td>
		</tr>
	</table>
	

 <c:choose>
 	<c:when test="${pages<=10 }">
 		<c:set var="start" value="1"></c:set>
 	    <c:set var="end" value="${pages }"></c:set>
 	</c:when>
 	<c:otherwise>
 		<c:choose >
 			<c:when test="${pageIndex<=5 }">
 				<c:set var="start" value="1"></c:set>
 				<c:set var="end" value="10"></c:set>
 			</c:when>
 			<c:when test="${pageIndex>=(pages-4) }">
 				<c:set var="start" value="${pages-9 }"></c:set>
 				<c:set var="end" value="${pages }"></c:set>
 			</c:when>
 			<c:otherwise>
 				<c:set var="start" value="${pageIndex-4 }"></c:set>
 				<c:set var="end" value="${pageIndex+5 }"></c:set>
 			</c:otherwise>
 		</c:choose>
 	</c:otherwise>
 </c:choose>       
<c:if test="${start<1 }">
	<c:set var="start" value="1"></c:set>
</c:if>
    	<div>当前显示第${pageIndex }/${pages }页</div>
       
       <a href="javascript:showMain2('queryAll?pageIndex=1')" ><span >首页</span></a>
       <a href="javascript:showMain2('queryAll?pageIndex=${pageIndex-1}')" ><span >上一页</span></a>
        <c:forEach var="pageIndex" begin="${start}" end="${end }" step="1">
       <a href="javascript:showMain2('queryAll?pageIndex=${pageIndex}')" >${pageIndex }</a>
        </c:forEach>
       <a href="javascript:showMain2('queryAll?pageIndex=${pageIndex+1}')" ><span >下一页</span></a>
       <a href="javascript:showMain2('queryAll?pageIndex=${pages}')" ><span >尾页</span></a>
       
 
</form>

</body>
</html>