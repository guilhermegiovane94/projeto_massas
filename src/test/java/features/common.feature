#language: pt
Funcionalidade: Gerar Massa
  Gera massa para as frente de liquidação

  @login
  Esquema do Cenario: : login
    Dado usuário está na tela "login"
    Quando insiro no campo "user" "<user>"
    E insiro no campo "password" "<password>"
    Entao clico no botão "login"
    Dado usuário está na tela "index"
    E valido o campo "usuario"
    Exemplos:
      | user                                | password    |
      |                                     |             |


  @massa
  Esquema do Cenario: login usuário
    #Dado usuário está na tela "index"
    #E valido o campo "usuario"
    #Entao clico no botão "drop projeto"
    #Entao clico no botão "visao geral"

    Dado usuário está na tela "project list"
    #E valido o campo "usuario"
    Entao clico no botão "ambiente"
    Entao seleciono lista "lista ambientes" "<ambiente>"
    Entao clico no botão "filtro"
    E insiro no campo "nome" "<pesquisa parceiro>"
    Entao clico no botão "enviar"
    Entao seleciono campo "projeto" na tabela com valor "<nome projeto>"
    Entao clico no botão "ciclo"

    #Dado usuário está na tela "project execution"
    E mudo de tela para "project execution"
   # E valido a url "project execution"
    Entao clico no botão "filtro"
    E insiro no campo "nome" "<caso de teste>"
    Entao clico no botão "enviar"
    E seleciono o campo "caso de teste"
    Entao clico no botão "executar teste"
    E valido o campo "resultado teste"
    E seleciono o campo "caso de teste"
    E adiciono header ao arquivo
    Entao clico no botão "lupa"
    Entao clico no botão "primeiro expand"
    Entao clico no botão "segundo expand"
    E recupero as linhas da transação
    E crio o arquivo
    E escrevo as informações no arquivo
    #Entao clico no botão "gerar log teste"

    Exemplos:
      | ambiente | pesquisa parceiro | nome projeto                                      | caso de teste |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0001 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0001 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0001 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0001 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0003 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0003 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0003 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0003 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0005 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0005 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0005 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0005 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0011 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0011 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0011 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0011 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0013 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0013 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0013 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0013 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0027 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0027 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0027 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0027 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0031 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0031 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0031 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0031 * |

      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0033 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0033 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0033 * |
      | Injetor  | *20.2*fitbank *   | JNL - 20.2 - EMS - FITBANK - Testes de Mobilidade | *CT070.0033 * |

