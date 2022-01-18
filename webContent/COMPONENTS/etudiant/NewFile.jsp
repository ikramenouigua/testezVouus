<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>hhdueon hfijo hiefijf </h2>
<script>
var x=0;
document.addEventListener("visibilitychange", function() {
	console.log(x);
	  if (document.visibilityState === 'visible') {
	    
	  } else {
	    x++;
	    if(x<3){
	    alert("Vous avez changer l'onglet si vous passez trois fois ");
	    }
	  }
	  if(x>=3){
		  alert("vous avez quitter la page 3 fois");
	  }
	});
</script>
</body>
</html>