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
    @Path("{id}/{flag}")
    @Produces({"application/json"})
    public Channel find(@PathParam("id") String id,@PathParam("flag") boolean flag) {	
		LOGGER.info("Channel id = " + id);
		LOGGER.info("Channel flag = " + flag);
		if(flag) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Channel channel = channels.get(id);
		channel.setFallBack(false);
		return channel;
	}
	
	@GET
	@Path("hi")
    //@Produces({"application/xml", "application/json"})
	@Produces({MediaType.TEXT_PLAIN})
    public String hi() {
		LOGGER.info("ChannelREST.hi()");
		return "Hello Bhawani !!!";
	}


}
