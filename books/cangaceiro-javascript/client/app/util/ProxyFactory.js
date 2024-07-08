export class ProxyFactory {


    static create(objeto, props, armadilha) {
        return new Proxy(new Negociacoes(), {
            get(target, prop, receiver) {
                if (ProxyFactory.#isFunction(target[prop]) &&
                    props.includes(prop)) {

                    return function () {
                        target[prop].apply(target, arguments);
                        armadilha(target);
                    }

                } else if (ProxyFactory.#isFunction(target[prop])) {
                    return function () {
                        return target[prop].apply(target, arguments);
                    }
                } else {
                    return target[prop];
                }
            },
            set(target, prop, value, receiver) {
                const updated = Reflect.set(target, prop, value);

                if (props.includes(prop))
                    armadilha(target);

                return updated;
            }
        });
    }

    static #isFunction(fn) {
        return typeof(fn) == typeof(Function);
    }
}