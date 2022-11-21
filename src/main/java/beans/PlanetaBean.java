package beans;

import dao.PlanetaDAO;
import entities.Planeta;
import util.MessagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class PlanetaBean {
    Planeta planeta = new Planeta();
    List<Planeta> lista = new ArrayList<>();

    public void save() {
        try {
            this.planeta.setDataCadastro(new Date());
            PlanetaDAO.save(this.planeta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete() {
        try {
            PlanetaDAO.delete(this.planeta);
            MessagesUtil.successMessage("Registro de planeta foi excluído com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void visualizar() {
        MessagesUtil.successMessage(this.planeta.toString());
    }

    public void encontrarMaiorId() {
        List<Integer> listaDeIds = new ArrayList<>();
        for (Planeta p : this.lista) {
            listaDeIds.add(p.getIdGalactico());
        }

        Integer maxId = Collections.max(listaDeIds);

        for (Planeta p : this.lista) {
            if (p.getIdGalactico().equals(maxId)) {
                MessagesUtil.successMessage("Este é o planeta de maior ID: " + p);
                return;
            }
        }
    }

    public List<Planeta> getLista() {
        this.lista = PlanetaDAO.listAll();
        return this.lista;
    }

    public void setLista(List<Planeta> lista) {
        this.lista = lista;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }


}
