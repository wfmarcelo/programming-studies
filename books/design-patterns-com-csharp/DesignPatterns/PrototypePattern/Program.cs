﻿using PrototypePattern;

GerenciadorNuvens gerenciadorNuvens = new GerenciadorNuvens();

gerenciadorNuvens["padrão"] = new NuvemConcreta("branco", "azul");
gerenciadorNuvens["personalizada"] = new NuvemConcreta("branco", "laranja");

NuvemConcreta? um = gerenciadorNuvens["padrão"].Clone() as NuvemConcreta;
NuvemConcreta? dois = gerenciadorNuvens["padrão"].Clone() as NuvemConcreta;
NuvemConcreta? tres = gerenciadorNuvens["personalizada"].Clone() as NuvemConcreta;