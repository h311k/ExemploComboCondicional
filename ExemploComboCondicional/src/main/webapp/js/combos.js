$(document).ready(function() {
  carregaEstados();
  atualizaComboCidades();
});

/*
* preenche a combo com as ofertas
*/
function carregaEstados() {
  $.ajax({
    url: '../estado/lista',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json; charset=utf-8'
  })
  .done(function(data) {
    ESTADOS = JSON.parse(data.entity);
    console.log(ESTADOS);
    $.each(ESTADOS, function(index, el) {
      $('#selecionar-estado').append('<option value='+index+'>'+el.nome+'</option>');
    });
  })
  .fail(function() {
    console.log("error");
  })
  .always(function() {
    console.log("complete");
  });
}

function atualizaComboCidades() {
  $('#selecionar-estado').change(function(event) {
    $('#selecionar-cidade').find('option').remove();
    $.ajax({
      url: '../cidade/lista',
      type: 'POST',
      dataType: 'json',
      data: JSON.stringify(ESTADOS[$('#selecionar-estado').val()]),
      contentType: 'application/json; charset=utf-8'
    })
    .done(function(data) {
      console.log(data);
      CIDADES = data.entity;
      console.log(CIDADES);
      $.each(data.entity, function(index, el) {
        $('#selecionar-cidade').append('<option value='+index+'>'+el.nome+'</option>');
      });
    })
    .fail(function() {
      console.log("error");
    })
    .always(function() {
      console.log("complete");
    });
  });
}
