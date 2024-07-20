using minhascontas.domain.ContaAgreggation;

namespace minhascontas.domain.CartaoCreditoAggregation;

public record class CartaoCredito(
    Guid Id,
    string Nome,
    byte[] Icon,
    decimal Limite,
    int DiaFechamento,
    int DiaVencimento,
    Conta ContaDefaultPagamento);
