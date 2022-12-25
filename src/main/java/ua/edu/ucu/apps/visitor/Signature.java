package ua.edu.ucu.apps.visitor;

import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public final Consumer<T> consumer;

    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    @Override
    public void stamp(Visitor<T> visitor) {
        visitor.onSignature(this);
        this.setHeader("signature", visitor.onSignature(this).get("signature"));
    }
}
