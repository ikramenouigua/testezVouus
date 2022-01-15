<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
      rel="stylesheet"
      href="../../css/CardQuiz.css"
    />
</head>
<body class="xx">
<%@ page import="dao.QuizDAO, model.Quiz,java.util.*" %>
                     <% 
                     QuizDAO quizDAO2 = new QuizDAO();
                    
            		List<Quiz> listquiz =  quizDAO2.selectQuizAll() ;
            		Iterator<Quiz> iter = listquiz.iterator();
            		%>
           <ul class="cards">
              <% while(iter.hasNext()){
                    	Quiz quiz = iter.next();
                    	int id=quiz.getId();
                    	%>
  <li>
    <a href="<%= request.getContextPath() %>/QuestionServlet?id=<%=quiz.getId()%>"  class="card">
     <% 
                     
                   HttpSession ses= request.getSession(true);
            		 ses.setAttribute("id", id);
            		
            		%>
     salam : <c:out value='${id}'/>
      <% if(quiz.getSujet().equals("JAVA")){ %>                  
          <img class="card__image" src="https://wp.lean.fr/wp-content/uploads/2021/01/icon.php_.png" alt="" />
          <%} %>
          
          
          <% if(quiz.getSujet().equals("php")){ %>                  
          <img class="card__image" src="https://wp.lean.fr/wp-content/uploads/2021/01/icon.php_.png" alt="" />
          <%} %>
          
          <% if(quiz.getSujet().equalsIgnoreCase("python")){ %>                  
          <img class="card__image" src="https://www.developpez.net/forums/attachments/p597954d1/a/a/a" alt="" />
          <%} %>
          
          <% if(quiz.getSujet().equals("JS")){ %>                  
          <img class="card__image" src="http://moralogiq.fr/wp-content/themes/moralogiq/images/logo/techno-js.png" alt="" />
          <%} %>
      <div class="card__overlay">
        <div class="card__header">
          <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>   
         
          <div class="card__header-text">
          
            <h3 class="card__title"><%=quiz.getSujet() %></h3>
                       
            <span class="card__status"><%=quiz.getNiveau() %></span><br>
            <span class="card__status">8 Questions</span>
          </div>
        </div>
        <p class="card__description"><%=quiz.getDescription() %></p>
      </div>
    </a>      
  </li>
    <% ses.removeAttribute("id"); %>
  <% } %>
  <li>
    <a href="" class="card">
      <img src="https://i.imgur.com/2DhmtJ4.jpg" class="card__image" alt="" />
      <div class="card__overlay">        
        <div class="card__header">
          <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>                 
          <img class="card__thumb" src="https://i.imgur.com/sjLMNDM.png" alt="" />
          <div class="card__header-text">
            <h3 class="card__title">kim Cattrall</h3>
            <span class="card__status">3 hours ago</span>
          </div>
        </div>
        <p class="card__description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, blanditiis?</p>
      </div>
    </a>
  </li>
  <li>
    <a href="" class="card">
      <img src="https://i.imgur.com/oYiTqum.jpg" class="card__image" alt="" />
      <div class="card__overlay">
        <div class="card__header">
          <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>                     
          <img class="card__thumb" src="https://i.imgur.com/7D7I6dI.png" alt="" />
          <div class="card__header-text">
            <h3 class="card__title">Jessica Parker</h3>
            <span class="card__tagline">Lorem ipsum dolor sit amet consectetur</span>            
            <span class="card__status">1 hour ago</span>
          </div>
        </div>
        <p class="card__description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, blanditiis?</p>
      </div>
    </a>
  </li>
  <li>
    <a href="" class="card">
      <img src="https://i.imgur.com/2DhmtJ4.jpg" class="card__image" alt="" />
      <div class="card__overlay">
        <div class="card__header">
          <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>                 
          <img class="card__thumb" src="https://i.imgur.com/sjLMNDM.png" alt="" />
          <div class="card__header-text">
            <h3 class="card__title">kim Cattrall</h3>
            <span class="card__status">3 hours ago</span>
          </div>          
        </div>
        <p class="card__description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, blanditiis?</p>
      </div>
    </a>
  </li>    
</ul>
</body>
</html>