# Blackjack Java

Aplicacao multiplayer academica em Java com cliente Swing, servidor TCP e regras de Blackjack. A implementacao original concentra interface, sockets, temporizadores e regras em classes grandes. Esta versao inicia uma modernizacao incremental: o dominio do jogo foi isolado e passou a ser testado sem depender da interface grafica ou da rede.

## Arquitetura atual

```text
Clientes Swing / protocolo TCP legado
                 |
                 v
          RegrasBJ (fachada de compatibilidade)
                 |
                 v
             Hand + Card
                 |
                 +-- BlackjackRules
                 +-- Deck
                 +-- RoundResult
```

O pacote `blackjack.domain` contem o nucleo independente:

- `Card`: enum tipado para as cartas validas;
- `Hand`: mao com pontuacao de Aces flexiveis e deteccao de blackjack/bust;
- `Deck`: baralho de 52 cartas com fonte de aleatoriedade injetavel;
- `BlackjackRules`: comparacao entre jogador e dealer;
- `RoundResult`: resultado explicito da rodada.

`RegrasBJ` preserva os metodos usados por `Interface.java` (`GetCardTotal`, `CardHit` e `CheckBust`) e delega o comportamento ao novo dominio. Isso permite migrar a interface por etapas.

## Correcoes importantes

- comparacoes de cartas deixaram de usar `==` para strings;
- Aces podem valer 1 ou 11 sem causar estouro quando houver alternativa;
- o baralho usa 52 cartas, quatro copias de cada valor;
- o deck permite aleatoriedade deterministica em testes;
- resultados da rodada nao dependem de mensagens de texto;
- regras podem ser testadas sem abrir Swing ou sockets.

## Requisitos

- Java 8 ou superior;
- Maven 3.9 ou superior.

## Testes e build

```bash
mvn test
mvn package
```

A suite cobre:

- pontuacao de Aces;
- deteccao de bust;
- comparacao entre jogador e dealer;
- tamanho e exaustao do baralho;
- rejeicao de cartas inexistentes;
- compatibilidade da fachada `RegrasBJ` com a API legada.

## Execucao legada

A interface visual e o protocolo TCP original continuam nos arquivos da raiz. O servidor pode ser iniciado pela classe `Mesa` e o cliente pela classe `ExecutarJogador`, conforme o fluxo academico original. A execucao da interface nao faz parte do build automatizado porque ela ainda depende de classes Swing e codigo de rede legado que serao migrados separadamente.

O servidor usa a porta TCP `1993`. A comunicacao atual usa `ObjectInputStream` e `ObjectOutputStream`; para uma versao de producao, o protocolo deveria ser substituido por mensagens versionadas em JSON, WebSocket ou gRPC.

## Decisoes e proximos passos

1. Extrair a maquina de estados da rodada para um `GameService` sem Swing.
2. Substituir strings de protocolo por comandos e eventos tipados.
3. Separar servidor TCP, dominio e adaptador Swing.
4. Adicionar testes de integracao para conexao, timeout e desconexao.
5. Usar `java.time.Duration` para turnos temporizados.
6. Criar cliente web ou CLI sobre o mesmo dominio.
7. Adicionar Docker e GitHub Actions para build e testes.

## Limitacoes conhecidas

- a interface legada ainda concentra responsabilidades;
- o protocolo TCP nao possui versionamento nem autenticacao;
- o estado multiplayer ainda esta dentro do servidor Swing;
- nao ha persistencia de partidas;
- o temporizador original usa tarefas acopladas ao cliente;
- o dominio novo ainda nao foi conectado a todas as telas.

## Contexto

Projeto academico de Redes de Computadores. A modernizacao demonstra separacao gradual de dominio, compatibilidade com legado, testes automatizados e tratamento correto das regras de Blackjack.
