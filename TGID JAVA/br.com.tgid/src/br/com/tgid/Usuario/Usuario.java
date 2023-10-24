package br.com.tgid.Usuario;

public class Usuario {
	
	   private String nome;
	    private String documento;

	    public Usuario(String nome, String documento) {
	        this.setNome(nome);
	        this.documento = documento;
	    }

	    public String getDocumento() {
	        return documento;
	    }

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	}


