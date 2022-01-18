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
<style>
.xx {
  font-family: 'Noto Sans JP', sans-serif;
  background-color: #fef8f8;
  box-sizing: border-box;
   --surface-color: #fff;
  --curve: 40;
}

.cards1 {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
  margin: 4rem 5vw;
  padding: 0;
  list-style-type: none;
  width:20%;
  height:20%;
}

.card1 {
  position: relative;
  display: block;
  height: 100%;  
  border-radius: calc(var(--curve) * 1px);
  overflow: hidden;
  text-decoration: none;
}

.card__image1 {      
  width: 100%;
  height: 60%;
}

.card__overlay1 {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 1;      
  border-radius: calc(var(--curve) * 1px);    
  background-color: var(--surface-color);      
  transform: translateY(100%);
  transition: .2s ease-in-out;
}

.card1:hover .card__overlay1 {
  transform: translateY(0);
}

.card__header1 {
  position: relative;
  display: flex;
  align-items: center;
  gap: 2em;
  padding: 2em;
  border-radius: calc(var(--curve) * 1px) 0 0 0;    
  background-color: var(--surface-color);
  transform: translateY(-100%);
  transition: .2s ease-in-out;
}

.card__arc1 {
  width: 80px;
  height: 80px;
  position: absolute;
  bottom: 100%;
  right: 0;      
  z-index: 1;
}

.card__arc1 path {
  fill: var(--surface-color);
  d: path("M 40 80 c 22 0 40 -22 40 -40 v 40 Z");
}       

.card1:hover .card__header1 {
  transform: translateY(0);
}

.card__thumb1 {
  flex-shrink: 0;
  width: 50px;
  height: 50px;      
  border-radius: 50%;      
}

.card__title1 {
  font-size: 2em;
  margin: 0 0 .3em;
  color: black;
}

.card__tagline1 {
  display: block;
  margin: 1em 0;
  font-family: "MockFlowFont";  
  font-size: .8em; 
  color: black;  
}

.card__status1 {
  font-size: 1em;
  color: #696969;
}

.card__description1 {
  padding: 0 2em 2em;
  margin: 0;
  color: black;
  font-family: "MockFlowFont";   
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}
</style>
<body class="xx">

                   
           <ul class="cards1">
              <%@ page import="dao.QuizDAO, model.Quiz,java.util.*" %>
                     <% 
                     
            		List<Quiz> listquiz =  (List<Quiz>)request.getAttribute("listquiz");
            		Iterator<Quiz> iter = listquiz.iterator();
            		%>
           <ul class="cards1">
              <% while(iter.hasNext()){
                    	Quiz quiz = iter.next();
                    	int id=quiz.getId();
                    	%>
                    	<li>
    <a href="<%= request.getContextPath() %>/QuestionServlet?id=<%=quiz.getId()%>"  class="card1">
     <% 
                     
                 
            	
            		
            		%>
    
      <% if(quiz.getSujet().equals("JAVA")){ %>                  
          <img class="card__image1" src="https://wp.lean.fr/wp-content/uploads/2021/01/icon.php_.png" alt="" />
          <%} %>
          
          
          <% if(quiz.getSujet().equals("php")){ %>                  
          <img class="card__image1" src="https://wp.lean.fr/wp-content/uploads/2021/01/icon.php_.png" alt="" />
          <%} %>
          
          <% if(quiz.getSujet().equalsIgnoreCase("python")){ %>                  
          <img class="card__image1" src="https://www.developpez.net/forums/attachments/p597954d1/a/a/a" alt="" />
          <%} %>
          
          <% if(quiz.getSujet().equals("JS")){ %>                  
          <img class="card__image1" src="http://moralogiq.fr/wp-content/themes/moralogiq/images/logo/techno-js.png" alt="" />
          <%} %>
      <div class="card__overlay1">
        <div class="card__header1">
          <svg class="card__arc1" xmlns="http://www.w3.org/2000/svg"><path /></svg>   
         
          <div class="card__header-text1">
          
            <h3 class="card__title1"><%=quiz.getSujet() %></h3>
                       
            <span class="card__status1"><%=quiz.getNiveau() %></span><br>
            <span class="card__status1">8 Questions</span>
          </div>
        </div>
        <p class="card__description1"><%=quiz.getDescription() %></p>
      </div>
    </a>      
  </li>
   
  <% } %>
 
   
</ul>
</body>
</html>