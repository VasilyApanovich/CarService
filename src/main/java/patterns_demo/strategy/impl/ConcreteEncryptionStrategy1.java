package patterns_demo.strategy.impl;

import patterns_demo.strategy.abstr.IEncryptionStrategy;

/**
 * Created by apano on 10.03.2017.
 */
public class ConcreteEncryptionStrategy1 implements IEncryptionStrategy {
    @Override
    public String encryptText(String text) {
        return text + " encrypted with strategy1";
    }
}
