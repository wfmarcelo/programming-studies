export class ProxyFactory {


    static create(objeto, props, armadilha) {
        return new Proxy(objeto, {
            get(target, prop, receiver) {
                if (ProxyFactory._isFunction(target[prop]) &&
                    props.includes(prop)) {

                    return function () {
                        target[prop].apply(target, arguments);
                        armadilha(target);
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

    static _isFunction(fn) {
        return typeof(fn) == typeof(Function);
    }
}