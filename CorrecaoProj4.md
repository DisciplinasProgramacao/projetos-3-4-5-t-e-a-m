# Projeto 4 - Gestão de Frota (parte 2)

## Nota: 17

## Comentários
	- cuidado: nesta versão tem vários testes usando métodos que não existem
	- cuidado: método sem código? (custoVariável em Veículo)
	- cuidado: custo do Caminhao está calculando os fixos como se fossem variáveis
	- atenção: sem arquivo de veículos/rotas para teste do main
	- cuidado: está imprimindo valores errados de IPVA e seguro. Não entendi se está contando custo de abastecimento?
## Correção

### Modelagem: 2/2   
	- Modularização de tanque e combustível 
	
### Requisitos dos veículos, de acordo com a modelagem: 7/9  
	- Restrição de combustível: 2,5/3 -- recebe os combustíveis possíveis, mas não restringe (a classe pode ser usada fora do main...)?
	- Abastecimento e autonomia: 2/3 -- está lá, mas estava desencapsulado do tanque (SRP)
	- Custos fixos e variáveis: 2,5/3 -- cuidado com o conceito de 'variável': as manutenções são fixas. 
	
	
### Requisitos da empresa no programa principal: 8/9 
	- Quilometragem média das rotas da empresa: 3/3 
	- Filtro para busca de rotas por data: 2/3 - você não pode forçar o usuário a digitar um formato estranho só porque o tipo da linguagem é assim
	- Um dos dois abaixo: 3/3
		- Os 3 veículos que mais fizeram rotas 
		- Lista de veículos ordenada decrescentemente por custos gerados 

