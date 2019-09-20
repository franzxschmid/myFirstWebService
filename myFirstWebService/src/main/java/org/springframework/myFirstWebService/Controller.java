//Resource Controller (serves the Greetings)
//handles GET-Requests for "/page" by returning a new Instance of the Greeting-Class:

package org.springframework.myFirstWebService;

import java.util.concurrent.atomic.AtomicLong;
//Spring Imports
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//In Spring’s approach to building RESTful Web-Services, HTTP requests are handled by a Controller. 
@RestController
public class Controller {
    
	private static final String template = "Hello, %s!";
	private static final String template2 = "Tüdelü, %s!";
	private static final String template3 = "Skoal, %s!";
    private final AtomicLong counter = new AtomicLong();
    //=> Atomic for Synchronization

    @RequestMapping(method = RequestMethod.GET, value="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	// "@RequestParam" binds the value of the query string Parameter name into the name parameter 
    	// of the greeting() method. If the name parameter is absent in the request, the defaultValue 
    	// of "World" is used.
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/sendoff")
    public Greeting sendoff(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template2, name));
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/cheers")
    public Greeting cheers(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template3, name));
    }
   
    @RequestMapping(method = RequestMethod.GET, value="/page")
    public RessourceRepresentation page(@RequestParam(value="name", defaultValue="World") String name) {
        return new RessourceRepresentation(counter.incrementAndGet(), 
                String.format(template, name), "Ich bin noch ein zusätzlicher String");
    }
    
}
