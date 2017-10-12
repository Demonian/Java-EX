package xdean.jex.extra.rx2.nullable.source;

import io.reactivex.Observable;

import java.util.Optional;

import xdean.jex.extra.rx2.nullable.handler.NullHandler;
import xdean.jex.extra.rx2.nullable.handler.NullHandlers;

public interface NullableObservable<F> {
  <T> Observable<T> handler(NullHandler<F, T> handler);

  default Observable<F> onNullDrop() {
    return handler(NullHandlers.drop());
  }

  default Observable<Optional<F>> onNullWrap() {
    return handler(NullHandlers.wrap());
  }

  default Observable<F> onNullDefault(F defaultValue) {
    return handler(NullHandlers.defaultValue(defaultValue));
  }

  default Observable<F> onNullRun(Runnable action) {
    return handler(NullHandlers.run(action));
  }
}