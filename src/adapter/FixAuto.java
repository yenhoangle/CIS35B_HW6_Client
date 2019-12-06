package adapter;
import exception.AutoException;

public interface FixAuto {
    public void fix(int errno) throws AutoException;
}
