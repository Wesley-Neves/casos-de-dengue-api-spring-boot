package edu.ifam.dad.aplicacao_spring_boot_2025.dto;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.EstadoCivil;

import java.time.LocalDate;
import java.util.List;

public class CasoDengueDTO {

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
    private List<Long> sintomasIds;
    private LocalDate dataInicioSintomas;
    private Long evolucaoId;
    private Long localInternacaoId;
    private Long estadoCivilId;

    public CasoDengueDTO() {

    }

    public CasoDengueDTO(String nome, LocalDate dataNascimento, Integer idade, String sexo, String cep, String logradouro, String numero, String complemento, String bairro, String municipio, String estado, List<Long> sintomasIds, LocalDate dataInicioSintomas, Long evolucaoId, Long localInternacaoId, Long estadoCivilId) {
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
        this.sintomasIds = sintomasIds;
        this.dataInicioSintomas = dataInicioSintomas;
        this.evolucaoId = evolucaoId;
        this.localInternacaoId = localInternacaoId;
        this.estadoCivilId = estadoCivilId;
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

    public List<Long> getSintomasIds() {
        return sintomasIds;
    }

    public void setSintomasIds(List<Long> sintomasIds) {
        this.sintomasIds = sintomasIds;
    }

    public LocalDate getDataInicioSintomas() {
        return dataInicioSintomas;
    }

    public void setDataInicioSintomas(LocalDate dataInicioSintomas) {
        this.dataInicioSintomas = dataInicioSintomas;
    }

    public Long getEvolucaoId() {
        return evolucaoId;
    }

    public void setEvolucaoId(Long evolucaoId) {
        this.evolucaoId = evolucaoId;
    }

    public Long getLocalInternacaoId() {
        return localInternacaoId;
    }

    public void setLocalInternacaoId(Long localInternacao) {
        this.localInternacaoId = localInternacao;
    }

    public Long getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Long estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }
}
