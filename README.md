---- PROJETO INTEGRADOR ----

Colocar aqui o que foi feito :P

-- RELATORIOS -- 

Alem da criação do menu de relatorios com 4 opções especificas, o relatorio foi idealizado de modo que: 
Total de clientes e contatos sejam retornados com um simples .lenght da matriz. 

A média foi facilmente calculada utilizando o total de clientes e contatos e dividindo um pelo outro (foi necessario transformar na função de calculo de média os dois totais em float para que o resultado não fosse arrendondado). 

Já o total sem contatos se trata de dois for-loops um dentro do outro que varrem a coluna id_cliente tanto na tabela cliente quanto na contatos, um booleano que é inicializado no começo do loop como false trata de descobrir se o numero da tabela de clientes (matrizClientes[i][0]) tambem se encontra na tabela contatos (matrizContatos[j][1]), se sim o booleano vira true e um break sai do for interno para o externo rodando novamente até que ele ache um id que não se encontra na tabela, se o booleano estiver false no final do primeiro loop o total de clientes sem contato aumenta em 1 (totalSemContatos++).

-- ORDENAÇÃO --

NÃO TENHO A MINIMA IDEA DO POR QUE O BUBBLE SORT NÃO VAI ;(