package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Planeta {
    @Id
    @GeneratedValue
    private Integer idGalactico;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer coordX;
    @Column(nullable = false)
    private Integer coordY;
    @Column(nullable = false)
    private Date dataCadastro;

    public Integer getIdGalactico() {
        return idGalactico;
    }

    public void setIdGalactico(Integer idGalactico) {
        this.idGalactico = idGalactico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Id Galactico: " + idGalactico +
                ", Nome: " + nome +
                ", Coordenada X: " + coordX +
                ", Coordenada Y: " + coordY +
                ", Data de Cadastro: " + dataCadastro.toString();
    }
}
