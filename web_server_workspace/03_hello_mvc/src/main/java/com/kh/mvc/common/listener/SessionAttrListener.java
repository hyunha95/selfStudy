package com.kh.mvc.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.kh.mvc.member.model.vo.Member;

/**
 * Application Lifecycle Listener implementation class SessionAttrListener
 *
 * HttpSessionAttributeListener
 * 		- HttpSession에 대한 속성 값이 변경될 경우 발생
 */
@WebListener //web.xml에 대신 작성해줌
public class SessionAttrListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     * 
     * attributeAdded : 세션에 새로운 속성 값이 추가될 때 실행되는 메소드
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
//         HttpSession session = se.getSession();
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
     * 
     * attributeRemoved : 세션에 속성 값이 제거될 때 실행되는 메소드
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         Object value = se.getValue();
         System.out.println("attributeRemoved : " + name + " = " + value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     * 
     * attributeReplaced : 세션에 속성 값이 변경될 때 실행되는 메소드
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
