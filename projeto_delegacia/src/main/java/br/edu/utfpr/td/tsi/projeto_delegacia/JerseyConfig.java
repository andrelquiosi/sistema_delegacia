package br.edu.utfpr.td.tsi.projeto_delegacia;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.endpoint.Endpoint;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("projeto_delegacia")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        this.register(Endpoint.class);

    }

}
