package org.springframework.myFirstWebService;

public class RessourceRepresentation extends Greeting{
	
    private final String otherContent;

    //Constructor calls the Parent-Constructor
    public RessourceRepresentation(long id, String content, String otherContent) {
        super(id, content);
        this.otherContent = otherContent;
    }
    
    public String getOtherContent(){
    	return otherContent;
    }
    
}
