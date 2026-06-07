---- PROJETO INTEGRADOR ----

Colocar aqui o que foi feito :P

-- RELATORIOS -- 

Alem da criação do menu de relatorios com 4 opções especificas, o relatorio foi idealizado de modo que: 
Total de clientes e contatos sejam retornados com um simples .lenght da matriz. 

A média foi facilmente calculada utilizando o total de clientes e contatos e dividindo um pelo outro (foi necessario transformar na função de calculo de média os dois totais em float para que o resultado não fosse arrendondado). 

Já o total sem contatos se trata de dois for-loops um dentro do outro que varrem a coluna id_cliente tanto na tabela cliente quanto na contatos, um booleano que é inicializado no começo do loop como false trata de descobrir se o numero da tabela de clientes (matrizClientes[i][0]) tambem se encontra na tabela contatos (matrizContatos[j][1]), se sim o booleano vira true e um break sai do for interno para o externo rodando novamente até que ele ache um id que não se encontra na tabela, se o booleano estiver false no final do primeiro loop o total de clientes sem contato aumenta em 1 (totalSemContatos++).

-- ORDENAÇÃO --

Para a ordenação de clientes: 
Foi primeiramente criado duas variaveis string para que elas obtessem o nome encontrado na coluna 1 da matriz, foi necessario utilizar math.min para que não ocorresse erro de out of bounds, utilizando charAt transforma-se o nome em caracteres para a comparação, comparação esta que ocorre dentro de um for do que corre pelo tamanho minimo do nome do cliente, logo apos isso é feito um bubble sort simples junto a uma variavel booleana que checa se o nome trocou de lugar, ele tambem checa se o nome ja é "menor" que o outro pulando para fora.

-- CONSULTA --

A consulta de clientes por codigo e contatos por cliente é simples, basta de um scanner que pega o valor do codigo do cliente, compara ao codigo do cliente nas duas matrizes, checa os espaços onde o numero bate e imprime o cliente (utilizando a mesma base do listar para a impressão) tudo isto dentro de apenas um for que corre pelo tamanho de linhas da matriz.

-- INCLUIR -- 
Primerio usamos a função AumentarMatrizClientes para aumentar a matriz em +1 para que o cliente podesse ser incluído.
Definimos uma variável para que pudesse percorrer a matriz e encontrar qual fosse a última linha e então recebesse o código novo. E com isso foi necessário transformar a variável de int para String usando String.valueOf
Se a linha for igual a 1, o código vai ser 1 e acabou. Agora se for maior, a última linha irá receber o maior código agora.
Agora foi preciso criar um For para que o usuário percorresse as colunas dessa nova linha para preencher os dados do novo cliente ou contato.
