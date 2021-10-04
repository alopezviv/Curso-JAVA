$(document).ready(()=>{
    console.log("JQUERY Activado")
    $("#formRegistroUsuario").submit(function (e) { 
        e.preventDefault();
        postPlayer();
    });

});


function postPlayer(){
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/players",
        data: $("#formRegistroUsuario").serialize(),
        dataType: "json",
        complete: function(data) {
            alert(data.responseText);
        }
    });  
}
function juego1(){}