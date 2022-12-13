# Projeto 5 - Gestão de Frota (final)

## Nota: 15

**A nota final** se dará pela soma acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Este peso é atribuído **individualmente**. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”
	
## Comentários
A exceção que tem é no pior lugar possível: ao buscar um veículo é uma condição válida não encontrá-lo.

Observer está implementado na estrutura, porém não com a melhor ideia: veja que para ter os veículos atualizados assim constantemente a cada modificação, melhor seria ter uma fila de priordades. Válido para o projeto, de toda forma

O main pode ser bem mais modularizado! Além dos 'cases' enormes, vejam a repetição de código de escolha de combustível das linhas 75 a 115. 

## Correção

### Modelagem: 1,5/2
	- constantes -> enum nas classes filhas
	
	
### Persistência de dados: 3/4   
	- arquivo de teste: 1/1
	- salvar e carregar: 2/3 (carregou mas não salvou inclusões)

### Robustez: 1,5/4
	- menu principal: 0/1 (dá exceção no menu)
	- regras inválidas do projeto: 1,5/3 (deixa passar diesel em carro; deixa passar rota inválida com print em classe de negócio; exceções genéricas em todo lado)
	
### Padrão de projeto implementado: 4/5
	- sem implementação de 'desistir'
	
	
	
### Documentação e apresentação:  5/5 pontos
	- nota individual de acordo com a documentação e participação do aluno nas apresentações realizadas ao longo do Projeto

