package control;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notificar(String noticia);
}
