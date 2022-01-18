
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--

=========================================================
* Notus JS - v1.1.0 based on Tailwind Starter Kit by Creative Tim
=========================================================

* Product Page: https://www.creative-tim.com/product/notus-js
* Copyright 2021 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/notus-js/blob/main/LICENSE.md)

* Tailwind Starter Kit Page: https://www.creative-tim.com/learning-lab/tailwind-starter-kit/presentation

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

-->
  
   
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
            href="../../index.html"
          >
              <img
                        alt="..."
                        src="../../images/logo1.PNG"
                        height ="120"
                        width="120"
                      />
          </a>
          <ul class="md:hidden items-center flex flex-wrap list-none">
           
           
          </ul>
          <div
            class="md:flex md:flex-col md:items-stretch md:opacity-100 md:relative md:mt-4 md:shadow-none shadow absolute top-0 left-0 right-0 z-40 overflow-y-auto overflow-x-hidden h-auto items-center flex-1 rounded hidden"
            id="example-collapse-sidebar"
          >
            <div
              class="md:min-w-full md:hidden block pb-4 mb-4 border-b border-solid border-blueGray-200"
            >
              <div class="flex flex-wrap">
                
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
            
            <!-- Navigation -->

            <ul class="md:flex-col md:min-w-full flex flex-col list-none">
              <li class="items-center">
                <a
                  href="./dashboard.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-orange-500"
                >
                  <i class="fill-teal-200 fas fa-tv mr-2 text-sm opacity-75"></i>
                  Tableau bu bord 
                </a>
              </li>
           

              <li class="items-center">
               <a
                  href="./quiz.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-orange-500"
                >
                  <i class="fill-teal-200 fas fa-feather-alt"></i>
                 Ajouter quiz
                </a>
              </li>

              <li class="items-center">
                <a
                  href="./tables.html"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-orange-500"
                >
                 <i class="fill-teal-200 fas fa-clipboard-list"></i>
                 Liste des quiz
                </a>
              </li>
               <li class="items-center">
                <a
                  href="./COMPONENTS/logout.jsp"
                  class="text-xs uppercase py-3 font-bold block text-blueGray-700 hover:text-orange-500"
                >
                  <i class="fill-teal-200 fas fa-sign-out-alt"></i>
                Deconnecter
                </a>
              </li>
             
            </ul>

            
      </nav>
      <div class="relative md:ml-64 bg-blueGray-50">
        <nav
          class="absolute top-0 left-0 w-full z-10 bg-transparent md:flex-row md:flex-nowrap md:justify-start flex items-center p-4"
        >
         <% 
                    
             		HttpSession ses= request.getSession(true);
            		String nom=(String) ses.getAttribute("nom");
            		
            		%>
          <div
            class="w-full mx-autp items-center flex justify-between md:flex-nowrap flex-wrap md:px-10 px-4"
          >
            <a
              class="text-white text-sm uppercase hidden lg:inline-block font-semibold"
              href="./index.html"
              > bonjour professeur </a
            >
            <form
              class="md:flex hidden flex-row flex-wrap items-center lg:ml-auto mr-3"
            >
            <div class=" bg-pink-600 md:pt-32 pb-32 pt-12">
              <div class="relative flex w	-full flex-wrap items-stretch">
                <span
                  class="z-10 h-full leading-snug font-normal absolute text-center text-blueGray-300 absolute bg-transparent rounded text-base items-center justify-center w-8 pl-3 py-3"
                  ><i class="fas fa-search"></i
                ></span>
                <input
                  type="text"
                  placeholder="Search here..."
                  class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 relative bg-white bg-white rounded text-sm shadow outline-none focus:outline-none focus:ring w-full pl-10"
                />
              </div>
              </div>
            </form>
            
          </div>
        </nav>
      
   
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
 
