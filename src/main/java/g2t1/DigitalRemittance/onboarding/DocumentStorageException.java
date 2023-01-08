package g2t1.DigitalRemittance.onboarding;

public class DocumentStorageException extends Throwable {
    private String s;
    private Exception ex;

    public DocumentStorageException(String s, Exception ex) {
        this.s = s;
        this.ex = ex;
    }

    public DocumentStorageException(String s) {
        this.s = s;
    }
}
