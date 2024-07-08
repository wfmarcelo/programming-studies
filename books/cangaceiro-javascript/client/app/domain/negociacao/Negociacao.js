System.register(['../../util'], function (_export, _context) {
    "use strict";

    var obrigatorio;
    return {
        setters: [function (_util) {
            obrigatorio = _util.obrigatorio;
        }],
        execute: function () {
            let Negociacao = class Negociacao {

                constructor(data = obrigatorio('data'), quantidade = obrigatorio('quantidade'), valor = obrigatorio('valor')) {

                    this._data = new Date(data.getTime());
                    this._quantidade = quantidade;
                    this._valor = valor;
                    Object.freeze(this);
                }

                get volume() {
                    return this.quantidade * this.valor;
                }

                get data() {
                    return new Date(this._data.getTime());
                }

                get quantidade() {
                    return this._quantidade;
                }

                get valor() {
                    return this._valor;
                }

                equals(negociacao) {
                    return JSON.stringify(this) == JSON.stringify(negociacao);
                }
            };

            _export('Negociacao', Negociacao);
        }
    };
});
//# sourceMappingURL=Negociacao.js.map