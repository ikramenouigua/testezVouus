<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<head>
	<title>convForm - example</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="dist/jquery.convform.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="demo.css">
</head>
<body>
	<section id="demo">
	    <div class="vertical-align">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-6 col-sm-offset-3 col-xs-offset-0">
	                    <div class="card no-border">
	                        <div id="chat" class="conv-form-wrapper">
	                            <form action="" method="GET" class="hidden">
	                                <select name="rep" data-conv-question="Bnjour cher utilisateur dans testez vous c'est le temps de tester vos connaissances dans la programation choisissez un language. " >
	                                    <option value="java">java</option>
	                                   <option value="PHP">PHP</option>
	                                     <option value="JAVASCRIPT">JAVASCRIPT</option>
	                                      <option value="JAVASCRIPT">PYTHON</option>
	                                </select>
	                                <input type="text" name="name" data-conv-question="Bien!  D'abord, dites-moi votre nom complet, s'il vous plaît.|D'accord ! S'il te plaît, dis-moi d'abord ton nom.">
	                                <input type="text" data-conv-question="bienvenue, {name}:0! C'est un plaisir de vous rencontrer. )" data-no-answer="true">
	                                <
	                                <select name="multi" data-conv-question="bon {name} quel est votre niveau dans ce language ?"  name="second-question">
	                                    <option value="debutant">Debutant</option>
	                                    <option value="moyen">Moyen</option>
	                                    <option value="bon">Bon niveau</option>
	                                </select>  
	                               <input type="text" name="name" data-conv-question="Excellent vous serez rediriger vers le quiz ."data-no-answer="true">
	                               <input type="text" name="name" data-conv-question="on vous souhaite une excellente experience dans notre plateforme  ."data-no-answer="true">
	                               <input type="text" name="name" data-conv-question="A bientot .">
	                            </form>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>
	<script type="text/javascript" src="jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="dist/autosize.min.js"></script>
	<script type="text/javascript" src="dist/jquery.convform.js"></script>

	<script>
		function google(stateWrapper, ready) {
			window.open("https://google.com");
			ready();
		}
		function bing(stateWrapper, ready) {
			window.open("https://bing.com");
			ready();
		}
		var rollbackTo = false;
		var originalState = false;
		function storeState(stateWrapper, ready) {
			rollbackTo = stateWrapper.current;
			console.log("storeState called: ",rollbackTo);
			ready();
		}
		function rollback(stateWrapper, ready) {
			console.log("rollback called: ", rollbackTo, originalState);
			console.log("answers at the time of user input: ", stateWrapper.answers);
			if(rollbackTo!=false) {
				if(originalState==false) {
					originalState = stateWrapper.current.next;
						console.log('stored original state');
				}
				stateWrapper.current.next = rollbackTo;
				console.log('changed current.next to rollbackTo');
			}
			ready();
		}
		function restore(stateWrapper, ready) {
			if(originalState != false) {
				stateWrapper.current.next = originalState;
				console.log('changed current.next to originalState');
			}
			ready();
		}
	</script>
	<script>
		jQuery(function($){
			convForm = $('#chat').convform({selectInputStyle: 'disable'});
			console.log(convForm);
		});
	</script>
</body>
</html>