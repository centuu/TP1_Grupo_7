package entidad;

public class Usuario {
	protected String usuario;
    protected String pass;
    protected int rol;
    protected int legajo;
    protected boolean isdmin;
    
    
	
    
    public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(String usuario, String pass, int rol, int legajo) {
		
		this.usuario = usuario;
		this.pass = pass;
		
		if (rol == 1)
			this.isdmin = true;
		else
			this.isdmin = false;
		
		this.legajo = legajo;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public boolean isIsdmin() {
		return isdmin;
	}


	public void setIsdmin(boolean isdmin) {
		this.isdmin = isdmin;
	}
    
    

}
