package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;
import modelos.Reserva;
import modelos.Usuarios;

public class ReservaDAO {

	//CREATE
		public void create (Reserva reserva) {
			
			String sql = "insert into Reserva (data_reserva, fk_Destinos_id_destino, fk_Usuarios_id_usuario, total_reserva) values (?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, reserva.getData_reserva());
				pstm.setInt (2, reserva.getDestino().getId());
				pstm.setInt (3, reserva.getUsuario().getId());
				pstm.setFloat(4, (float) reserva.getTotal_reserva());
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				 try {
					
					 if (pstm !=null) {
						 pstm.close();
					
					 }
					 if (conn !=null) {
						 conn.close();
					 }
					 
					 }catch (Exception e) {
						 e.printStackTrace();
					 }
		}
			
		}

		//READ
		public List<Reserva> read(){
			List<Reserva> Reserva = new ArrayList<Reserva>();
			String sql = "select * from usuario_destino order by id_reserva";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Reserva reserva = new Reserva();
					Destinos destino = new Destinos();
					Usuarios usuario = new Usuarios();
					
					reserva.setId(rset.getInt("id_reserva"));
					reserva.setData_reserva(rset.getString("data_reserva"));
					reserva.setTotal_reserva(rset.getFloat("total_reserva"));

					destino.setId(rset.getInt("id_destino"));
					destino.setNome(rset.getString("nome_destino"));
					destino.setDescricao(rset.getString("descricao_destino"));
					destino.setPreco(rset.getFloat("preco_destino"));

					usuario.setId(rset.getInt("id_usuario"));
					usuario.setNome(rset.getString("nome_usuario"));
					usuario.setEmail(rset.getString("email_usuario"));
					usuario.setSenha(rset.getString("senha_usuario"));

					reserva.setDestino(destino);
					reserva.setUsuario(usuario);

					Reserva.add(reserva);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
			
			return Reserva;
		}
		
		//UPDATE
		public void update (Reserva reserva) {
			String sql = "UPDATE Reserva SET data_reserva = ?, total_reserva = ?, fk_Destinos_id_destino =?, fk_Usuarios_id_usuario = ? WHERE id_reserva = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, reserva.getData_reserva());
				pstm.setFloat(2, (float) reserva.getTotal_reserva());
				pstm.setInt(3, reserva.getDestino().getId());
				pstm.setInt(4, reserva.getUsuario().getId());
				pstm.setInt(5, reserva.getId());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		//DELETE
		public void delete (int id) {
			String sql = "DELETE FROM Reserva WHERE id_reserva = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		//readById
		public Reserva readById (int id) {
			Reserva reserva = new Reserva();
			String sql = "select * from usuario_destino WHERE id_reserva = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();

				Destinos destino = new Destinos();
				Usuarios usuario = new Usuarios();

				reserva.setId(rset.getInt("id_reserva"));
				reserva.setData_reserva(rset.getString("data_reserva"));
				reserva.setTotal_reserva(rset.getFloat("total_reserva"));

				destino.setId(rset.getInt("id_destino"));
				destino.setNome(rset.getString("nome_destino"));
				destino.setDescricao(rset.getString("descricao_destino"));
				destino.setPreco(rset.getFloat("preco_destino"));

				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email_usuario"));
				usuario.setSenha(rset.getString("senha_usuario"));

				reserva.setDestino(destino);
				reserva.setUsuario(usuario);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return reserva;
		}
	}