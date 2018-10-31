package org.jimkast.ooj.map;

import java.util.Arrays;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.target.RefQueue;

public final class Any<K, V> implements PMapping<K, V> {
    private final Iterable<PMapping<K, V>> all;
//    private final Source<PMapping<K, V>> all;

    @SafeVarargs
    public Any(PMapping<K, V>... all) {
        this(Arrays.asList(all));
    }
//
//    public Any(Source<PMapping<K, V>> all) {
//        this.all = all;
//    }

    public Any(Iterable<PMapping<K, V>> all) {
        this.all = all;
    }

    @Override
    public Source<V> map(K key) {
        RefQueue<V> ref = new RefQueue<>();
        for (PMapping<K, V> mapping : all) {
            mapping.map(key).feed(ref);
            if(ref.length() == 1) {
                return new Source.Fixed<>(ref.map(0));
            }
        }
        return new Source.Empty<>();

//        return new PsFlattened<>(
//            new PsMapped<>(
//                p -> p.map(key),
//                all
//            )
//        );
    }
}
