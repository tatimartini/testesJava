#language: pt
@Todos
Funcionalidade: Reserva de sala

@reservarSala @mobile
Cenário: Reservar sala
	Dado Que eu acessei o app portal brq com credenciais válidas
	Quando Eu solicitar reserva para a sala Arena da BRQ Boa Vista, localizada no 6° Andar para o dia 31 de dezembro das 14:00 as 15:00
	Então A reserva deverá ser efetivada
	
@consultaReserva @web
Cenário: Consulta e exclusão da Reserva
	Dado Que eu acessei o portal brq com credenciais válidas
	Quando Eu consultar reserva para o 6° Andar, na Sala Arena, com o nome do solicitante Paulo Lobo Neto
	Então Deverá aparecer a reserva feita

@excluirReserva	@web
Cenário: Exclusão da Reserva
	Dado Que eu consultei uma reserva válida
	Então Devo excluir a reserva 
	
	