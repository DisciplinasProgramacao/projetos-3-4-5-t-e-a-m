# Especifique aqui seu plano de testes, no formato:

Veiculo:
1. Puxar a placa
  - testGetPlaca()
2. Retornar o valor do ipva
  - testValorIpva()
3. Retornar o valor do seguro
  - testValorSeguro()
4. Retornar o valor de todos os custos
  - testOutrosCustos()
5. Adicionar rota
  - addRota(double distanciaTotal, Combustivel combustivel)
6. Retornar a média de km das rotas
  - testKmMediaDasRotas()
7. Imprimir rotas
  - testImprimeRotas()
8. Imprimir as rotas de acordo com a data
  - testImprimeRotasData()
9. Retornar o número de rotas
  - testGetNumRotas()

Carro:
10. Retornar o valor do ipva
  - testValorIpva()
11. Retornar o valor do seguro
  - testValorSeguro()
12. Retornar o valor de todos os custos
  - testOutrosCustos()

Caminhao:
13. Retornar o valor do ipva
  - testValorIpva()
14. Retornar o valor do seguro
  - testValorSeguro()
15. Retornar o valor de todos os custos
  - testOutrosCustos()

Furgao:
16. Retornar o valor do ipva
  - testValorIpva()
17. Retornar o valor do seguro
  - testValorSeguro()
18. Retornar o valor de todos os custos
  - testOutrosCustos()
 
Van:
19. Retornar o valor do ipva
  - testValorIpva()
20. Retornar o valor do seguro
  - testValorSeguro()
21. Retornar o valor de todos os custos
  - testOutrosCustos()

Tanque:
22. Verificar a autonomia máxima
  - autonomiaMaxima(Combustivel combustivel)
23. Verificar a autonomia
  - autonomia(Combustivel combustivel)
24. Retornar a quantidade atual
  - getQuantAtual()
25. Retornar a capacidade
  - getCapacidade()
26. Retornar os combustíveis
  - getCombustiveis()
27. Abastecer o veículo
  - abastecer()
28. Consumir o combustivel de acordo com a distância
  - consumir(Combustivel combust, double distancia)

Combustível:
29. Retornar a descrição
  - getDescricao()
30. Retornar o consumo
  - getConsumo()
31. Retornar o preço
  - getPreco()
32. Retornar a capacidade
  - getCapacidade()
33. Verificar o valor abastecido de acordo com a distância
  - valorAbastecimento(int distancia)

Frota:
34. Carregar o veículo
  - carregarVeiculo(String nomeArquivo)
35. Salvar o veículo no arquivo
  - salvarVeiculo(String nomeArquivo)
36. Adicionar o veículo
  - addVeiculo(Veiculo veiculo)
37. Localizar o veículo de acordo com a placa
  - localizaVeiculo(String placaProcurar)
38. Imprimir o relatório 
  - imprimirRelatorio()
39. Mostrar a média de consumo de combustível das rotas
  - mediaConsumoRotas()
40. Imprimir os trem maiores números de rotas de acordo com o veículo
  - imprimeTresMaiores()
41. Imprimir as rotas
  - imprimirRotas()
42. Filtrar a frota de acordo com a data
  - filtrarFrotaPorData(LocalDate date)
