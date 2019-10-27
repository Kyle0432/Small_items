<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工列表页面</title>
    <%
       pageContext.setAttribute("APP_PATH",request.getContextPath());
     %>
    <!-- 
       Web路径:
                不以/开始的相对路径,找资源,以当前资源的路径为基准，经常容易出问题
                以/开始的相对路径,找资源,以服务的路径为基准(http://localhost:8080),需要加上项目名
       http://localhost:8080/crud
     -->
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/static/scripts/jquery-1.12.3.js"></script>
    <!-- 引入BootStrap样式 -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入js -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
         <!-- 员工修改的模态框 -->
		<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
		      </div>
		      <div class="modal-body">
					<form class="form-horizontal">
					  <div class="form-group">
					    <label class="col-sm-2 control-label">empName</label>
					    <div class="col-sm-10">
					      <p class="form-control-static" id="empName_update_static"></p>
					    </div>
					  </div>
					  
					  <div class="form-group">
					      <label class="col-sm-2 control-label">email</label>
					    <div class="col-sm-10">
					      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@Kyle.com">
					      <span id="" class="help-block"></span>
					    </div>
					  </div>
					  
					  <div class="form-group">
					      <label class="col-sm-2 control-label">gender</label>
					    <div class="col-sm-10">
					     <label class="radio-inline">
							  <input type="radio" name="gender" id="gender1_update_input" value="F" checked="checked"> 男
						 </label>
						 <label class="radio-inline">
							  <input type="radio" name="gender" id="gender2_update_input" value="M"> 女
						 </label>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">deptName</label>
					    <div class="col-sm-4">
					        <!-- 部门提交部门id即可 -->
                           <select class="form-control" name="dId" id="dept_update_select"></select>
					    </div>
					  </div>
					</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
		      </div>
		    </div>
		  </div>
		</div>
  
       <!-- 员工添加的模态框 -->
		<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
		      </div>
		      <div class="modal-body">
					<form class="form-horizontal">
					
					  <div class="form-group">
					    <label class="col-sm-2 control-label">empName</label>
					    <div class="col-sm-10">
					      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
					      <span id="" class="help-block"></span>
					    </div>
					  </div>
					  
					  <div class="form-group">
					      <label class="col-sm-2 control-label">email</label>
					    <div class="col-sm-10">
					      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@Kyle.com">
					      <span id="" class="help-block"></span>
					    </div>
					  </div>
					  
					  <div class="form-group">
					      <label class="col-sm-2 control-label">gender</label>
					    <div class="col-sm-10">
					     <label class="radio-inline">
							  <input type="radio" name="gender" id="gender1_add_input" value="F" checked="checked"> 男
						 </label>
						 <label class="radio-inline">
							  <input type="radio" name="gender" id="gender2_add_input" value="M"> 女
						 </label>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">deptName</label>
					    <div class="col-sm-4">
					        <!-- 部门提交部门id即可 -->
                           <select class="form-control" name="dId" id="dept_add_select"></select>
					    </div>
					  </div>
					</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
		      </div>
		    </div>
		  </div>
		</div>
  
        <!-- Bootstrap搭建显示页面 -->
        <div class="conatiner">
             <!--①标题 -->
             <div class="row">
                  <div class="col-md-12">
                      <h1>SSM_CRUD</h1>
                  </div>
             </div>
             <!-- ②按钮 -->
             <div class="row">
                  <div class="col-md-4 col-md-offset-8">
                       <button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
                       <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
                  </div>
             </div>
             <!-- ③显示表格数据 -->
             <div class="row">
                 <div class="col-md-12">
                      <table class="table table-hover" id="emps_table">
                        <thead>
	                          <tr>
	                             <th>
	                                <input type="checkbox" id="check_all"/>
	                             </th>
	                             <th>#</th>
	                             <th>lastName</th>
	                             <th>email</th>
	                             <th>gender</th>
	                             <th>deptName</th>
	                             <th>操作</th>
	                          </tr>
                         </thead> 
                         <tbody></tbody>
                      </table>
                 </div>
             </div>
             <!-- ④显示分页信息栏 -->
             <div class="row">
               <!-- 分页文字信息 -->
               <div class="col-md-6" id="page_info_area"></div>
          	   <!-- 分页条信息 -->
			   <div class="col-md-6" id="page_nva_area"></div>
             </div>
        </div>
        <script type="text/javascript">
        
        //保存总记录数
        var totalRecord,currentPage;
        
         //1,页面加载完成以后,直接去发送一个ajax请求,要到分页数据
        $(function(){
           //去首页
           to_page(1);
        });
        
        //发送ajax请求给数据库
        function to_page(pn){
        $.ajax({
              url:"${APP_PATH}/emps",
              //表示带的属性
              data:"pn="+pn,
              //请求方式
              type:"GET",
              //请求成功后拿到结果
              success:function(result){
                // console.log(result);
                //1.解析并显示员工信息
                build_emps_table(result);
                //2.解析并显示分页信息
                build_page_info(result);
                //3,解析显示分页条
                bulid_page_nav(result);
              }
           });
        }
        
        function build_emps_table(result){
           //表格进行清空
           $("#emps_table tbody").empty();
            var emps = result.extend.PageInfo.list;
            $.each(emps,function(index,item){
                var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>"); 
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var emailTd = $("<td></td>").append(item.email);
                var genderTd = $("<td></td>").append(item.gender== "M"?"女":"男");
                var deptNameTd = $("<td></td>").append(item.department.deptName);
                /* <button class="btn btn-primary btn-group-sm">
                  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                                新增
                  </button>
                  <button class="btn btn-danger btn-group-sm">
                  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                               删除
                   </button> */
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-group-sm edit_btn")
                              .append($("<span></span>")).addClass("glyphicon glyphicon-pencil").append("编辑");
               //为编辑按钮添加一个自定义的属性,来表示当前员工id
               editBtn.attr("edit-id",item.empId);              
                var delBtn = $("<button></button>").addClass("btn btn-danger btn-group-sm delete_btn")
                              .append($("<span></span>")).addClass("glyphicon glyphicon-trash").append("删除");
               //为删除按钮添加一个自定义的属性,来表示当前员工id
               delBtn.attr("del-id",item.empId);
                var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
                $("<tr></tr>").append(checkBoxTd).append(empIdTd)
                .append(empNameTd)
                .append(emailTd)
                .append(genderTd)
                .append(deptNameTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");
            });
        }
        
        //解析显示分页信息
        function build_page_info(result){
           //清空分页信息
           $("#page_info_area").empty();
           $("#page_info_area").append("当前"+result.extend.PageInfo.pageNum
           +"第页,总共"+result.extend.PageInfo.pages +"页,总共"
           +result.extend.PageInfo.total +"条记录");
           //把总记录数赋值给totalRecord
           totalRecord = result.extend.PageInfo.total;
           currentPage = result.extend.PageInfo.pageNum;
        }
        //解析显示分页条
        function bulid_page_nav(result){
          //清空分页条
          $("#page_nva_area").empty();
           var  ul = $("<ul></ul>").addClass("pagination");
           //构建元素
           var 	firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
           var  prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
           if(result.extend.PageInfo.hasPreviousPage == false){
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
           }else{
           //为首页元素添加点击翻页事件
           firstPageLi.click(function(){
               to_page(1);
           });
           //为上页元素添加点击翻页事件
           prePageLi.click(function(){
              to_page(result.extend.PageInfo.pageNum-1);
           });
           }
           var  nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
           var  lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
          if(result.extend.PageInfo.hasNextPage == false){
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
           }else{
           //为下页元素添加点击翻页事件
           nextPageLi.click(function(){
             to_page(result.extend.PageInfo.pageNum+1);
           });
           //为末页元素添加点击翻页事件
           lastPageLi.click(function(){
             to_page(result.extend.PageInfo.total);
           });
           }
           //构建首页和前一页的提示
           ul.append(firstPageLi).append(prePageLi);
           //1.2.3遍历给ul中添加页码提示
           $.each(result.extend.PageInfo.navigatepageNums,function(index,item){
               var numLi = $("<li></li>").append($("<a></a>").append(item)); 
               if(result.extend.PageInfo.pageNum == item){
                   numLi.addClass("active");
               }
               //绑定单据事件
               numLi.click(function(){
                  to_page(item);
               });
               ul.append(numLi);
           });
           //添加下一页和末页的提示
           ul.append(nextPageLi).append(lastPageLi);
           
           //把ul加入nav元素中
           var navEle = $("<nav></nav>").append(ul);
           navEle.appendTo("#page_nva_area");
        }
        
        //清空表单样式及内容
        function reset_form(ele){
        //因为jQuery没有reset方法所以要用js的DOM原生去调用reset方法
           $(ele)[0].reset();
        //还应该清空表单样式,find("*")表示寻找所有元素标签
           $(ele).find("*").removeClass("has-error has-success");//文本框颜色样式
           $(ele).find(".help-block").text(""); //文本框内容样式
        }
            
            
 	        //点击新增按钮弹出模态框。
		$("#emp_add_modal_btn").click(function(){
		    //清除表单数据(表单完全重置(表单的数据,表单的样式))
		    reset_form("#empAddModal form");
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#empAddModal select");
			//弹出模态框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
           
           //查出所有的部门信息并显示在下拉列表中
           function getDepts(ele){
             //清空之前下拉列表的值
             $(ele).empty();
             //发送ajax请求,从数据库里查出部门信息,并显示到下拉列表中
             $.ajax({
                   url:"${APP_PATH}/depts",
                   type:"GET",
                   success:function(result){
                   //显示部门信息在下拉列表中
                   $.each(result.extend.depts,function(){
                    var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo(ele);
                   });
                  }
              });
           }
           
           //校验表单数据
           function validate_add_form(){
              //拿到要校验的数据
              var empName = $("#empName_add_input").val();
              var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
              
              if(!regName.test(empName)){
                 show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
                 //此时下面的就不在执行了
                 return false;
              }else{
                 show_validate_msg("#empName_add_input","success","");
              }
              
			
			  //邮箱格式进行校验
			  var email = $("#email_add_input").val();
			  var regemail =  /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			  if(!regemail.test(email)){
                  show_validate_msg("#email_add_input","error","邮箱格式不正确");
			      return false;
			  }else{
                  show_validate_msg("#email_add_input","success","");
			  }
			  return true;
		   }
           
             //显示校验结果的提示信息
             function show_validate_msg(ele,status,msg){
                 //清除当前元素的校验状态
                 $(ele).parent().removeClass("has-success has-error");
                 $(ele).next("span").text("");
                 if("success" == status){
                      //bootstrap校验把校验添加到控件父元素上
                      $(ele).parent().addClass("has-success");
                      //表示该文本框的下一个元素显示的内容
                      $(ele).next("span").text(msg);
                 }else if("error" == status){
                      $(ele).parent().addClass("has-error");
                      $(ele).next("span").text(msg);
                 }
             }
           
           //校验用户名是否可用
           $("#empName_add_input").change(function(){
                //发送ajax请求校验用户名是否可用
                //获取输入框里的empName
                var empName = this.value;
                $.ajax({
                    url:"${APP_PATH}/checkuser",
                    type:"POST",
                    //表示带的参数
                    data:"empName="+empName,//这种参数一般是用RequestParam里表示
                    success:function(result){
                       if(result.code == 100){
                       show_validate_msg("#empName_add_input","success","用户名可用");
                       //如果成功了就给$("#emp_save_btn")增加一个属性值,为了下面通过获取值来判断是否进行保存
                       $("#emp_save_btn").attr("ajax-va","success");
                       }else{
                       show_validate_msg("#empName_add_input","error",result.extend.va_msg);
                       $("#emp_save_btn").attr("ajax-va","fail");
                       }
                    }
                });
           });
           
           //模态框里填写表单的数据交给服务器保存
           $("#emp_save_btn").click(function(){
              //先对要提交给服务器的数据进行校验
              if(!validate_add_form()){
                  return false;
              }
              //判断之前的ajax用户名校验是否成功
              if($(this).attr("ajax-va") == "error"){
                  return false;
              }
              //发送ajax请求保存员工
              $.ajax({
                 url:"${APP_PATH}/emp",
                 type:"POST",
                 //通过序列化表单,就可以得到表单输入的数据,然后传给url映射的employee对象里面
                 data:$("#empAddModal form").serialize(),
                 success:function(result){//这里的function里面的值表示url映射那个方法的返回值的整体，例如:返回值是一个code,就可以result.code来调用
                   //此处进行的是后端JSR303校验
                   if(result.code == 100){
                   //当员工保存成功,还需做两个操作
                   //1,关闭模态框
                   $("#empAddModal").modal("hide");
                   //2,来到最后一页,显示保存的数据
                   //发送ajax请求显示最后一页数据即可
                   to_page(totalRecord);
                   }else{
	                   //显示校验失败信息
	                   //有哪个字段的错误信息就显示哪个字段的,undefined表示未定义
	                   if(undefined != result.extend.errorFields.email){
	                   //显示邮箱错误信息
	                   show_validate_msg("#email_add_input","error","邮箱格式不正确");
	                   }
	                   if(undefined != result.extend.errorFields.empName){
	                   //显示员工名字错误信息
	                   show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
	                   }
                   }
                 }
              });
           });
           
           //单个删除
           //这里绑定删除按钮和下面的修改按钮一样,都是动态的ajax发送请求之后就开始绑定它了,所以无效
           $(document).on("click",".delete_btn",function(){
              //1,弹出是否确认删除框
             //确认员工要删除的姓名
             var empName = $(this).parents("tr").find("td:eq(2)").text();
             //获取员工删除的id
             var empId = $(this).attr("del-id");
              if(confirm("确认删除["+empName+"]吗？")){
                 //确认,发送ajax请求进行删除操作
                 $.ajax({
                    url:"${APP_PATH}/emp/"+empId,
                    type:"DELETE",
                    success:function(result){
                      //删除成功后回到删除的本页
                      alert(result.msg);
                      to_page(currentPage);
                    }
                 });
              }
           });
           
           //1,我们是按钮创建之前就绑定了click,所有绑定不上
           //2,可以在创建按钮的时候绑定.  绑定点击.live()
           //jQuery新版没有live,使用on进行代替
           //document表示该文档,然后特指.edit_btn类
           $(document).on("click",".edit_btn",function(){
                //1,查出员工信息,显示员工信息
                getEmp($(this).attr("edit-id"));
                //2,查出部门信息,显示部门列表
                getDepts("#empUpdateModal select");
                //弹出模态框
                //把员工id传给模态框的更新按钮
			    $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
				$("#empUpdateModal").modal({
					backdrop:"static"
				});
           });
           
           function getEmp(id){
             $.ajax({
                 url:"${APP_PATH}/emp/"+id,
                 type:"GET",
                 success:function(result){
                     var empData = result.extend.emp;
                     $("#empName_update_static").text(empData.empName);
                     $("#email_update_input").val(empData.email);
                     $("#empUpdateModal input[name=gender]").val([empData.gender]);//这里[]表示单选按钮选择的意思
                     $("#empUpdateModal select").val([empData.dId]);//和上面意思类似
                 }
             });
           }
           
           //点击更新,更新员工信息
           $("#emp_update_btn").click(function(){
              //验证邮箱是否合法
              var email = $("#email_update_input").val();
			  var regemail =  /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			  if(!regemail.test(email)){
                  show_validate_msg("#email_update_input","error","邮箱格式不正确");
			      return false;
			  }else{
                  show_validate_msg("#email_update_input","success","");
			  }
               $.ajax({
                   url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
/*                 方法一:type:"POST",
                   data:$("#empUpdateModal form").serialize()+"&_method=PUT", */
                   
                   //方法二:但是在web.xml文件里面需要配置 HttpPutFormContentFilter
                   type:"PUT",
                   data:$("#empUpdateModal form").serialize(),
                   success:function(result){
                      //关闭对话框
                      $("#empUpdateModal").modal("hide");
                      //回到当前修改的页面
                      to_page(currentPage);
                   }
               });
           });
           
           
           
           //完成全选/全不选功能
           $("#check_all").click(function(){
              //attr获取checked是undefined;	
              //我们这些dom原生的属性:attr获取自定义的属性
              //prop修改和读取dom原生属性值
              //全选
              $(".check_item").prop("checked",$(this).prop("checked"));
           });
           
           //check_item
           $(document).on("click",".check_item",function(){
           //判断当前选择中的元素是否选满个
           var flag = $(".check_item:checked").length == $(".check_item").length;
           //返回的结果flag来指定check_all是是否为选中 
           $("#check_all").prop("checked",flag);
           });
           
           //点击全部删除,就批量删除
           $("#emp_delete_all_btn").click(function(){
               var empNames = "";
               var del_idstr= "";
               $.each($(".check_item:checked"),function(){
                 empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
                 //组装员工id字符串
                 del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
               });
           //去除empNames多余的逗号
           empNames = empNames.substring(0,empNames.length-1); 
           //去除删除的id多余的-  
           del_idstr = del_idstr.substring(0,empNames.length-1);
           if(confirm("确认删除["+empNames+"吗？]")){
              //发送ajax请求删除
              $.ajax({
                   url:"${APP_PATH}/emp/"+del_idstr,
                   type:"DELETE",
                   success:function(result){
                        alert(result.msg);
                        //回到当前页面
                        to_page(currentPage);
                   }
              });
             }
          });
        </script>
  </body>
</html>
