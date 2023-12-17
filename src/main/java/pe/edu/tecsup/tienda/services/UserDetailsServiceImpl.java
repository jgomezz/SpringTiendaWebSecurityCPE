package pe.edu.tecsup.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.edu.tecsup.tienda.repositories.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = usuarioRepository.loadUserByUsername(username);
		if(userDetails == null)
			throw new UsernameNotFoundException("Usuario no encontrado");
		return userDetails;
	}


}
