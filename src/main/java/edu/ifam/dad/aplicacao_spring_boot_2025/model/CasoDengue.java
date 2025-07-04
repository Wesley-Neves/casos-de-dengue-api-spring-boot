package edu.ifam.dad.aplicacao_spring_boot_2025.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CasoDengue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Integer idade;
    private String sexo;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;

    @ManyToMany
    @JoinTable(
            name = "caso_sintoma",
            joinColumns = @JoinColumn(name = "caso_id"),
            inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private List<Sintoma> sintomas;

    @Column(name = "data_inicio_sintomas")
    private LocalDate dataInicioSintomas;

    @ManyToOne
    @JoinColumn(name = "evolucao_id")
    private Evolucao evolucao;

    @ManyToOne
    @JoinColumn(name = "local_internacao_id")
    private LocalInternacao localInternacao;

    @ManyToOne
    @JoinColumn(name = "estado_civil_id")
    private EstadoCivil estadoCivil;

    public CasoDengue() {

    }

    public CasoDengue(Long id, String nome, LocalDate dataNascimento, Integer idade, String sexo, String cep, String logradouro, String numero, String complemento, String bairro, String municipio, String estado, List<Sintoma> sintomas, LocalDate dataInicioSintomas, Evolucao evolucao, LocalInternacao localInternacao, EstadoCivil estadoCivil) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexo = sexo;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.sintomas = sintomas;
        this.dataInicioSintomas = dataInicioSintomas;
        this.evolucao = evolucao;
        this.localInternacao = localInternacao;
        this.estadoCivil = estadoCivil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    public LocalInternacao getLocalInternacao() {
        return localInternacao;
    }

    public void setLocalInternacao(LocalInternacao localInternacao) {
        this.localInternacao = localInternacao;
    }

    public LocalDate getDataInicioSintomas() {
        return dataInicioSintomas;
    }

    public void setDataInicioSintomas(LocalDate dataInicioSintomas) {
        this.dataInicioSintomas = dataInicioSintomas;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
