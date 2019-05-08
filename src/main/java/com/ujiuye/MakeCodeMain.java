package com.ujiuye;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class MakeCodeMain {
	
	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

		DruidDataSource datasource = context.getBean(DruidDataSource.class);		
		DruidPooledConnection conn = datasource.getConnection();		    

		//定义生成模块名称:商品管理模块
		 String modelName="sellergoods";
		 //引用的Service名称
		 String ServiceName="sellergoods";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet=(Set<String>) context.getBean("manager_Web_tableSet");
		//循环全部表
		for (String tableName : tableSet) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			GeneratorSource.makeService(modelName,tableName, tableComment,primarykey);			
			GeneratorSource.makeServiceImpl(modelName,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName,ServiceName,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		//定义生成模块名称:商家管理模块
		 String modelName2="shop";
		 //引用的Service名称
		 String ServiceName2="sellergoods";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet2=(Set<String>) context.getBean("manager_shop_tableSet");
		//循环全部表
		for (String tableName : tableSet2) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			//GeneratorSource.makeService(modelName,tableName, tableComment,primarykey);			
			//GeneratorSource.makeServiceImpl(modelName,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName2,ServiceName2,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		//定义生成模块名称:商家管理模块
		 String modelName3="content";
		 //引用的Service名称
		 String ServiceName3="content";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet3=(Set<String>) context.getBean("manager_content_tableSet");
		//循环全部表
		for (String tableName : tableSet3) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			GeneratorSource.makeService(modelName3,tableName, tableComment,primarykey);			
			GeneratorSource.makeServiceImpl(modelName3,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName3,ServiceName3,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		//定义生成模块名称:用户管理模块
		 String modelName4="user";		
		 //引用的Service名称
		 String ServiceName4="user";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet4=(Set<String>) context.getBean("manager_user_tableSet");
		//循环全部表
		for (String tableName : tableSet4) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			GeneratorSource.makeService(modelName4,tableName, tableComment,primarykey);			
			GeneratorSource.makeServiceImpl(modelName4,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName4,ServiceName4,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		//定义生成模块名称:用户管理模块
		 String modelName5="order";		
		 //引用的Service名称
		 String ServiceName5="order";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet5=(Set<String>) context.getBean("order_tableSet");
		//循环全部表
		for (String tableName : tableSet5) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			GeneratorSource.makeService(modelName5,tableName, tableComment,primarykey);			
			GeneratorSource.makeServiceImpl(modelName5,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName5,ServiceName5,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		//定义生成模块名称:用户管理模块
		 String modelName6="seckill";		
		 //引用的Service名称
		 String ServiceName6="seckill";
		//从spring配置文件获取改模块需要生成的表集合
		Set<String> tableSet6=(Set<String>) context.getBean("seckill_tableSet");
		//循环全部表
		for (String tableName : tableSet6) {
			//获取指定表的全部字段和说明
			List<String> listcolumn = getColumnCommentByTableName(tableName,conn);
			//删除第一列，主键列
			String primarykey=listcolumn.remove(0);			
			String tableComment=getTableComment(tableName,conn);
			System.out.println("【表名称:"+tableName+" 】");
			//去除表名称的前缀
			tableName=tableName.substring(3);
			//生成代码
			GeneratorSource.makeService(modelName6,tableName, tableComment,primarykey);			
			GeneratorSource.makeServiceImpl(modelName6,tableName,tableComment,listcolumn,primarykey);
			GeneratorSource.makeController(modelName6,ServiceName6,tableName, tableComment,primarykey);
			GeneratorSource.makeJsController(tableName, tableComment);
			GeneratorSource.makeJsService(tableName, tableComment);
			GeneratorSource.makeHtml(tableName,tableComment,listcolumn,primarykey);
		}
		
		conn.close();
	}
	
	//获取全部数据表名称	
	public static List<String> getAllTables(DruidPooledConnection conn) throws SQLException{
		List tables = new ArrayList();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW TABLES ");
		while (rs.next()) {
			String tableName = rs.getString(1);
			tables.add(tableName);
		}
		rs.close();
		stmt.close();
		
		return tables;
	}
	
	//获取制定数据表的注释	
	public static String getTableComment(String tableName,DruidPooledConnection conn) throws SQLException{
		String comment=null;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
		if (rs != null && rs.next()) {
			String createDDL = rs.getString(2);
			comment = parse(createDDL);
		}
		rs.close();
		stmt.close();
		return comment;
		
	}
	
	//获取制定数据表的列名、类型、注释	
		public static List<String> getColumnCommentByTableName(String tableName,DruidPooledConnection conn) throws SQLException{
			List<String> list=new ArrayList<String>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("show full columns from " + tableName);
		    while (rs.next()) {   
               //System.out.println("字段名称：" + rs.getString("Field") + "\t"+ "字段注释：" + rs.getString("Comment")+ "\t"+ "字段类型：" + rs.getString("Type") );
		      list.add(rs.getString("Field")+"~"+rs.getString("Type")+"~"+rs.getString("Comment"));
		    
		    } 

			rs.close();
			stmt.close();
			return list;
			
		}
	
	//解析注释
	public static String parse(String all) {
		String comment = null;
		int index = all.indexOf("COMMENT='");
		if (index < 0) {
			return "";
		}
		comment = all.substring(index + 9);
		comment = comment.substring(0, comment.length() - 1);
		return comment;
	}

}
