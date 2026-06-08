---- PROJETO INTEGRADOR ----

-- BASE DO PROJETO --

Utilizamos o esqueleto nos providenciado pelo professor, este esqueleto continha arquivos CSV com clientes e contatos, alem de um menu principal simples que nos utilizamos de base para criar cada menu subseção do projeto, menu este que é apenas utilizado para chamar as outras funções do projeto! Certificamos para que o main fique limpo de lógica e apenas fosse utilizado para começar e terminar o programa.

-- MATRIZES --

São duas matrizes simples de clientes e contatos com oito e cinco colunas respectivamente cada uma, os arquivos CSV povoam elas com informação e, como requisitado pelo professor, podem ser incluidos clientes e contatos novos, alem de poderem ser apagados e alterados.

-- AUMENTAR MATRIZ --

O aumentar matriz é bem simples ele basicamente cria uma nova matriz com um de tamanho a mais do que o anterior e copia todos os dados já colocados na antiga matriz. Se colocarmos isso dentro de um nenu solto por exemplo ele vai criar um espaço a mais porém não terá nenhum dado naquela linha, mas ao colocar em uma função que vá preencher esse espaço ele não dará nenhum erro.

-- RELATORIOS -- 

Alem da criação do menu de relatorios com 4 opções especificas, o relatorio foi idealizado de modo que: 
Total de clientes e contatos sejam retornados com um simples .lenght da matriz. 

A média foi facilmente calculada utilizando o total de clientes e contatos e dividindo um pelo outro (foi necessario transformar na função de calculo de média os dois totais em float para que o resultado não fosse arrendondado). 

Já o total sem contatos se trata de dois for-loops um dentro do outro que varrem a coluna id_cliente tanto na tabela cliente quanto na contatos, um booleano que é inicializado no começo do loop como false trata de descobrir se o numero da tabela de clientes (matrizClientes[i][0]) tambem se encontra na tabela contatos (matrizContatos[j][1]), se sim o booleano vira true e um break sai do for interno para o externo rodando novamente até que ele ache um id que não se encontra na tabela, se o booleano estiver false no final do primeiro loop o total de clientes sem contato aumenta em 1 (totalSemContatos++).

-- ORDENAÇÃO --

Para a ordenação de clientes: 
Foi primeiramente criado duas variaveis string para que elas obtessem o nome encontrado na coluna 1 da matriz, foi necessario utilizar math.min para que não ocorresse erro de out of bounds, utilizando charAt transforma-se o nome em caracteres para a comparação, comparação esta que ocorre dentro de um for do que corre pelo tamanho minimo do nome do cliente, logo apos isso é feito um bubble sort simples junto a uma variavel booleana que checa se o nome trocou de lugar, ele tambem checa se o nome ja é "menor" que o outro pulando para fora.

-- MENUS --

Se tratam nada alem de um switch que de acordo com a opção inserido pelo usuario no cursor, ira para a função de acordo com o numero desta opção. Foi necessario transformar os menus em matrizes tridimensionais com retorno para que as mudanças feitas na matriz clientes/contatos se mantivessem apos sair dos menus.

-- LISTAGEM DE MATRIZES --

A listagem de clientes e contatos é simples, apenas um for que trata das linhas da matriz,  e por saber-mos exatamente o tanto de colunas, utilizando o printf e %-(valor)f para melhor controle de tabulação das colunas, certificando-se que as duas matrizes sejam listadas de modo que não estejam amontoadas.

-- CONSULTA POR CODIGO -- 

A consulta de clientes por codigo e contatos por cliente é simples, basta de um scanner que pega o valor do codigo do cliente, compara ao codigo do cliente nas duas matrizes, checa os espaços onde o numero bate e imprime o cliente (utilizando a mesma base do listar para a impressão) tudo isto dentro de apenas um for que corre pelo tamanho de linhas da matriz.

-- INCLUIR -- 

Primerio usamos a função AumentarMatrizClientes para aumentar a matriz em +1 para que o cliente podesse ser incluído.
Definimos uma variável para que pudesse percorrer a matriz e encontrar qual fosse a última linha e então recebesse o código novo. E com isso foi necessário transformar a variável de int para String usando String.valueOf
Se a linha for igual a 1, o código vai ser 1 e acabou. Agora se for maior, a última linha irá receber o maior código agora.
Agora foi preciso criar um For para que o usuário percorresse as colunas dessa nova linha para preencher os dados do novo cliente ou contato.

-- EXCLUIR --

O exluirClientes começa pedindo qual o código do cliente que você deseja exluir após isso ele criar uma nova matriz com -1 espaço do que a matriz antiga e ele vai começar a varrer a matriz antiga sempre comparando se o codigo do cliente é diferente do que foi escolhido. Se a gente fizer isso em apenas um for comum irá dar erro porque quando ele chegar na libha com o código igual ele deixará aquela linha vazia e irá apagar o último cliente (o que não deveria ser feito), para consertar isso fizemos uma variável chamada linha que só aumentará se o código do cliente for diferente assim a linha não irá ser pulada e exluirá o cliente certo.
Agora para excluir todos os contatos daquele cliente foi criado uma função separada que irá primeiro comparar o código do cliente com os contatos e aumentará em 1 um contador para que assim ele seja utilizado para diminuir o número certo de linhas da matrizContatos, dessa forma seguindo a mesma lógica anterior ele irá apenas copiar a matriz antiga ignorando as que forem iguais o código do cliente.Agora para retornar essas duas matrizes foi utilizado uma matriz tridimensional para que possa ser retornado as duas matrizes
Agora para excluir apenas os contatos é bem simples ele apenas irá criar uma nova matriz de contatos com -1 linha e adicionar os dados antigos a essa nova matriz ignorando aquele que tenha o código de contato igual ao digitado.

-- PESQUISAR POR NOME --

O programa começa com o usuário digitando qual o nome que o usuário quer pesquisar.
Foi necessário converter o que o usuário digitou para caixa alta, pois assim todos seriam tratados de forma igual e que não houvesse erro.
Usando um For para percorrer a matriz, o programa irá identificar quantos caracteres iguais há na matriz e então armazenar o total deste valor numa variável.
Com base neste valor, foi preciso criar outra matriz somente para armazenar os nomes e os valores que os nomes possuem. Como estado, sexo, cidade e outras coisas.
Usando laço For e usando mais um contador, ele vai pegar a primeira linha, comparar os valores da matriz Clientes, e então armazerar os mesmos valores nessa nova matriz com o nome que foi pesquisado.

-- STATUS -- 

O cliente/contato pode vir tanto dos arquivos CSV quanto incluido com status ATIVO/INATIVO, como extra foi requisitado que nós criassemos um modo de ativar/inativar clientes ao inves de só ficar deletando todo mundo, a função é bem simples e se trata apenas de perguntar (scanner) qual o codigo do cliente que você deseja que seja ativado/desativado, este codigo sera guardado em uma variavel e depois com o uso de um for sera procurado dentro da tabela o codigo do cliente e logo apos sera inserido na coluna de status do cliente o status novo (ATIVO OU INATIVO). Para melhor interface de usuario tambem criamos um menu proprio para a alteração de status.
