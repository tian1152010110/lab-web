package bookSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private String message;
	
	//提供get/set方法
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public HashMap doAction(HashMap infoIn)
	{
		String action = (infoIn.get("action") == null) ? " " :(String)infoIn.get("action");
		HashMap infoOut =new HashMap();
		if(action.equals(""))
			infoOut = this.doInit(infoIn);
		else if(action.equals("login"))
			infoOut = this.doLogin(infoIn);
		return infoOut;
	}
	public HashMap doInit(HashMap infoIn)
	{
		HashMap infoOut = infoIn;
		try{
			infoOut.put("msg", "shuruyonghuming");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			return infoOut;
		}
		
	}
	
	private HashMap doLogin(HashMap infoIn)
	{
		HashMap infoOut =infoIn;
		String username = (infoIn.get("username")== null)? "":(String)infoIn.get("username");
		String password = (infoIn.get("password")== null)? "":(String)infoIn.get("password");
		try{
			if("gd".equals(username) &&"123456".equals(password)){
				infoOut.put("msg", "chenggong");
			}
			else if(!"gd".equals(username) &&"123456".equals(password)){
				infoOut.put("msg", "yonghucuowu");
			}
			else if(!"gd".equals(username) &&"123456".equals(password)){
					infoOut.put("msg", "yonghucuowu");
			}
			else if("gd".equals(username) &&!"123456".equals(password)){
				infoOut.put("msg", "mimacuowu");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			return infoOut;
			
		}
	}
}
