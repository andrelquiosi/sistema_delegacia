package br.edu.utfpr.td.tsi.projeto_delegacia.config;
import org.springframework.stereotype.Component;
import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;
import org.springframework.web.filter.RequestContextFilter;

@Component
@ApplicationPath("/sistema_delegacia")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    this.register(RequestContextFilter.class);
    this.packages("br.com.edu.utfpr.td.tsi.projeto_delegacia.endpoint");
  }
}
