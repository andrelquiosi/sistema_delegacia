Path("teste")

public class TesteEndPoint {

    @GET
    public Response teste() {

    return Response.ok("Teste bem sucedido").build();
    
    }

}