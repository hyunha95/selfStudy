package com.kh.mvc.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.kh.mvc.member.model.vo.Member;

/**
 * Application Lifecycle Listener implementation class SessionAttriListener
 *
 */
@WebListener
public class SessionAttriListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttriListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         Object value = se.getValue();
         System.out.println("attributeAdded : " + name + " = " + value);
         
         if(value instanceof Member) {
        	 Member loginMember = (Member) value;
        	 System.out.println(loginMember.getMemberName() + "님이 로그인했습니다.");
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         Object value = se.getValue();
         System.out.println("attributeRemoved : " + name + " = " + value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
