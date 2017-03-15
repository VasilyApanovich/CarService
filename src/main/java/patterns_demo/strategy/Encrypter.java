package patterns_demo.strategy;

import patterns_demo.strategy.abstr.IEncryptionStrategy;

/**
 * Created by apano on 10.03.2017.
 */
public class Encrypter {

    private IEncryptionStrategy strategy;

    public Encrypter(IEncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public String encryptText(String text) {
        return strategy.encryptText(text);
    }
}
