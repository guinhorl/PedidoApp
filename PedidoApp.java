
public class PedidoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// variaveis Pedido
		int codPed;
		String nomeCliente;
		int quantItens;
		double valorTotal;
		// FIM variaveis Pedido
		// variaveis Vendedor
		int matricula;
		double comissao;
		// FIM variaveis Vendedor
		// variaveis axu
		int op = 0, cont_pilhaJose = 0, cont_pilhaAne = 0, cont_pilhaMaria = 0, cont_Efet = 0, cont_Pend = 0;
		double faturTotal = 0;
		// FIM variaveis

		// Objetos		
		Pedido aux;
		LinkStackPedido pilhaJose = new LinkStackPedido(); // make stack
		LinkStackPedido pilhaAne = new LinkStackPedido(); // make stack
		LinkStackPedido pilhaMaria = new LinkStackPedido(); // make stack
		LinkListPedido listaPedidosPend = new LinkListPedido();
		LinkListPedido listaPedidosEfet = new LinkListPedido();
		Pedido pedidoSaida;
		Vendedor vendJose = new Vendedor(001, "José", 0);
		Vendedor vendAna = new Vendedor(002, "Ana", 0);
		Vendedor vendMaria = new Vendedor(003, "Maria", 0);
		// FIM Objetos

		System.out.println("============================");
		System.out.println("          CADASTRO APP          ");
		System.out.println("                !            ");
		System.out.println("============================");
		System.out.println("");
		System.out.println("1 - CADASTRAR PEDIDO");
		System.out.println("2 - LISTAR PEDIDOS PENDENTES E EFETIVADOS");
		System.out.println("3 - BUSCAR PEDIDO EFETIVADO POR VENDEDOR");
		System.out.println("4 - BUSCAR PEDIDOS PENDENTES POR VENDEDOR");
		System.out.println("5 - FATURAMENTO TOTAL");
		System.out.println("6 - COMISSÃO POR VENDEDOR");
		System.out.println("7 - QUANTIDADE DE PEDIDOS EFETIVADO E PENDENTE");
		System.out.println("8 - Sair");
		System.out.print("Digite a opção: ");
		op = Read.readInt();
		while (op != 8) {
			switch (op) {
			case 1: // Inserção
			{
				System.out.println("");
				System.out.println("INCLUSÃO");
				System.out.println(" ");
				System.out.print("Informe o código do pedido: ");
				codPed = Read.readInt();
				System.out.println("Informe o nome do cliente: ");
				nomeCliente = Read.readString();
				System.out.print("Informe a quantidade de itens: ");
				quantItens = Read.readInt();
				System.out.println("Informe o valor total: ");
				valorTotal = Read.readDouble();
				System.out.println("!!! ATENÇÃO INFORME A MATRÍCULA DO VENDEDOR!!! ");
				System.out.println(" === 001 - José | 002 - Ana | 003 - Maria === ");
				matricula = Read.readInt();

				if (matricula == 001) {
					aux = new Pedido(codPed, nomeCliente, quantItens, valorTotal, vendJose.getmatricula(),
							vendJose.getNome());
					pilhaJose.push(aux);
					listaPedidosPend.insertFirst(aux);
					cont_pilhaJose++;
					faturTotal += valorTotal;
					cont_Pend++;
					if (cont_pilhaJose >= 3) {
						while (!pilhaJose.isEmpty()) {
							pedidoSaida = pilhaJose.pop();
							listaPedidosPend.deleteFind(pedidoSaida.getCod());
							// pegando os 10% de cada valor
							comissao = (pedidoSaida.getValorTotal() * 10) / 100;							
							comissao += vendJose.getComissao();
							vendJose.setComissao(comissao);
							listaPedidosEfet.insertFirst(pedidoSaida);
							cont_Efet++;
							cont_Pend--;
						}
					}
					break;
				}
				if (matricula == 002) {
					aux = new Pedido(codPed, nomeCliente, quantItens, valorTotal, vendAna.getmatricula(),
							vendAna.getNome());
					pilhaAne.push(aux);
					listaPedidosPend.insertFirst(aux);
					cont_pilhaAne++;
					faturTotal += valorTotal;
					cont_Pend++;
					if (cont_pilhaAne >= 3) {
						while (!pilhaAne.isEmpty()) {
							pedidoSaida = pilhaAne.pop();
							listaPedidosPend.deleteFind(pedidoSaida.getCod());
							// pegando os 10% de cada valor
							comissao = (pedidoSaida.getValorTotal() * 10) / 100;							
							comissao += vendAna.getComissao();
							vendAna.setComissao(comissao);
							listaPedidosEfet.insertFirst(pedidoSaida);
							cont_Efet++;
							cont_Pend--;
						}
					}
					break;
				}
				if (matricula == 003) {
					aux = new Pedido(codPed, nomeCliente, quantItens, valorTotal, vendMaria.getmatricula(),
							vendMaria.getNome());
					pilhaMaria.push(aux);
					listaPedidosPend.insertFirst(aux);
					cont_pilhaMaria++;
					faturTotal += valorTotal;
					cont_Pend++;
					if (cont_pilhaMaria >= 3) {
						while (!pilhaMaria.isEmpty()) {
							pedidoSaida = pilhaMaria.pop();
							listaPedidosPend.deleteFind(pedidoSaida.getCod());
							// pegando os 10% de cada valor
							comissao = (pedidoSaida.getValorTotal() * 10) / 100;							
							comissao += vendMaria.getComissao();
							vendMaria.setComissao(comissao);
							listaPedidosEfet.insertFirst(pedidoSaida);
							cont_Efet++;
							cont_Pend--;
						}
					}
					break;
				} else {
					System.out.println(" == !! MATRÍCULA NÃO CADASTRADA !! ==");
				}

				break;
			}
			case 2:// LISTAR PEDIDOS PENDENTES E EFETIVADOS
				System.out.println("============================");
				System.out.println("");
				System.out.println("Pedidos Pendentes: ");
				System.out.println("============================");
				System.out.println("");
				System.out.println(listaPedidosPend.displayList());
				System.out.println("");
				System.out.println("Pedidos Efetivados: ");
				System.out.println("");
				System.out.println(listaPedidosEfet.displayList());
				System.out.println("");
				System.out.println("============================");

			{

				break;
			}
			case 3: // BUSCAR PEDIDO EFETIVADO POR VENDEDOR
			{
				int serieTemp;
				System.out.println("============================");
				System.out.println("!!! ATENÇÃO INFORME A MATRÍCULA DO VENDEDOR!!! ");
				System.out.println(" === 001 - José | 002 - Ana | 003 - Maria === ");
				serieTemp = Read.readInt();
				System.out.println(listaPedidosEfet.find(serieTemp));
				System.out.println("");
				System.out.println("============================");
				break;
			}
			case 4: // BUSCAR PEDIDO PENDENTES POR VENDEDOR
			{
				int codTemp;
				System.out.println("============================");
				System.out.println("!!! ATENÇÃO INFORME A MATRÍCULA DO VENDEDOR!!! ");
				System.out.println(" === 001 - José | 002 - Ana | 003 - Maria === ");
				codTemp = Read.readInt();
				System.out.println(listaPedidosPend.find(codTemp));
				System.out.println("");
				System.out.println("============================");

				break;
			}
			case 5: // Faturamento Total
			{
				String fatTotal = String.format("%.2f", faturTotal);
				System.out.println("!!! FATURAMENTO TOTAL R$: " + fatTotal);

				break;
			}
			case 6: // COMISSÃO POR VENDEDOR
			{
				String comJose = String.format("%.2f", vendJose.getComissao());
				String comAna = String.format("%.2f", vendAna.getComissao());
				String comMaria = String.format("%.2f", vendMaria.getComissao());

				System.out.println(" $$$ COMISSÃO POR VENDEDOR $$$");
				System.out.println(" NOME: " + vendJose.getNome());
				System.out.println(" COMISSÃO: " + comJose);
				System.out.println("");
				System.out.println("============================");
				System.out.println("");
				System.out.println(" NOME: " + vendAna.getNome());
				System.out.println(" COMISSÃO: " + comAna);
				System.out.println("");
				System.out.println("============================");
				System.out.println("");
				System.out.println(" NOME: " + vendMaria.getNome());
				System.out.println(" COMISSÃO: " + comMaria);

				break;
			}
			case 7: // QUANTIDADE PEDIDOS EFETIVADOS E PENDENTES
			{

				System.out.println(" QUANTIDADE PEDIDOS EFETIVADOS: " + cont_Efet);
				System.out.println("========================================");
				System.out.println(" QUANTIDADE PEDIDOS PENDENTES: " + cont_Pend);

				break;
			}
			default: {
				System.out.println("Opção Inválida!");
			}
			}
			System.out.println("============================");
			System.out.println("          CADASTRO APP          ");
			System.out.println("                !            ");
			System.out.println("============================");
			System.out.println("");
			System.out.println("1 - CADASTRAR PEDIDO");
			System.out.println("2 - LISTAR PEDIDOS PENDENTES E EFETIVADOS");
			System.out.println("3 - BUSCAR PEDIDO EFETIVADO POR VENDEDOR");
			System.out.println("4 - BUSCAR PEDIDOS PENDENTES POR VENDEDOR");
			System.out.println("5 - FATURAMENTO TOTAL");
			System.out.println("6 - COMISSÃO POR VENDEDOR");
			System.out.println("7 - QUANTIDADE DE PEDIDOS EFETIVADO E PENDENTE");
			System.out.println("8 - Sair");
			System.out.print("Digite a opção: ");
			op = Read.readInt();
		}
		System.out.print("*** FIM ***");

	}

}
