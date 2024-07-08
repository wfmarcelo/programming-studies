import { ConnectionFactory } from "./ConnectionFactory";

function getNegociacaoDao() {
    return ConnectionFactory
        .getConnection()
        .then(conn => new NegociacaoDao(conn));
}
