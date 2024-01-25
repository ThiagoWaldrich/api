package med.voll.api.medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
    //apenas os campos que quero devolver na listagem
}
