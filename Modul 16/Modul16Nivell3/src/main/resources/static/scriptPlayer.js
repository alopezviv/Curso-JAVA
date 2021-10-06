$(document).ready(()=>{
    console.log(sessionStorage.getItem("id"));
    $("#playerId").text(sessionStorage.getItem("id"));
    console.log("JQUERY Activado");
    getPlayer();
    getTiradasJuego1();
    getTiradasJuego2();
    getTiradasJuego3();

});
function getPlayer(){
    let id = $("#playerId").text();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/"+id
    }).then((data)=>{
        console.log(data)
        $("#playerName").text("Player: " + data.nameCheckAnonim);
    });
}
function juego1(){
    let id = $("#playerId").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/players/"+id+"/games",
        success: function (response) {
            console.log("Game 1 played");
        }
    });
    location.reload();
}
function juego2(){
    let id = $("#playerId").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/players/"+id+"/games2",
        success: function (response) {
            console.log("Game 2 played");
        }
    });
    location.reload();
}
function juego3(){
    let id = $("#playerId").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/players/"+id+"/games3",
        success: function (response) {
            console.log("Game 3 played");
        }
    });
    location.reload();
}
function getTiradasJuego1(){
    let id = $("#playerId").text();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/"+id+"/games",
        
    }).then(function(data){
        console.log(data)
        $.each(data, (index) =>{
            $("#tiradasJuego1").append("<tr>");
            $("#tiradasJuego1").append("<td>" + data[index].dice1 + "</td>");
            $("#tiradasJuego1").append("<td>" + data[index].dice2 + "</td>");
            if(data[index].dice1+data[index].dice2 == 7){
                $("#tiradasJuego1").append("<td>Si</td>");
            }else{
                $("#tiradasJuego1").append("<td>No</td>");
            }
            $("#tiradasJuego1").append("</tr>");
        })
    })
}
function getTiradasJuego2(){
    let id = $("#playerId").text();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/"+id+"/games2",
        
    }).then(function(data){
        console.log(data)
        $.each(data, (index) =>{
            $("#tiradasJuego2").append("<tr>");
            $("#tiradasJuego2").append("<td>" + data[index].dice1 + "</td>");
            $("#tiradasJuego2").append("<td>" + data[index].dice2 + "</td>");
            if(data[index].dice1+data[index].dice2 == 8){
                $("#tiradasJuego2").append("<td>Si</td>");
            }else{
                $("#tiradasJuego2").append("<td>No</td>");
            }
            $("#tiradasJuego2").append("</tr>");

        })
    })
}
function getTiradasJuego3(){
    let id = $("#playerId").text();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/"+id+"/games3",
        
    }).then(function(data){
        console.log(data)
        $.each(data, (index) =>{
            $("#tiradasJuego3").append("<tr>");
            $("#tiradasJuego3").append("<td>" + data[index].dice1 + "</td>");
            $("#tiradasJuego3").append("<td>" + data[index].dice2 + "</td>");
            if(data[index].dice1+data[index].dice2 > 7){
                $("#tiradasJuego3").append("<td>Si</td>");
            }else{
                $("#tiradasJuego3").append("<td>No</td>");
            }
            $("#tiradasJuego3").append("</tr>");
        })
    })
}
function borrarTiradas1(){
    let id = $("#playerId").text();
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/players/"+id+"/games",
        
    })
    location.reload();
}
function borrarTiradas2(){
    let id = $("#playerId").text();
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/players/"+id+"/games2",
        
    })
    location.reload();
}
function borrarTiradas3(){
    let id = $("#playerId").text();
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/players/"+id+"/games3",
        
    })
    location.reload();
}
