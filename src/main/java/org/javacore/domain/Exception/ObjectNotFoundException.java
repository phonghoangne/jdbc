package org.javacore.domain.Exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(){
        super();
    }
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
