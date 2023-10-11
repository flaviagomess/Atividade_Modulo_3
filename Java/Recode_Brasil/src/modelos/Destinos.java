package modelos;

public class Destinos {

	 //atributos
		private int id;
		private String nome;
		private String descricao;
		private Float preco;
		
		//construtor
		public Destinos() {
		}

		public Destinos(int id, String nome, String descricao, Float preco) {
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
		}

		public Destinos(String nome, String descricao, Float preco) {
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
		}
		
		//getters e setters	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Float getPreco() {
			return preco;
		}

		public void setPreco(Float preco) {
			this.preco = preco;
		}
		

		@Override
		public String toString() {
			return "Destinos [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
		}
		
		
		
}
