var cadastrar = function(url) {
  var bo = {
	dataOcorrencia: $("#data").val(),
	periodoOcorrencia: $("#periodo").val(),
	localOcorrencia: {
		logradouro: $("#logradouro").val(),
		numero: $("#numero").val(),
		bairro: $("#bairro").val(),
		cidade: $("#cidade").val(),
		estado: $("#estado").val()			
	},
	veiculoFurtado:{
		emplacamento: {
			placa: $("#placa").val(),
			cidade: $("#cidadePlaca").val(),
			estado: $("#estadoPlaca").val()				
		},
		anoFabricacao: $("#ano").val(),	
		cor: $("#cor").val(),	
		marca: $("#marca").val(),	
		tipoVeiculo: $("#tipo").val()	
	},
	partes: [{
		nome: $("#nome").val(),
		email: $("#email").val(),
		telefone: $("#telefone").val(),
		tipoEnvolvimento: "Vítima"			
	}]		
  };
  
  $.ajax({
    url: url,
    type: 'POST',
    async: true,
    contentType: 'application/json',
    data: JSON.stringify(bo),
    success: function(boCadastrado) {
      $("#resultado").empty();
      $("#resultado").html("Boletim cadastrado com sucesso! <br> Identificador: " + boCadastrado.identificador);

    },
    error: function(xhr, status, error) {
      $("#resultado").empty();
      $("#resultado").append("Erro ao cadastrar: " + xhr.responseText)
    }
  });
};



$(document).ready(function() {
  $("#botaoCadastrar").click(function() {
    cadastrar("http://localhost:8080/delegacia/bo-furto-veiculo");
  }); 
});
