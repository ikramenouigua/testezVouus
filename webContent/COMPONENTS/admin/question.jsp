<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
     <%
  String id=request.getParameter("id");
     int l=1;
     String DRIVER = "com.mysql.jdbc.Driver";
     String URL = "jdbc:mysql://localhost:3306/testezvous";
     String USERNAME = "root";
     String PASSWORD = "";
  %>
    <%
                        try {
						    Class.forName(DRIVER);  // Allocate the driver class
						    conn =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
						    Statement stm3 =conn.createStatement();
						    ResultSet rsQ = stm3.executeQuery("SELECT * FROM question where idQuiz='"+id+"'");
						    %>
						    
             
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
      href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"
    />
    <link
      rel="stylesheet"
      href="../../assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
    />
    <link rel="stylesheet" href="../../assets/styles/tailwind.css" />
    <title>Administrateur du tableau de bord | TESTEZ VOUS</title>
  </head>
  <h6 class="text-blueGray-700 text-xl font-bold">
                    
                     Quiz <%=id %>
                       
                    </h6>
                       <%
                       
			while(rsQ.next()) { 
				
				
			%>
  <body class="text-blueGray-700 antialiased">
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id="root">
   <nav
        class="md:left-0 md:block md:fixed md:top-0 md:bottom-0 md:overflow-y-auto md:flex-row md:flex-nowrap md:overflow-hidden shadow-xl bg-white flex flex-wrap items-center justify-between relative md:w-64 z-10 py-4 px-6"
      >
        <div
          class="md:flex-col md:items-stretch md:min-h-full md:flex-nowrap px-0 flex flex-wrap items-center justify-between w-full mx-auto"
        >
          <button
            class="cursor-pointer text-black opacity-50 md:hidden px-3 py-1 text-xl leading-none bg-transparent rounded border border-solid border-transparent"
            type="button"
            onclick="toggleNavbar('example-collapse-sidebar')"
          >
            <i class="fas fa-bars"></i>
          </button>
          <a
            class="md:block text-left md:pb-2 text-blueGray-600 mr-0 inline-block whitespace-nowrap text-sm uppercase font-bold p-4 px-0"
            href="./dashboard.jsp"
          >
              <img
                        alt="..."
                        src="../../images/logo.png"
                        height ="130"
                        width="130"
                      />
          </a>
          <ul class="md:hidden items-center flex flex-wrap list-none">
            <li class="inline-block relative">
              <a
                class="text-blueGray-500 block py-1 px-3"
                href="#pablo"
                onclick="openDropdown(event,'notification-dropdown')"
                ><i class="fas fa-bell"></i
              ></a>
              <div
                class="hidden bg-white text-base z-50 float-left py-2 list-none text-left rounded shadow-lg min-w-48"
                id="notification-dropdown"
              >
                <a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Action</a
                ><a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Another action</a
                ><a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Something else here</a
                >
                <div
                  class="h-0 my-2 border border-solid border-blueGray-100"
                ></div>
                <a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Seprated link</a
                >
              </div>
            </li>
            <li class="inline-block relative">
              <a
                class="text-blueGray-500 block"
                href="#pablo"
                onclick="openDropdown(event,'user-responsive-dropdown')"
                ><div class="items-center flex">
                  <span
                    class="w-12 h-12 text-sm text-white bg-blueGray-200 inline-flex items-center justify-center rounded-full"
                    ><img
                      alt="..."
                      class="w-full rounded-full align-middle border-none shadow-lg"
                      src="../../assets/img/team-1-800x800.jpg"
                  /></span></div
              ></a>
              <div
                class="hidden bg-white text-base z-50 float-left py-2 list-none text-left rounded shadow-lg min-w-48"
                id="user-responsive-dropdown"
              >
                <a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Action</a
                ><a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Another action</a
                ><a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Something else here</a
                >
                <div
                  class="h-0 my-2 border border-solid border-blueGray-100"
                ></div>
                <a
                  href="#pablo"
                  class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent text-blueGray-700"
                  >Seprated link</a
                >
              </div>
            </li>
          </ul>
          <div
            class="md:flex md:flex-col md:items-stretch md:opacity-100 md:relative md:mt-4 md:shadow-none shadow absolute top-0 left-0 right-0 z-40 overflow-y-auto overflow-x-hidden h-auto items-center flex-1 rounded hidden"
            id="example-collapse-sidebar"
          >
            <div
              class="md:min-w-full md:hidden block pb-4 mb-4 border-b border-solid border-blueGray-200"
            >
              <div class="flex flex-wrap">
                <div class="w-6/12">
                  <a
                    class="md:block text-left md:pb-2 text-blueGray-600 mr-0 inline-block whitespace-nowrap text-sm uppercase font-bold p-4 px-0"
                    href="../../index.html"
                  >
                    TESTEZ VOUS
                  </a>
                </div>
                <div class="w-6/12 flex justify-end">
                  <button
                    type="button"
                    class="cursor-pointer text-black opacity-50 md:hidden px-3 py-1 text-xl leading-none bg-transparent rounded border border-solid border-transparent"
                    onclick="toggleNavbar('example-collapse-sidebar')"
                  >
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
            </div>
            <form class="mt-6 mb-4 md:hidden">
              <div class="mb-3 pt-0">
                <input
                  type="text"
                  placeholder="Search"
                  class="border-0 px-3 py-2 h-12 border border-solid border-blueGray-500 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-base leading-snug shadow-none outline-none focus:outline-none w-full font-normal"
                />
              </div>
            </form>
            <!-- Divider -->
            <hr class="my-4 md:min-w-full" />
            <!-- Heading -->
            <h6
              class="md:min-w-full text-blueGray-500 text-xs uppercase font-bold block pt-1 pb-4 no-underline"
            >
          
            </h6>
            <!-- Navigation -->

            <ul class="md:flex-col md:min-w-full flex flex-col list-none">
             <li class="items-center">
                <a
                  href="./dashboard.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-blueGray-500"
                >
                  <i class="fas fa-chart-line mr-2 text-sm text-blueGray-500"></i>
                 Administrateur du tableau de bord
                </a>
              </li>
              <li class="items-center">
                <a
                   href="./users.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-blueGray-500"
                >
                  <i class="fas fa-user-graduate mr-2 text-sm opacity-75"></i>
                  Etudiants
                </a>
              </li>
				 <li class="items-center">
                <a
                  href="./Prof.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-blueGray-500"
                >
                  <i class="fas fa-chalkboard-teacher mr-2 text-sm text-blueGray-700"></i>
                  Professeurs
                </a>
              </li>
                <li class="items-center">
                <a
                   href="./certificat.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-blueGray-500"
                >
                  <i class="fas fa-certificate mr-2 text-sm text-blueGray-700"></i>
                   Certificate
                </a>
              </li>
              <li class="items-center">
                <a
                   href="./confirm.jsp"
                  class="text-xs uppercase py-3 font-bold block text-orange-500 hover:text-blueGray-500"
                >
                  <i class="fas fa-tools mr-2 text-sm text-orange-500"></i>
                   Suppression des quiz
                </a>
              </li>

             

             
            </ul>

            <!-- Divider -->
            <hr class="my-4 md:min-w-full" />
            <!-- Heading -->
            <h6
              class="md:min-w-full text-blueGray-500 text-xs uppercase font-bold block pt-1 pb-4 no-underline"
            >
           
            </h6>
           
            <!-- Divider -->
            <hr class="my-4 md:min-w-full" />
            <!-- Heading -->
           
          </div>
        </div>
      </nav>
      <div class="relative md:ml-64 bg-blueGray-50">
        <nav
          class="absolute top-0 left-0 w-full z-10 bg-transparent md:flex-row md:flex-nowrap md:justify-start flex items-center p-4"
        >
         
        </nav>
        <!-- Header -->
        
       
        <br> <br> <br>
         <br> <br> <br>
         <br> <br> <br>
        <div class="px-20 md:px-20 mx-auto w-full -m-24">
        
          <div class="flex flex-wrap">
          
            <div class="w-full lg:w-8/12 px-4">
            
              <div
                class="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100 border-0"
              >
              
                <div class="rounded-t bg-white mb-0 px-6 py-6">
                  <div class="text-center flex justify-between">
                  
                   <%
                   if(l==1){
                   %>
                   <a href="includeConfirm.jsp?id=<%=rsQ.getString("idQuiz") %>">
                    <button
                      class="bg-teal-200 text-white active:bg-pink-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150"
                      type="button"
                    >
                      SUPPRESSION
                    </button>
                    </a>
                    <%} %>
                  </div>
                </div>
                <div class="flex-auto px-4 lg:px-10 py-10 pt-0">
                 
                  <form>
                    <h6
                      class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase"
                    >
                      Question <%=l++ %>
                    </h6>
                    <div class="flex flex-wrap">
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                        <%if(rsQ.getString("question") !=null){
                        	%>
                        	
                        	 <label
                             class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                             htmlFor="grid-password"
                           >
                              <%=rsQ.getString("question") %>
                           </label>
                           <% 
                          }else{
                        	  %>
                        	  <label
                              class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                              htmlFor="grid-password"
                            >
                               0
                            </label>
                            <% 
          				} %>
                         
                         
                        </div>
                      </div>
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                         
                          
                        </div>
                      </div>
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                         
                         
                        </div>
                      </div>
                      <div class="w-full lg:w-6/12 px-4">
                        <div class="relative w-full mb-3">
                         
                         
                        </div>
                      </div>
                    </div>

                    <hr class="mt-6 border-b-1 border-blueGray-300" />

                    <h6
                      class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase"
                    >
                      Les choix
                    </h6>
                    <div class="flex flex-wrap">
                      <div class="w-full lg:w-12/12 px-4">
                        <div class="relative w-full mb-3">
                        
                        
                         <label
                            class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                            htmlFor="grid-password"
                          >
                            1- <%=rsQ.getString("choix1") %> <br><br>
                            2- <%=rsQ.getString("choix2") %><br><br>
                             3-<%=rsQ.getString("choix3") %><br><br>
                          </label>
                        </div>
                      </div>
                      <div class="w-full lg:w-4/12 px-4">
                        <div class="relative w-full mb-3">
                         
                        </div>
                      </div>
                      <div class="w-full lg:w-4/12 px-4">
                        <div class="relative w-full mb-3">
                          
                        </div>
                      </div>
                      <div class="w-full lg:w-4/12 px-4">
                        <div class="relative w-full mb-3">
                         
                        </div>
                      </div>
                    </div>

                    <hr class="mt-6 border-b-1 border-blueGray-300" />

                    <h6
                      class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase"
                    >
                      Réponse
                    </h6>
                    <div class="flex flex-wrap">
                      <div class="w-full lg:w-12/12 px-4">
                        <div class="relative w-full mb-3">
                         <label
                            class="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                            htmlFor="grid-password"
                          >
                           <%=rsQ.getString("reponse") %> <br><br><br> <br> <br>
         <br> <br> <br>
        
                          </label>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
           
        
        </div>
      </div>
    </div>
    
     
    
    <script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
    <script type="text/javascript">
      /* Make dynamic date appear */
      (function () {
        if (document.getElementById("get-current-year")) {
          document.getElementById(
            "get-current-year"
          ).innerHTML = new Date().getFullYear();
        }
      })();
      /* Sidebar - Side navigation menu on mobile/responsive mode */
      function toggleNavbar(collapseID) {
        document.getElementById(collapseID).classList.toggle("hidden");
        document.getElementById(collapseID).classList.toggle("bg-white");
        document.getElementById(collapseID).classList.toggle("m-2");
        document.getElementById(collapseID).classList.toggle("py-3");
        document.getElementById(collapseID).classList.toggle("px-6");
      }
      /* Function for dropdowns */
      function openDropdown(event, dropdownID) {
        let element = event.target;
        while (element.nodeName !== "A") {
          element = element.parentNode;
        }
        Popper.createPopper(element, document.getElementById(dropdownID), {
          placement: "bottom-start",
        });
        document.getElementById(dropdownID).classList.toggle("hidden");
        document.getElementById(dropdownID).classList.toggle("block");
      }
    </script>
  </body>
  
  
   <%!
				
					java.sql.Connection conn ,connQ1;
					java.sql.Statement st ,stQ;
					java.sql.ResultSet rec , recQ;
						%>
    
    <% 
				
				}
                }catch(Exception e) {
					    	System.out.println(e.getMessage());
					    } finally {
					    	// Make sure you close only things you have opened!
					    	if (rec!=null) rec.close();
					    	if (st !=null) st.close();
					    	if (conn !=null) conn.close();
					    }
						    
                        %>
</html>
