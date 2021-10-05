$(document).ready(()=>{
    console.log("JQUERY Activado")
    $("#formRegistroUsuario").submit(function (e) { 
        e.preventDefault();
        postPlayer();
    });
    winner1();
    winner2();
    winner3();
    losser1();
    losser2();
    losser3();
    globalRanking();
    globalRanking2();
    globalRanking3();
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
function winner1(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/winner",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#winner1").text(data.nameCheckAnonim);
    })
}
function winner2(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/winner2",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#winner2").text(data.nameCheckAnonim);
    })
}
function winner3(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/winner",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#winner3").text(data.nameCheckAnonim);
    })
}
function losser1(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/losser",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#losser1").text(data.nameCheckAnonim);
    })
}
function losser2(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/losser2",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#losser2").text(data.nameCheckAnonim);
    })
}
function losser3(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking/losser3",
        
    }).then(function(data){
        console.log(data.nameCheckAnonim)
        $("#losser3").text(data.nameCheckAnonim);
    })
}
function globalRanking(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking",
        
    }).then(function(data){
        console.log(data)
        $("#globalRanking1").text(data + "%");
    })
}
function globalRanking2(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking2",
        
    }).then(function(data){
        console.log(data)
        $("#globalRanking2").text(data + "%");
    })
}
function globalRanking3(){
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/players/ranking3",
        
    }).then(function(data){
        console.log(data)
        $("#globalRanking3").text(data + "%");
    })
}