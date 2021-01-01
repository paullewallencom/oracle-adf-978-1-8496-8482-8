package comp.packtpub.adfguide.ch9.view;

public class CustomViewExcpetion extends RuntimeException {
    public CustomViewExcpetion(Throwable throwable) {
        super(throwable);
    }

    public CustomViewExcpetion(String string, Throwable throwable) {
        super(string, throwable);
    }

    public CustomViewExcpetion(String string) {
        super(string);
    }

    public CustomViewExcpetion() {
        super();
    }
}
