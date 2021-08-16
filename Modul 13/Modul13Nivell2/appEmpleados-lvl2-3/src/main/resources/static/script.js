'use strict'
$(document).ready(()=>{
    console.log("JQuery operativo");
    getEmpleados();
    $('#formularioRegistro').submit(function(e){
        e.preventDefault();
        send();
        location.reload();
    });
    $('#formularioModificacion').submit(function(e){
        e.preventDefault();
        let id = $('#idModificar').val();
        console.log(id);
        modificar(id);
        location.reload();
    });



})
function getEmpleados(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/getEmpleados",
        dataType: "json",
        
    }).then(function(data){
        console.log(data)
        $.each(data, (index) =>{
           
            $('#cuerpoTabla').append("<tr>");
            $('#cuerpoTabla').append("<td>"+ data[index].id+"</td>");
            $('#cuerpoTabla').append("<td>"+ data[index].name+"</td>");
            $('#cuerpoTabla').append("<td>"+ data[index].salary+"</td>");
            $('#cuerpoTabla').append("<td>"+ data[index].work+"</td>");
            $('#cuerpoTabla').append("<td><a href='#' onclick='deleteUsuario("+data[index].id+")'>BORRAR</a></td>");
            $('#cuerpoTabla').append('<td><a href="#" onclick="actualizaDatosModificar(\''+data[index].id+'\', \'' + data[index].name +'\', \'' + data[index].work + '\')">MODIFICAR</a></td>');
            $('#cuerpoTabla').append("</tr>");
        });
    })
}
function send(){
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/insertar",
        dataType: "json",
        data: $('#formularioRegistro').serialize(),
    })
    console.log($('#formularioRegistro').serialize())
    
}
function deleteUsuario(id){
    
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/delete/"+ id,
        dataType: "json",
        
    })
    location.reload();
}
function actualizaDatosModificar(id, name, work){
    $('#idModificar').val(id);
    $('#nombreModificar').val(name);
    if(work == "COMERCIAL"){
        $('#comercialModificar').attr("checked", "checked");
    }else{
        $('#administrativoModificar').attr("checked", "checked");
    }

}
function modificar(id){
    $.ajax({
        method: "PUT",
        url: "http://localhost:8080/update/"+id,
        dataType: "json",
        data: $('#formularioModificacion').serialize(),
    })
    console.log($('#formularioRegistro').serialize())
}