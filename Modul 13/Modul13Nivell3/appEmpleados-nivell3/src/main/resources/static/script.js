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
        modificar();
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
           
            $('#cuerpoTabla').append('<tr class="bg-dark text-light border border-light">');
            $('#cuerpoTabla').append("<td class='bg-dark text-light'>"+ data[index].id+"</td>");
            $('#cuerpoTabla').append("<td class='bg-dark text-light'>"+ data[index].name+"</td>");
            $('#cuerpoTabla').append("<td class='bg-dark text-light'>"+ data[index].salary+"</td>");
            $('#cuerpoTabla').append("<td class='bg-dark text-light'>"+ data[index].work+"</td>");
            $('#cuerpoTabla').append("<td class='bg-dark text-light'><a class='btn bg-secondary text-light' href='#' onclick='deleteUsuario("+data[index].id+")'>BORRAR</a></td>");
            $('#cuerpoTabla').append('<td class="bg-dark text-light"><a class="btn bg-secondary text-light" href="#" onclick="actualizaDatosModificar(\''+data[index].id+'\', \'' + data[index].name +'\', \'' + data[index].work + '\')">MODIFICAR</a></td>');
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
    if( $('#botonModificar').attr('aria-expanded') == "false"){
        $('#botonModificar').click();
    }
    if(work == "COMERCIAL"){
        $('#comercialModificar').attr("checked", "checked");
    }else{
        $('#administrativoModificar').attr("checked", "checked");
    }

}
function modificar(){
    $.ajax({
        method: "PUT",
        url: "http://localhost:8080/update",
        dataType: "json",
        data: $('#formularioModificacion').serialize(),
    })
    console.log($('#formularioRegistro').serialize())
}