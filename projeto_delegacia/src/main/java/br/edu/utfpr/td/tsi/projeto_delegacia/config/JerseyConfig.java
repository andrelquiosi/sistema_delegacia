@Component
@ApplicationPath("/sistema_delegacia")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    this.register(RequestContextFilter.class);
    this.packages("br.com.edu.utfpr.td.tsi.projeto_delegacia.endpoint");
  }
}
