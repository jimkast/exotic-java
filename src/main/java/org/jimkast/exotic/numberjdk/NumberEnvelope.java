package org.jimkast.exotic.numberjdk;

import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public class NumberEnvelope extends Number implements Scalar<Number> {
    private final UncheckedScalar<? extends Number> number;

    public NumberEnvelope(Scalar<? extends Number> number) {
        this(new UncheckedScalar<>(number));
    }

    public NumberEnvelope(UncheckedScalar<? extends Number> number) {
        this.number = number;
    }

    @Override
    public final int intValue() {
        return number.value().intValue();
    }

    @Override
    public final long longValue() {
        return number.value().longValue();
    }

    @Override
    public final float floatValue() {
        return number.value().floatValue();
    }

    @Override
    public final double doubleValue() {
        return number.value().doubleValue();
    }

    @Override
    public final byte byteValue() {
        return number.value().byteValue();
    }

    @Override
    public final short shortValue() {
        return number.value().shortValue();
    }

    @Override
    public Number value() {
        return number.value();
    }
}
