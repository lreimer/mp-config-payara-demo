package cloud.nativ.javaee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("config-property")
@Produces(MediaType.APPLICATION_JSON)
public class ConfigPropertyResource {

    @Inject
    private ConfigPropertyBean configPropertyBean;

    @GET
    @Path("hostname")
    public Response getHostname() {
        return Response.ok(configPropertyBean.getHostname()).build();
    }

    @GET
    @Path("a.dynamic.string")
    public Response getDynamicString() {
        return Response.ok(configPropertyBean.getDynamicString()).build();
    }

    @GET
    @Path("a.optional.string")
    public Response getOptionalString() {
        return Response.ok(configPropertyBean.getOptionalString().orElse("undefined")).build();
    }

    @GET
    @Path("a.json.object")
    public Response getJsonObject() {
        return Response.ok(configPropertyBean.getJsonObject()).build();
    }

    @GET
    @Path("a.long")
    public Response getLong() {
        return Response.ok(configPropertyBean.getLong()).build();
    }

    @GET
    @Path("a.string.array")
    public Response getStringArray() {
        return Response.ok(configPropertyBean.getStringArray()).build();
    }
}
