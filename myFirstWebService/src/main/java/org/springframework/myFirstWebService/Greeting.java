//Resource Representation Class
//(Pojo with Fields, Constructor and Getters)

package org.springframework.myFirstWebService;

public class Greeting {
   
	private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
