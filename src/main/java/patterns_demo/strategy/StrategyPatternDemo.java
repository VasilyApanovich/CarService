package patterns_demo.strategy;

import patterns_demo.strategy.impl.ConcreteEncryptionStrategy1;
import patterns_demo.strategy.impl.ConcreteEncryptionStrategy2;
import patterns_demo.strategy.impl.ConcreteEncryptionStrategy3;

/**
 * Created by apano on 10.03.2017.
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Encrypter encrypter = new Encrypter(new ConcreteEncryptionStrategy1());
        System.out.println(encrypter.encryptText("my text"));

        encrypter = new Encrypter(new ConcreteEncryptionStrategy2());
        System.out.println(encrypter.encryptText("my text"));

        encrypter = new Encrypter(new ConcreteEncryptionStrategy3());
        System.out.println(encrypter.encryptText("my text"));
    }
}
