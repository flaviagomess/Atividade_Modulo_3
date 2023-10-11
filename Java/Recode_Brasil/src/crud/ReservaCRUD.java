package crud;

import java.util.Scanner;

import dao.DestinosDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import modelos.Destinos;
import modelos.Reserva;
import modelos.Usuarios;

public class ReservaCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ReservaDAO reservaDAO = new ReservaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		DestinosDAO destinoDAO = new DestinosDAO();	
		
		int opcao = 0, id = 0, id_destino = 0, id_usuario = 0; 
		
		String data_reserva = "";
		
		do {
			
			System.out.println("\n============================== RESERVA =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data da reserva:");
				data_reserva = s.nextLine();
				System.out.println("Digite o id do destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				
				Usuarios usuario1 = usuarioDAO.readById(id_usuario);
				Destinos destino1 = destinoDAO.readById(id_destino);
				
				
				Reserva reserva1 = new Reserva(data_reserva, usuario1, destino1);
				
				
				reservaDAO.create(reserva1);
				break;
			case 2:
				
				for (Reserva u : reservaDAO.read()) {
					
					System.out.println (u.toString());
				}
				
				break;
			case 3:
				System.out.println("Digite o id da reserva:");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Digite a data da reserva:");
				data_reserva = s.nextLine();
				System.out.println("Digite o id do destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				
				Usuarios usuario2 = usuarioDAO.readById(id_usuario);
				Destinos destino2 = destinoDAO.readById(id_destino);
				
				
				Reserva reserva2 = new Reserva(id, data_reserva, usuario2, destino2);
				
				reservaDAO.update(reserva2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				reservaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Reserva reserva3 = reservaDAO.readById(id);
				
				System.out.println(reserva3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
