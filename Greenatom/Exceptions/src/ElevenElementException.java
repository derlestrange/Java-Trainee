public class ElevenElementException extends Exception {

    private String message;

    public ElevenElementException(){

    }

    public ElevenElementException(String message){
        this();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }

}
