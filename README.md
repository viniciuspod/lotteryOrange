# LotteryOrange

Este é o repositório do projeto LotteryOrange, que consiste em uma aplicação para gerenciamento de bilhetes de loteria.
desafio do processo seletivo para o programa Orange Talents da Zup.

## Endpoints

A aplicação possui os seguintes endpoints:

### /lottery_tickets

-Json de consumo
```JSON
{
  "bettor": {
    "email": "dants@gmail.com"
  }
}
```
- Método: GET
- Descrição: Retorna uma lista de bilhetes de loteria existentes para o email.
- Parâmetros:
  - Nenhum.
- Exemplo de resposta:
```JSON
[
	{
		"id": 5,
		"bet1": "38",
		"bet2": "14",
		"bet3": "62",
		"bet4": "76",
		"bettor": {
			"id": 2,
			"email": "dantas@gmail.com"
		}
	},
	{
		"id": 6,
		"bet1": "7",
		"bet2": "55",
		"bet3": "93",
		"bet4": "6",
		"bettor": {
			"id": 2,
			"email": "dantas@gmail.com"
		}
	}
]
```	
- Método: POST
- Descrição: Cria um novo bilhete de loteria.
- Parâmetros:
  - Nenhum.
- Exemplo de resposta:
```JSON
{
	"id": 8,
	"bet1": "98",
	"bet2": "73",
	"bet3": "50",
	"bet4": "43",
	"bettor": {
		"id": 3,
		"email": "dantas@gmail.com"
	}
}
```	
## Contribuição

Contribuições para este projeto são bem-vindas. Se você encontrar algum problema, tiver alguma sugestão ou quiser adicionar um novo recurso, sinta-se à vontade para abrir uma nova issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).