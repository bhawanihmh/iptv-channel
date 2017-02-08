package iptv.channel.rest;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iptv.channel.pojo.Channel;

/**
 * 
 * @author bhawani.singh
 *
 */
@Path("channel")
public class ChannelREST {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(ChannelREST.class.getName());

	private static HashMap<String,Channel> channels = new HashMap<String,Channel>();	
	
	static {
		
		for(int i=0; i<=10; i++){
			channels.put(""+i, new Channel(""+i, "CHAN"+i));
		}
		
	}	
	
	@GET
    @Path("{id}")
    @Produces({"application/json"})
    public Channel find(@PathParam("id") String id) {	
		LOGGER.info("ChannelREST.record() id = " + id);
		return channels.get(id);
	}
	
	@GET
	@Path("hi")
    //@Produces({"application/xml", "application/json"})
	@Produces({MediaType.TEXT_PLAIN})
    public String hi() {
		LOGGER.info("ChannelREST.hi()");
		return "Hello World !!!";
	}


}
