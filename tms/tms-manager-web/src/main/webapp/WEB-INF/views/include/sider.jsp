<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- 搜索表单，不需要删除即可 -->
        <!--<form action="#" method="get" class="sidebar-form">
          <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                  <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                  </button>
                </span>
          </div>
        </form>-->
        <!-- /.search form -->
        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.menu == 'home' ? 'active' : ''}"><a href="/home"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="header">系统管理</li>
            <!-- 客户管理 -->

                    <li class="${param.menu == 'customersmy' ? 'active' : '' }"><a href="/manage/account"><i class="fa fa-circle-o "></i> 帐号管理</a></li>
                    <li class="${param.menu == 'customerspub' ? 'active' : '' }"><a href="/manage/roles"><i class="fa fa-circle-o "></i> 角色管理</a></li>
                    <li class="${param.menu == 'manage_permission' ? 'active' : '' }"><a href="/manage/permission"><i class="fa fa-circle-o "></i> 权限管理</a></li>
                </ul>

       <%--     <!-- 工作记录 -->
            <li class="treeview ${fn:startsWith(param.menu,'work_record_') ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-bars"></i> <span>销售机会</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu ">
                    <li class ="${param.menu == 'work_record_my' ? 'active' : ''}"><a href="/sale/my/list"><i class="fa fa-circle-o"></i> 我的销售机会</a></li>
                </ul>
            </li>
            <!-- 待办事项 -->
            <li class="treeview ${fn:startsWith(param.menu,'task') ? 'active' : ''}">
                <a href="/task/list">
                    <i class="fa fa-calendar"></i> <span>待办事项</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
            </li>
            <!-- 统计报表 -->
            <li class="treeview ${fn:startsWith(param.menu,'charts') ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>统计报表</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class ="${param.menu == 'charts_demo' ? 'active' : ''}"><a href="/charts/static"><i class="fa fa-circle-o"></i> 静态报表</a></li>
                    <li class ="${param.menu == 'charts_customer_count' ? 'active' : ''}"><a href="/charts/customer/count"><i class="fa fa-circle-o"></i> 客户统计</a></li>
                    <li class ="${param.menu == 'charts_saleprocess_count' ? 'active' : ''}"><a href="/charts/saleprocess/count"><i class="fa fa-circle-o"></i> 机会进度统计</a></li>
                </ul>
            </li>


            <li class="${param.menu == 'disk' ? 'active' : ''}"><a href="/disk/home"><i class="fa fa-share-alt "></i> <span>公司网盘</span></a></li>
            <!-- <li class="header">系统管理</li> -->
            <!-- 部门员工管理 -->
            <li class="${param.staff  == 'stafflist' ? 'active' : '' }"><a href="/staff/list"><i class="fa fa-users"></i> <span>员工管理</span></a></li>
            <!--<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>-->
       --%>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- =============================================== -->