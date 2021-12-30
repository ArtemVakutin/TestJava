package reflection2.di;

public class InvalidConfigurationException extends Throwable {
    public InvalidConfigurationException(String node_name_failed) {
        super(node_name_failed);
    }
}
