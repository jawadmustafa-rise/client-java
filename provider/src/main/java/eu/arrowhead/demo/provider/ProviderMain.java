package eu.arrowhead.demo.provider;

import eu.arrowhead.common.api.ArrowheadApplication;
import eu.arrowhead.common.api.server.ArrowheadGrizzlyHttpServer;
import eu.arrowhead.common.api.server.ArrowheadHttpServer;
import eu.arrowhead.common.api.ArrowheadSecurityContext;
import eu.arrowhead.common.api.clients.core.ServiceRegistryClient;
import eu.arrowhead.common.exception.NotFoundException;
import eu.arrowhead.common.model.ServiceRegistryEntry;

class ProviderMain extends ArrowheadApplication {

  public static void main(String[] args) {
    new ProviderMain(args).start();
  }

  public ProviderMain(String[] args) {
    super(args);
  }

  @Override
  protected void onStart() throws NotFoundException {
    final ArrowheadSecurityContext securityContext = ArrowheadSecurityContext.createFromProperties(true);
    final ArrowheadHttpServer server = ArrowheadGrizzlyHttpServer
            .createFromProperties(securityContext)
            .addResources(TemperatureResource.class, RestResource.class)
            .addPackages("eu.arrowhead.demo")
            .start();

    final ServiceRegistryClient registry = ServiceRegistryClient.createFromProperties(securityContext);
    registry.register(ServiceRegistryEntry.createFromProperties(server));
  }

  @Override
  protected void onStop() {
    
  }

}