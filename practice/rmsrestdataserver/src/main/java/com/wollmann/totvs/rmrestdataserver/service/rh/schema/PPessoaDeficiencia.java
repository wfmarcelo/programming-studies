package com.wollmann.totvs.rmrestdataserver.service.rh.schema;

public record PPessoaDeficiencia(
    String id,
    String parent_id,
    Integer coddeficiencia,
    Integer codpessoa,
    Integer codtipodeficiencia,
    String descricao,
    String desctipodeficiencia

) {

}
