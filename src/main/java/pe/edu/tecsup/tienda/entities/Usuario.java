package pe.edu.tecsup.tienda.entities;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "roles_id")
	private Rol rol;
	private String email;
	private String password;
	private String nombres;
	private String apellidos;
	private String sexo;
	private Date fecnacimiento;
	private String telefono;
	private String direccion;
	private Integer estado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFecnacimiento() {
		return fecnacimiento;
	}
	public void setFecnacimiento(Date fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Credentials
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", rol=" + rol + ", email=" + email + ", password=" + password + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", fecnacimiento=" + fecnacimiento
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", estado=" + estado + "]";
	}

	// Spring Security

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Rol> authorities = new ArrayList<>();
		authorities.add(this.rol);
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true; // false: User account has expired
	}
	@Override
	public boolean isAccountNonLocked() {
		return true; // false: User account is locked
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// Change username field
		return true; // false: User credentials have expired
	}
	@Override
	public boolean isEnabled() {
		return this.estado != null && this.estado == 1;
	}
}
