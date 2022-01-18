<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
      href="../../assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
    />
    <link rel="stylesheet" href="../../assets/styles/tailwind.css" />
</head>
<body>
 <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id="root">
<%@ include file="navbar.jsp" %>
<br><br><br><br><br><br><br>
<div class="relative bg-pink-600 md:pt-32 pb-32 pt-12">
 <div class="px-40 md:px-10 mx-auto w-full -m-24">
          <div class="flex flex-wrap">
            <div class="w-full lg:w-8/12 px-4">
              <div
                class="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100 border-0"
              >
                <div class="rounded-t bg-white mb-0 px-6 py-6">
                  <div class="text-center flex justify-between">
                    <h6 class="text-blueGray-700 text-xl font-bold">
                      Ajouter un quiz
                    </h6>
                   
                  </div>
                </div>
                <div class="flex-auto px-4 lg:px-10 py-10 pt-0">
                  <form  action="<%= request.getContextPath() %>/QuizServlet" method="post">
                   
                    <div class="flex flex-wrap">
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                          <label
                            class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                            htmlFor="grid-password"
                          >
                           language 
                          </label>
                          <select name="sujet" class="form-select border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" aria-label="Default select example">
                              <option selected>Sujet</option>
                              <option value="java">JAVA</option>
                              <option value="php">PHP</option>
                              <option value="python">PYTHON</option>
                               <option value="JS">JS</option>
                           </select>
                        </div>
                      </div>
                       <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                          <label
                            class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                            htmlFor="grid-password"
                          >
                           Niveau
                          </label>
                          <select name="niveau" class="form-select border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" aria-label="Default select example">
                              <option selected>niveau</option>
                              <option value="debutant">Debutant</option>
                              <option value="intermidiaire">Intermidiaire</option>
                              <option value="expert">Expert</option>
                              
                           </select>
                        </div>
                      </div>
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                          <label
                            class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                            htmlFor="grid-password"
                          >
                            Description
                          </label>
                          <input
                            type="text"
                            class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                            name="desc"
                          />
                        </div>
                      </div>
                      
                     
                     <button
                      class="bg-pink-500 text-white active:bg-pink-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150"
                      <input type="submit" value="Submit" />
                    >
                     ajouter
                    </button>
                  </form>
                </div>
              </div>
            </div>
            
         
        </div>
      </div>
    </div>
</body>
</html>