<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="theme-color" content="#000000" />
    <link rel="shortcut icon" href="../../assets/img/favicon.ico" />
    <link
      rel="apple-touch-icon"
      sizes="76x76"
      href="../../assets/img/apple-icon.png"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"
    />
    <link
      rel="stylesheet"
      href="../../assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
    />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/styles/tailwind.css" />
    <title>tableau de bord de professeur | TESTEZ VOUS</title>
  </head>
  <body class="text-blueGray-700 antialiased">
  
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id="root">
      <%@ include file="navbar.jsp"%>
      <br>  <br>  <br>  <br>  <br>  <br>  
   <%@ page import="dao.QuizDAO, model.Quiz,dao.CertificatDAO, model.Certificat,java.util.*" %>
                     <% 
                     String email=(String) ses.getAttribute("email");
                     QuizDAO quizDAO2 = new QuizDAO();
                     CertificatDAO CertificatDAO2 = new CertificatDAO();
                     List<Certificat> listCertificat =  CertificatDAO2.selectCertificat(email) ;
                     Iterator<Certificat> iter1 = listCertificat.iterator();
            		List<Quiz> listquiz =  quizDAO2.selectQuiz(email) ;
            		int nbquiz=listquiz.size();
            		int nbCert= listCertificat.size();
            		int nbqst=nbquiz*8;
            		Iterator<Quiz> iter = listquiz.iterator();
            		%>
<div class="flex flex-wrap mt-4">
            <div class="w-full xl:w-8/12 mb-12 xl:mb-0 px-4">
              <div
                class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded"
              >
                <div class="rounded-t mb-0 px-4 py-3 border-0">
                  <div class="flex flex-wrap items-center">
                    <div
                      class="relative w-full px-4 max-w-full flex-grow flex-1"
                    >
                      <h3 class="font-semibold text-base text-blueGray-700">
                        Nombre de vos quiz
                      </h3>
                    </div>
                    <div
                      class="relative w-full px-4 max-w-full flex-grow flex-1 text-right"
                    >
                    </div>
                  </div>
                </div>
                <div class="block w-full overflow-x-auto">
                  <!-- Projects table -->
                  <table
                    class="items-center w-full bg-transparent border-collapse"
                  >
                    <thead>
                      <tr>
                        <th
                          class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left"
                        >
                          Sujet
                        </th>
                        <th
                          class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left"
                        >
                          Description
                        </th>
                        <th
                          class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left"
                        >
                          Niveau
                        </th>
                        <th
                          class="px-6 bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left"
                        >
                          Nb questions
                        </th>
                        <th></th>
                        <th></th>
                                             </tr>
                    </thead>
                    
                    <tbody>
                  
            		
                    <% while(iter.hasNext()){
                    	Quiz quiz = iter.next();
                    	%>
                    
               
                      <tr>
                     
                        <th
                          class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left"
                        >
                          <%=quiz.getSujet() %>
                        </th>
                        <td
                          class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4"
                        >
                          <%=quiz.getDescription() %>
                        </td>
                        <td
                          class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4"
                        >
                          <%=quiz.getNiveau() %>
                        </td>
                        <td
                          class="border-t-0 px-6 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4"
                        >
                          
                          8 questiion
                        </td>
                        <td>
                        <a href="<%= request.getContextPath() %>/QuizServlet11?id=<%=quiz.getId()%>" >
                        
                         <i class="fas fa-trash-alt"></i></button>
                       </a>
                         <td><i class="fas fa-edit"></i></td>
                      </tr>
                       <%} %> 
                     
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
           
          </div>
</body>
</html>