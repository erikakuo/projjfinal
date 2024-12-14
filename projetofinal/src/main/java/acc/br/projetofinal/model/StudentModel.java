package acc.br.projetofinal.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Table;




@EntityScan
@Table(name = "STUDENT")

public class StudentModel {

    @Id
    private Long id;
    private String name;
    private String cep;
    private String localidade;
    private LocalDate nascimento;
    private String subject;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String cep, String localidade, LocalDate nascimento, String subject) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.localidade = localidade;
        this.nascimento = nascimento;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return nascimento;
    }

    public void setBirthDate(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return String.format(
            "StudentModel{id=%d, name='%s', cep='%s', localidade='%s', nascimento=%s, subject='%s'}",
            id, name, cep, localidade, nascimento, subject
        );
    }
}