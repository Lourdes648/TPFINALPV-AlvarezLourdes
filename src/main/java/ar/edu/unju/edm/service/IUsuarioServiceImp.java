package ar.edu.unju.edm.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDAO;

@Service
public class IUsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Usuario BuscarPorId(Long id) {
		return iUsuarioDAO.findById(id).get();
	}


	@Override
	public void update() {
		Usuario xd = new Usuario();
		iUsuarioDAO.save(xd);
		iUsuarioDAO.delete(xd);
	}


	@Override
	public void EncriptarYGuardarUsuario(Usuario usuario) {
		String pw = usuario.getContraseña();
		usuario.setContraseña(bCryptPasswordEncoder.encode(pw));
		iUsuarioDAO.save(usuario);
	}
}
