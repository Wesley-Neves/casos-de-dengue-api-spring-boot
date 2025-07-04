package edu.ifam.dad.aplicacao_spring_boot_2025.service;

import edu.ifam.dad.aplicacao_spring_boot_2025.dto.CasoDengueDTO;
import edu.ifam.dad.aplicacao_spring_boot_2025.dto.ViaCepResponseDTO;
import edu.ifam.dad.aplicacao_spring_boot_2025.model.CasoDengue;
import edu.ifam.dad.aplicacao_spring_boot_2025.model.Sintoma;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CasoDengueService {


    private final CasoDengueRepository casoDengueRepository;
    private final SintomaRepository sintomaRepository;
    private final EvolucaoRepository evolucaoRepository;
    private final ViaCepService viaCepService;
    private final EstadoCivilRepository estadoCivilRepository;
    protected final LocalInternacaoRepository localInternacaoRepository;

    public CasoDengueService(CasoDengueRepository casoDengueRepository, SintomaRepository sintomaRepository, EvolucaoRepository evolucaoRepository, ViaCepService viaCepService, EstadoCivilRepository estadoCivilRepository, LocalInternacaoRepository localInternacaoRepository) {
        this.casoDengueRepository = casoDengueRepository;
        this.sintomaRepository = sintomaRepository;
        this.evolucaoRepository = evolucaoRepository;
        this.viaCepService = viaCepService;
        this.estadoCivilRepository = estadoCivilRepository;
        this.localInternacaoRepository = localInternacaoRepository;
    }

    public CasoDengue cadastrarCasoComDTO(CasoDengueDTO dto){
        CasoDengue caso = new CasoDengue();
        preencherCasoDengueComDTO(caso, dto);
        return casoDengueRepository.save(caso);
    }

    public CasoDengue atualizarCasoComDTO(Long id, CasoDengueDTO dto){
        Optional<CasoDengue> optionalCaso = casoDengueRepository.findById(id);
        if (optionalCaso.isEmpty()){
            throw new IllegalArgumentException("Caso de dengue com ID "+ id+ "nao encontrado");
        }
        CasoDengue casoExistente = optionalCaso.get();
        preencherCasoDengueComDTO(casoExistente, dto);
        return casoDengueRepository.save(casoExistente);
    }

    private void preencherCasoDengueComDTO(CasoDengue caso, CasoDengueDTO dto) {
        caso.setNome(dto.getNome());
        caso.setDataNascimento(dto.getDataNascimento());
        caso.setIdade(dto.getIdade());
        caso.setSexo(dto.getSexo());
        caso.setNumero(dto.getNumero());
        caso.setComplemento(dto.getComplemento());
        caso.setDataInicioSintomas(dto.getDataInicioSintomas());

        if (dto.getCep() != null && !dto.getCep().isEmpty()) {
            try {
                ViaCepResponseDTO viaCepData = viaCepService.buscarEnderecoPorCep(dto.getCep());
                caso.setCep(viaCepData.getCep());

                caso.setLogradouro(
                        (viaCepData.getLogradouro() != null && !viaCepData.getLogradouro().isEmpty())
                                ? viaCepData.getLogradouro()
                                : dto.getLogradouro()
                );

                caso.setBairro(
                        (viaCepData.getBairro() != null && !viaCepData.getBairro().isEmpty())
                                ? viaCepData.getBairro()
                                : dto.getBairro()
                );

                caso.setMunicipio(
                        (viaCepData.getLocalidade() != null && !viaCepData.getLocalidade().isEmpty())
                                ? viaCepData.getLocalidade()
                                : dto.getMunicipio()
                );

                caso.setEstado(
                        (viaCepData.getUf() != null && !viaCepData.getUf().isEmpty())
                                ? viaCepData.getUf()
                                : dto.getEstado()
                );
                if (dto.getEstadoCivilId() != null) {
                    estadoCivilRepository.findById(dto.getEstadoCivilId())
                            .ifPresentOrElse(
                                    caso::setEstadoCivil,
                                    () -> { throw new IllegalArgumentException("Estado civil com ID " + dto.getEstadoCivilId() + " não encontrado"); }
                            );
                } else {
                    caso.setEstadoCivil(null);
                }


            } catch (Exception e) {
                throw new IllegalArgumentException("CEP inválido ou erro ao buscar endereço: " + dto.getCep(), e);
            }
        } else {
            caso.setCep(dto.getCep());
            caso.setLogradouro(dto.getLogradouro());
            caso.setBairro(dto.getBairro());
            caso.setMunicipio(dto.getMunicipio());
            caso.setEstado(dto.getEstado());
        }

        if (dto.getSintomasIds() != null && !dto.getSintomasIds().isEmpty()) {
            List<Sintoma> sintomas = (List<Sintoma>) sintomaRepository.findAllById(dto.getSintomasIds());
            if (sintomas.size() != dto.getSintomasIds().size()) {
                List<Long> foundIds = sintomas.stream().map(Sintoma::getId).collect(Collectors.toList());
                List<Long> missingIds = dto.getSintomasIds().stream()
                        .filter(id -> !foundIds.contains(id))
                        .collect(Collectors.toList());
                throw new IllegalArgumentException("IDs de sintomas não encontrados: " + missingIds);
            }
            caso.setSintomas(sintomas);
        } else {
            caso.setSintomas(List.of());
        }

        if (dto.getEvolucaoId() != null) {
            evolucaoRepository.findById(dto.getEvolucaoId())
                    .ifPresentOrElse(
                            caso::setEvolucao,
                            () -> { throw new IllegalArgumentException("Evolução com ID " + dto.getEvolucaoId() + " não encontrada"); }
                    );
        } else {
            caso.setEvolucao(null);
        }

        if (dto.getLocalInternacaoId() != null){
            localInternacaoRepository.findById(dto.getLocalInternacaoId())
                    .ifPresentOrElse(
                            caso::setLocalInternacao,
                            () -> {throw new IllegalArgumentException("Local de internacao com ID "+ dto.getLocalInternacaoId() + "nao encontrado");}
                    );
        } else {
            caso.setLocalInternacao(null);
        }
    }


    public List<CasoDengue> listarCasos(){
        return  casoDengueRepository.findAll();
    }

    public Optional<CasoDengue> buscarPorId(Long id){
        return casoDengueRepository.findById(id);
    }

    public void excluirCaso(Long id) {
        if (!casoDengueRepository.existsById(id)) {
            throw new IllegalArgumentException("Caso não encontrado para exclusão");
        }
        casoDengueRepository.deleteById(id);
    }

}
