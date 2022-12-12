import java.util.LinkedList;

public interface Sujeito {
    LinkedList<Object> observers = new LinkedList<>();

    public void assinar(Object obj);

    public void desistir();

    public void notificar();
}
