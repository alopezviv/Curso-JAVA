'use strict'
$(document).ready(()=>{
    console.log("JQuery operativo");
    getTiendas();
    $('#formularioTienda').submit(function (e) { 
        e.preventDefault();
        postTienda();
        location.reload();
    });
    $('#formularioCuadro').submit(function (e) { 
        e.preventDefault();
        let id = $('#shopId').val();
        postCuadro(id);
        location.reload();
    });
})

function getTiendas(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/shops",
        data: "data",
        dataType: "json",
    }).then(function(data){
        $.each(data, (index) =>{
            
            $('#cuerpoTabla').append('<tr >');
            $('#cuerpoTabla').append("<td >"+ data[index].id+"</td>");
            $('#cuerpoTabla').append("<td >"+ data[index].name+"</td>");
            $('#cuerpoTabla').append("<td '>"+ data[index].capacity+"</td>");
            $('#cuerpoTabla').append("<td >"+ data[index].picturesNumber+"</td>");
            $('#cuerpoTabla').append("<td ><button onclick='getCuadros("+data[index].id+")'>Ver</button></td>");
            $('#cuerpoTabla').append("</tr>");
        })
    }); 
}

function postTienda(){
    
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/shops",
        dataType: "json",
        data: $('#formularioTienda').serialize(),
        
    });
}   
function getCuadros(id){
   $('#tablaCuadros').css("display","block");
   $('#formularioCuadro').css("display","block");
   $('#shopId').val(id);
   $("#botonBorrarCuadros").attr("onclick","deleteCuadros("+id+")");
   $.ajax({
        method: "GET",
        url: "http://localhost:8080/shops/"+id+"/pictures",
        dataType: "json",
        
    }).then((data)=>{
        $.each(data, (index) =>{
            $('#cuerpoTablaCuadros').append('<tr >');
            $('#cuerpoTablaCuadros').append("<td >"+ data[index].id+"</td>");
            $('#cuerpoTablaCuadros').append("<td >"+ data[index].autor+"</td>");
            $('#cuerpoTablaCuadros').append("<td '>"+ data[index].entranceDate+"</td>");
            $('#cuerpoTablaCuadros').append("</tr>");
        })    
    });
    
}
function postCuadro(id){
    
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/shops/"+id+"/pictures",
        dataType: "json",
        data: $('#formularioCuadro').serialize(),
        
    });
}  
function deleteCuadros(id){
    
    $.ajax({
        method: "DELETE",
        url: "http://localhost:8080/shops/"+id+"/pictures",
        dataType: "json",
        
    });
}    
