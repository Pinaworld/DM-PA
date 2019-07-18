(function($) {
  "use strict";
	$('.connexion').on('click', function(){
     document.location.href="C:/Users/sdelbe/Desktop/eBusiness/HomePage.html"
       var email = document.getElementById("mail").value;
       var mdp = document.getElementById("mdp").value;
       
    if(validate(email) != false && mdp.length != 0 ){
        $.ajax({
          type: 'POST',
          url: "http:// route de l'api pour auth",
          data: {
            email: email,
            password: mdp
          },
          success: function(data) {
            document.location.href="localhost:8080.HomePage.html"
          },
          error: function(errormessage){
            alert(errormessage.responseText);
          }
        });
        
      }
  });

})(jQuery);