package so.dang.cool;

import so.dang.cool.jumble.Pile;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Tsume<PREV extends Tsume<?, ?>, A> {
    static Nothing init() {
        return new Nothing();
    }

    class Nothing implements Tsume<Nothing, Void> {
        public <B> OneThing<Nothing, B> s(B b) {
            return new OneThing<>(this, b);
        }
    }

    class OneThing<PREV extends Tsume<?, ?>, A> implements Tsume<PREV, A> {
        PREV prev;
        private final A a;

        OneThing(PREV prev, A a) {
            this.prev = prev;
            this.a = a;
        }

        public <B> TwoOrMoreThings<PREV, A, B> s(B b) {
            return new TwoOrMoreThings<>(prev, a, b);
        }

        public <B> OneThing<PREV, B> f(Function<A, B> fn) {
            return new OneThing<>(prev, fn.apply(a));
        }

        public A top() {
            return a;
        }
    }

    class TwoOrMoreThings<PREV extends Tsume<?, ?>, A, B> implements Tsume<Tsume<PREV, A>, B> {
        private final PREV prev;
        private final A a;
        private final B b;

        public TwoOrMoreThings(PREV prev, A a, B b) {
            this.prev = prev;
            this.a = a;
            this.b = b;
        }

        public <C> TwoOrMoreThings<OneThing<PREV, A>, B, C> s(C c) {
            OneThing<PREV, A> nextPrev = new OneThing<>(prev, a);
            return new TwoOrMoreThings<>(nextPrev, b, c);
        }

        public <C> TwoOrMoreThings<PREV, A, C> f(Function<B, C> fn) {
            return new TwoOrMoreThings<>(prev, a, fn.apply(b));
        }

        public <C> OneThing<PREV, C> f(BiFunction<A, B, C> bifn) {
            return new OneThing<>(prev, bifn.apply(a, b));
        }

        public B top() {
            return b;
        }
    }
}
