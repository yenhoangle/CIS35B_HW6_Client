package scale;

public interface EditThread {
    public void updateOptionSetName(int threadNum, String key, String opsetName, String newOpsetName);
    public void updateOptionName(int threadNum, String key, String opsetName, String opName, String newOpName);
    public void updateOptionPrice(int threadNum, String key, String opsetName, String opName, float newPrice);
}
