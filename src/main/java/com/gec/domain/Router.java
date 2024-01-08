package com.gec.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude="routers")
public class Router {
    private String id;
    private String parentId;
    private String name;
    private String menuName;
    //{VUE} path: '/user/list'
    private String path;
    //{VUE} ()=> import('../views/xxx.vue')
    private String component;
    private String icon;

    public Router(){}
    public Router(String line){
        String[] D = line.split(",");
        this.id = D[0];
        this.parentId = D[1];
        this.name = D[2];
        this.menuName = D[3];
        this.path = D[4];
        this.component = D[5];
        this.icon = D[6];
    }

    private List<Router> routers = new ArrayList();
    public void addRouter(Router router){
        routers.add( router );
    }
//模仿从数据库中获取路由数据
    /* "rou1,top,Layout,主页,/layout,Layout",  */
    static String[] DATA = {
         "M010,top,user,用户管理,/user/,none,el-icon-user",
//         "M101,M010,adduser,添加用户,/user/adduser,/User/adduser.vue,icon",
         "M102,M010,userlist,用户列表,/user/list,/User/list.vue,icon",

//         "M020,top,dept,部门管理,/dept/,none,el-icon-s-platform",
//         "M201,M020,adddept,添加部门,/dept/adddept,/Dept/adddept.vue,icon",
//         "M202,M020,deptlist,部门列表,/dept/list,/Dept/list.vue,icon",
//
//         "M030,top,role,角色管理,/role/,none,el-icon-tickets",
//         "M301,M030,addrole,添加角色,/role/addrole,/Role/addrole.vue,icon",
//         "M302,M030,rolelist,角色列表,/role/list,/Role/list.vue,icon",

//         "M040,top,menu,菜单管理,/menu/,none,el-icon-message",
//         "M401,M040,addmenu,添加菜单,/menu/addmenu,/Menu/addmenu.vue,icon",
//         "M402,M040,menulist,角色菜单,/menu/list,/Menu/list.vue,icon",

         "M050,top,data,数据管理,/data/,none,el-icon-message",
//         "M501,M050,addmeterial,添加菜单,/data/addmeterial,/Data/addmeterial.vue,icon",
         "M501,M050,meterial,物料主数据,/data/meterial,/Data/meterial.vue,icon",
            "M502,M050,meterialtype,物料分类管理,/data/meterialtype,/Data/meterialtype.vue,icon",
            "M503,M050,meterialsecondary,子类别管理,/data/meterialsecondary,/Data/meterialsecondary.vue,icon",
            "M504,M050,meterialgroup,物料组管理,/data/meterialgroup,/Data/meterialgroup.vue,icon",

            "M060,top,warehouse,仓库管理,/warehouse/,none,el-icon-tickets",
            "M601,M060,manege,仓库管理,/warehouse/manage,/Warehouse/manage.vue,icon",
            "M602,M060,workarea,工作区管理,/warehouse/workarea,/Warehouse/workarea.vue,icon",
            "M603,M060,wareposition,库位管理,/warehouse/wareposition,/Warehouse/wareposition.vue,icon",

            "M070,top,inwareorder,出入库管理,/inwareorder/,none,el-icon-tickets",
            "M701,M070,request,入库申请,/inwareorder/request,/InWareOrder/request.vue,icon",
            "M702,M070,receipt,入库单管理,/inwareorder/receipt,/InWareOrder/receipt.vue,icon",
            "M703,M070,myorder,我的申请,/inwareorder/myorder,/InWareOrder/myorder.vue,icon",
//            "M603,M060,position,库位管理,/warehouse/position,/Warehouse/position.vue,icon",
            "M080,top,inventory,库存管理,/inventory/,none,el-icon-tickets",
            "M801,M080,inbound,入库任务,/inventory/inbound,/Inventory/inbound.vue,icon",
            "M802,M080,inventory,库存查询,/inventory/inventory,/Inventory/inventory.vue,icon",
    };
    public static List<Router> testData(){

        List<Router> list = new ArrayList<>();
        for(String D : DATA){
            Router router = new Router(D);
            list.add( router );
            System.out.println( router );
        }
        return list;
    }


}
