package modelos;

public class Reserva {

	private int id;
	private String data_reserva;
	private Float total_reserva;
	private Usuarios usuario;
	private Destinos destino;

	public Reserva() {
	}

	public Reserva(int id, String data_reserva, Usuarios usuario, Destinos destino) {
		this.id = id;
		this.data_reserva = data_reserva;
		this.total_reserva = valorReservaMaisTaxa(destino.getPreco());
		this.usuario = usuario;
		this.destino = destino;
		
	}

	public Reserva(String data_reserva, Usuarios usuario, Destinos destino) {
		this.data_reserva = data_reserva;
		this.total_reserva = valorReservaMaisTaxa(destino.getPreco());
		this.usuario = usuario;
		this.destino = destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}

	public Float getTotal_reserva() {
		return total_reserva;
	}

	public void setTotal_reserva(float total_reserva) {
		this.total_reserva = total_reserva;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Destinos getDestino() {
		return destino;
	}

	public void setDestino(Destinos destino) {
		this.destino = destino;
	}
	
	public float valorReservaMaisTaxa(float preco_destino) {
		this.total_reserva = (float) ((preco_destino * 0.10 ) + preco_destino);
		
		return this.total_reserva;
	}


	@Override
	public String toString() {
		return "Reserva [id=" + id + ", data_reserva=" + data_reserva + ", total_reserva=" + total_reserva
				+ ", usuario=" + usuario + ", destino=" + destino + "]";
	}


	}
