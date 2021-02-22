package ar.edu.unju.edm.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDAO;
@Service
public class LoginUsuarioServiceImp implements UserDetailsService{
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuarioEncontrado = iUsuarioDAO.findByNombreUsuario(nombreUsuario).orElseThrow(()-> new UsernameNotFoundException("Login Invalido"));
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		tipos.add(grantedAuthority);
		UserDetails user = (UserDetails) new User(nombreUsuario,usuarioEncontrado.getContraseña(),tipos);
		System.out.println("USUARIO:  "+usuarioEncontrado.getNombreUsuario()+"CONTRASEÑA:  "+usuarioEncontrado.getContraseña()+"  TIPO:  "+usuarioEncontrado.getTipo());
		return user;
	}

}

