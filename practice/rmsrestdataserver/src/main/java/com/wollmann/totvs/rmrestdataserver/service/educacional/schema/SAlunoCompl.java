package com.wollmann.totvs.rmrestdataserver.service.educacional.schema;

import java.util.Date;

public record SAlunoCompl(
    String id,
    String parent_id,
    Short codcoligada,
    String ra,
    String senha,
    String instituicao,
    Date dataconclusao,
    String art170,
    String reccreatedby,
    Date reccreatedon,
    String recmodifiedby,
    Date recmodifiedon,
    String rubeola,
    String whatsapp,
    String facebook,
    String enem_insc,
    String enem_ano,
    String enem_redacao,
    String enem_humanas,
    String enem_natureza,
    String enem_linguagens,
    String enem_matematica,
    Date dtes,
    String nies,
    String alunoinativo,
    String doc_conferido,
    String cracha,
    String diplomaintmaiscampus,
    String deficiencia,
    String ralyceum,
    String not_comunicacao,
    String membrodce

) {

}
