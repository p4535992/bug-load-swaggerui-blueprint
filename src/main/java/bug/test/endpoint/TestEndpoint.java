package bug.test.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path("/test")
@Api(value = "/signatureservice", description = "Servizi ESB Rest API", authorizations = {@Authorization(value="basicAuth")})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestEndpoint {
	
	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestEndpoint.class);

	
	@GET
	@Path("/ping")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod(operationName = "ping")
	@WebResult(name = "Response")
	@ApiResponses(value = { 
        	@ApiResponse(code = 200, message = "Success") ,
        	@ApiResponse(code = 500, message = "Error") 
        }
	)
	@ApiOperation( "Get operation with Response and @Default value")
	public Response ping() {
		logger.info("PING SIGNATURE SERVICE");
		return Response.ok().entity("PING SIGNATURE SERVICE").build();
	}
}
