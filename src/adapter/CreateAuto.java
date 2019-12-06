package adapter;
import exception.AutoException;

public interface CreateAuto {
    public void buildAuto(String filename) throws AutoException;
    public void printAuto(String filename);
}
