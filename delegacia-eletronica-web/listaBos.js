var listarProcessos = function() {
    $.ajax({
        url: "http://localhost:8080/delegacia/bo-furto-veiculo",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function(boletins) {
			$("#loading").hide();
            limparTabela();
            $.each(boletins, function(index, bo) {   
					var novaLinha =
                    '<tr>' +
                    '<td class="org-left">' + bo.identificador + '</td>' +
                    '<td style="text-align: center">' + bo.dataOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.localOcorrencia.cidade + '</td>' +
                    '<td style="text-align: center">' + bo.periodoOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.marca + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.emplacamento.placa + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.cor +'</td>' +
                    '</tr>';
                $("#tabelaBos tr:last").after(novaLinha);
            });
        },
        error: function() {

        }
    });
};

var limparTabela = function() {
    $("#tabelaBos").find("tr:gt(0)").remove();
}

var consultar = function(urlContato) {
    sessionStorage.setItem("urlContato", urlContato);
    window.location.href = "consulta.html";
}

$(document).ready(function() {
    listarProcessos();    
});