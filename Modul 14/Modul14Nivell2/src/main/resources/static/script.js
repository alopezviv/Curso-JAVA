'use strict'
getTiendas();
$(document).ready(()=>{
    console.log("JQuery operativo");
    
    $('#formularioTienda').submit(function (e) { 
        e.preventDefault();
        postTienda();
        
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
            
            $('#cuerpoTabla').append('<tr class= "table table-success" >');
            $('#cuerpoTabla').append("<td >"+ data[index].id+"</td>");
            $('#cuerpoTabla').append("<td >"+ data[index].name+"</td>");
            $('#cuerpoTabla').append("<td '>"+ data[index].capacity+"</td>");
            $('#cuerpoTabla').append("<td >"+ data[index].picturesNumber+"</td>");
            $('#cuerpoTabla').append("<td ><button type='button' onclick='setButtons("+(index+1)+")' data-bs-toggle='collapse' data-bs-target='#collapse"+ (index+1) + "' aria-expanded='false' aria-controls='collapse"+ (index+1) + "'>Ver</button></td>");
            $('#cuerpoTabla').append("</tr>");
            getCuadros(index+1);
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
function setButtons(id){
    $('#shopId').val(id);
    $("#botonBorrarCuadros").attr("onclick","deleteCuadros("+id+")");
}
function getCuadros(id){
   $('#containerCuadros').append('<div class="collapse" id="collapse'+id+'"><div class="card card-body">'+'<table class="table" id="tablaCuadros" ><thead><th>ID<th>Autor <th>Fecha de entrada</thead><tbody id="cuerpoTablaCuadros'+id+'"> </tbody></table></div></div>')
    let idTabla = "#cuerpoTablaCuadros"+id;
   $.ajax({
        method: "GET",
        url: "http://localhost:8080/shops/"+id+"/pictures",
        dataType: "json",
        
    }).then((data)=>{
        $.each(data, (index) =>{
            $(idTabla).append('<tr >');
            $(idTabla).append("<td >"+ data[index].id+"</td>");
            $(idTabla).append("<td >"+ data[index].autor+"</td>");
            $(idTabla).append("<td '>"+ data[index].entranceDate+"</td>");
            $(idTabla).append("</tr>");

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
    location.reload();
}    
