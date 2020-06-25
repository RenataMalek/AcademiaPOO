package control;

import academia.Cliente;
import academia.Recepcionista;
import academia.Treinador;
import dao.ClienteDAO;
import dao.RecepcionistaDAO;
import dao.TreinadorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private final String RECEPCIONISTA = "Recepcionista";

    private final String TREINADOR = "Treinador";

    private final String CLIENTE = "Cliente";

    public List<String> buscaTiposAcesso() {
        List<String> tiposAcesso = new ArrayList<>();
        tiposAcesso.add(RECEPCIONISTA);
        tiposAcesso.add(TREINADOR);
        tiposAcesso.add(CLIENTE);
        return tiposAcesso;
    }

    public boolean logar(String acesso, String tipoAcesso) throws SQLException {
        if (tipoAcesso.equals(RECEPCIONISTA)) {
            RecepcionistaDAO recepcionistaDAO = new RecepcionistaDAO();
            Recepcionista recepcionista = recepcionistaDAO.buscarPorCodigoAcesso(acesso);
            return validarObjetoNaoNulo(recepcionista);
        } else if (tipoAcesso.equals(TREINADOR)) {
            TreinadorDAO treinadorDAO = new TreinadorDAO();
            Treinador treinador = treinadorDAO.buscarPorCodigoAcesso(acesso);
            return validarObjetoNaoNulo(treinador);
        } else {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.buscarClientePorCpf(acesso);
            return validarObjetoNaoNulo(cliente);
        }
    }

    private boolean validarObjetoNaoNulo(Object object) {
        return object != null;
    }
}
