package bookSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class AddnewbookAction extends ActionSupport{
	private String newbookname;
	private String booknumber;
	private String ISBNnum;
	private String author;
	private String date;
	private String publisher;
	private String price;
	
	//提供get/set方法
	public String getName() {
		return newbookname;
	}
	
	public String getNumber() {
		return booknumber;
	}
	public void setNumber(String booknumber) {
		this.booknumber = booknumber;
	}
	public void setName(String newbookname) {
		this.newbookname = newbookname;
	}
	public String getISBN() {
		return ISBNnum;
	}
	public void setISBN(String ISBNnum) {
		this.ISBNnum = ISBNnum;
	}
	public String getauthor() {
		return ISBNnum;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getpublisher() {
		return publisher;
	}
	public void setpublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getprice() {
		return date;
	}
	public void setprice(String price) {
		this.price = price;
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("GB18030");
		
		String booknum=request.getParameter("booknumber");
		String ISBN=request.getParameter("ISBN");
		String bookname=request.getParameter("newbookname");
		String authorname=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String date=request.getParameter("date");
		String price=request.getParameter("price");
		
		
		AddnewbookAction addnewbook=new AddnewbookAction();
		addnewbook.setNumber(booknum);
		addnewbook.setISBN(ISBN);
		addnewbook.setName(bookname);
		addnewbook.setauthor(authorname);
		addnewbook.setpublisher(publisher);
		addnewbook.setdate(date);
		addnewbook.setprice(price);
	}
	
	public void addnew(AddnewbookAction addnewbook) throws Exception
	{
		
		String bookber = addnewbook.getNumber();
		String ISBNnumber = addnewbook.getISBN();
		String newname = addnewbook.getName();
		String author = addnewbook.getauthor();
		String publisher = addnewbook.getpublisher();
		String date = addnewbook.getdate();
		String price = addnewbook.getprice();
		
		Connection con = null;
		PreparedStatement pstmt =null;
		try{
			//注册数据库
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//获取链接
			String url="jdbc:mysql://127.0.0.1:3306/bookmanagementsystem";
			String user="root"; 
			String password="tjr19970907";
			con= DriverManager.getConnection(url,user,password); 
			System.out.println(con);;
			//数据库指令
			String sql ="insert into emp(BookNumber,BookName,ISBN,Publisher,Date,Price,Author(ID)) values(?,?,?,?,?,?,?)";
			//发送sql语句
			pstmt = con.prepareStatement(sql);
			//插入到具体地方
			pstmt.setString(1,bookber);
			pstmt.setString(2,ISBNnumber);
			pstmt.setString(3,newname);
			pstmt.setString(4,author);
			pstmt.setString(5,publisher);
			pstmt.setString(6,date);
			pstmt.setString(7,price);
			
			
			//执行sql	
			pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		
		
	
}
