package usp.br.petmatch.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CHATGPT")
public class ChatGptModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idChatGpt;

    @Column(name = "inputUsuario")
    private String inputUsuario;

    @Column(name = "resposta", columnDefinition = "TEXT")
    private String resposta;

    @Column(name = "idade")
    private String idade;

    @Column(name = "importancia_idade")
    private String importanciaIdade;

    @Column(name = "justificativa_idade")
    private String justificativaIdade;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "importancia_sexo")
    private String importanciaSexo;

    @Column(name = "justificativa_sexo")
    private String justificativaSexo;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "importancia_tamanho")
    private String importanciaTamanho;

    @Column(name = "justificativa_tamanho")
    private String justificativaTamanho;

    @Column(name = "pelagem")
    private String pelagem;

    @Column(name = "importancia_pelagem")
    private String importanciaPelagem;

    @Column(name = "justificativa_pelagem")
    private String justificativaPelagem;

    @Column(name = "castrado")
    private String castrado;

    @Column(name = "importancia_castrado")
    private String importanciaCastrado;

    @Column(name = "justificativa_castrado")
    private String justificativaCastrado;

    @Column(name = "treinado")
    private String treinado;

    @Column(name = "importancia_treinado")
    private String importanciaTreinado;

    @Column(name = "justificativa_treinado")
    private String justificativaTreinado;

    @Column(name = "necessidadesEspeciais")
    private String necessidadesEspeciais;

    @Column(name = "importancia_necessidades_especiais")
    private String importanciaNecessidadesEspeciais;

    @Column(name = "justificativa_necessidades_especiais")
    private String justificativaNecessidadesEspeciais;

    @Column(name = "vacinado")
    private String vacinado;

    @Column(name = "importancia_vacinado")
    private String importanciaVacinado;

    @Column(name = "justificativa_vacinado")
    private String justificativaVacinado;

    @Column(name = "bom_com_criancas")
    private String bomComCriancas;

    @Column(name = "importancia_bom_com_criancas")
    private String importanciaBomComCriancas;

    @Column(name = "justificativa_bom_com_criancas")
    private String justificativaBomComCriancas;

    @Column(name = "bom_com_cachorros")
    private String bomComCachorros;

    @Column(name = "importancia_bom_com_cachorros")
    private String importanciaBomComCachorros;

    @Column(name = "justificativa_bom_com_cachorros")
    private String justificativaBomComCachorros;

    @Column(name = "bom_com_gatos")
    private String bomComGatos;

    @Column(name = "importancia_bom_com_gatos")
    private String importanciaBomComGatos;

    @Column(name = "justificativa_bom_gatos")
    private String justificativaBomComGatos;

    public ChatGptModel(){

    }

    public ChatGptModel(String inputUsuario, String resposta){
        this.inputUsuario = inputUsuario;
        this.resposta = resposta;
    }

    public ChatGptModel(String inputUsuario, String resposta, String idade, String importanciaIdade, String justificativaIdade, String sexo, String importanciaSexo, String justificativaSexo, String tamanho, String importanciaTamanho, String justificativaTamanho, String pelagem, String importanciaPelagem, String justificativaPelagem, String castrado, String importanciaCastrado, String justificativaCastrado, String treinado, String importanciaTreinado, String justificativaTreinado, String necessidadesEspeciais, String importanciaNecessidadesEspeciais, String justificativaNecessidadesEspeciais, String vacinado, String importanciaVacinado, String justificativaVacinado, String bomComCriancas, String importanciaBomComCriancas, String justificativaBomComCriancas, String bomComCachorros, String importanciaBomComCachorros, String justificativaBomComCachorros, String bomComGatos, String importanciaBomComGatos, String justificativaBomComGatos) {
        this.inputUsuario = inputUsuario;
        this.resposta = resposta;
        this.idade = idade;
        this.importanciaIdade = importanciaIdade;
        this.justificativaIdade = justificativaIdade;
        this.sexo = sexo;
        this.importanciaSexo = importanciaSexo;
        this.justificativaSexo = justificativaSexo;
        this.tamanho = tamanho;
        this.importanciaTamanho = importanciaTamanho;
        this.justificativaTamanho = justificativaTamanho;
        this.pelagem = pelagem;
        this.importanciaPelagem = importanciaPelagem;
        this.justificativaPelagem = justificativaPelagem;
        this.castrado = castrado;
        this.importanciaCastrado = importanciaCastrado;
        this.justificativaCastrado = justificativaCastrado;
        this.treinado = treinado;
        this.importanciaTreinado = importanciaTreinado;
        this.justificativaTreinado = justificativaTreinado;
        this.necessidadesEspeciais = necessidadesEspeciais;
        this.importanciaNecessidadesEspeciais = importanciaNecessidadesEspeciais;
        this.justificativaNecessidadesEspeciais = justificativaNecessidadesEspeciais;
        this.vacinado = vacinado;
        this.importanciaVacinado = importanciaVacinado;
        this.justificativaVacinado = justificativaVacinado;
        this.bomComCriancas = bomComCriancas;
        this.importanciaBomComCriancas = importanciaBomComCriancas;
        this.justificativaBomComCriancas = justificativaBomComCriancas;
        this.bomComCachorros = bomComCachorros;
        this.importanciaBomComCachorros = importanciaBomComCachorros;
        this.justificativaBomComCachorros = justificativaBomComCachorros;
        this.bomComGatos = bomComGatos;
        this.importanciaBomComGatos = importanciaBomComGatos;
        this.justificativaBomComGatos = justificativaBomComGatos;
    }

    public UUID getIdChatGpt() {
        return idChatGpt;
    }

    public String getInputUsuario() {
        return inputUsuario;
    }

    public void setInputUsuario(String inputUsuario) {
        this.inputUsuario = inputUsuario;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getImportanciaIdade() {
        return importanciaIdade;
    }

    public void setImportanciaIdade(String importanciaIdade) {
        this.importanciaIdade = importanciaIdade;
    }

    public String getJustificativaIdade() {
        return justificativaIdade;
    }

    public void setJustificativaIdade(String justificativaIdade) {
        this.justificativaIdade = justificativaIdade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getImportanciaSexo() {
        return importanciaSexo;
    }

    public void setImportanciaSexo(String importanciaSexo) {
        this.importanciaSexo = importanciaSexo;
    }

    public String getJustificativaSexo() {
        return justificativaSexo;
    }

    public void setJustificativaSexo(String justificativaSexo) {
        this.justificativaSexo = justificativaSexo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getImportanciaTamanho() {
        return importanciaTamanho;
    }

    public void setImportanciaTamanho(String importanciaTamanho) {
        this.importanciaTamanho = importanciaTamanho;
    }

    public String getJustificativaTamanho() {
        return justificativaTamanho;
    }

    public void setJustificativaTamanho(String justificativaTamanho) {
        this.justificativaTamanho = justificativaTamanho;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getImportanciaPelagem() {
        return importanciaPelagem;
    }

    public void setImportanciaPelagem(String importanciaPelagem) {
        this.importanciaPelagem = importanciaPelagem;
    }

    public String getJustificativaPelagem() {
        return justificativaPelagem;
    }

    public void setJustificativaPelagem(String justificativaPelagem) {
        this.justificativaPelagem = justificativaPelagem;
    }

    public String getCastrado() {
        return castrado;
    }

    public void setCastrado(String castrado) {
        this.castrado = castrado;
    }

    public String getImportanciaCastrado() {
        return importanciaCastrado;
    }

    public void setImportanciaCastrado(String importanciaCastrado) {
        this.importanciaCastrado = importanciaCastrado;
    }

    public String getJustificativaCastrado() {
        return justificativaCastrado;
    }

    public void setJustificativaCastrado(String justificativaCastrado) {
        this.justificativaCastrado = justificativaCastrado;
    }

    public String getTreinado() {
        return treinado;
    }

    public void setTreinado(String treinado) {
        this.treinado = treinado;
    }

    public String getImportanciaTreinado() {
        return importanciaTreinado;
    }

    public void setImportanciaTreinado(String importanciaTreinado) {
        this.importanciaTreinado = importanciaTreinado;
    }

    public String getJustificativaTreinado() {
        return justificativaTreinado;
    }

    public void setJustificativaTreinado(String justificativaTreinado) {
        this.justificativaTreinado = justificativaTreinado;
    }

    public String getNecessidadesEspeciais() {
        return necessidadesEspeciais;
    }

    public void setNecessidadesEspeciais(String necessidadesEspeciais) {
        this.necessidadesEspeciais = necessidadesEspeciais;
    }

    public String getImportanciaNecessidadesEspeciais() {
        return importanciaNecessidadesEspeciais;
    }

    public void setImportanciaNecessidadesEspeciais(String importanciaNecessidadesEspeciais) {
        this.importanciaNecessidadesEspeciais = importanciaNecessidadesEspeciais;
    }

    public String getJustificativaNecessidadesEspeciais() {
        return justificativaNecessidadesEspeciais;
    }

    public void setJustificativaNecessidadesEspeciais(String justificativaNecessidadesEspeciais) {
        this.justificativaNecessidadesEspeciais = justificativaNecessidadesEspeciais;
    }

    public String getVacinado() {
        return vacinado;
    }

    public void setVacinado(String vacinado) {
        this.vacinado = vacinado;
    }

    public String getImportanciaVacinado() {
        return importanciaVacinado;
    }

    public void setImportanciaVacinado(String importanciaVacinado) {
        this.importanciaVacinado = importanciaVacinado;
    }

    public String getJustificativaVacinado() {
        return justificativaVacinado;
    }

    public void setJustificativaVacinado(String justificativaVacinado) {
        this.justificativaVacinado = justificativaVacinado;
    }

    public String getBomComCriancas() {
        return bomComCriancas;
    }

    public void setBomComCriancas(String bomComCriancas) {
        this.bomComCriancas = bomComCriancas;
    }

    public String getImportanciaBomComCriancas() {
        return importanciaBomComCriancas;
    }

    public void setImportanciaBomComCriancas(String importanciaBomComCriancas) {
        this.importanciaBomComCriancas = importanciaBomComCriancas;
    }

    public String getJustificativaBomComCriancas() {
        return justificativaBomComCriancas;
    }

    public void setJustificativaBomComCriancas(String justificativaBomComCriancas) {
        this.justificativaBomComCriancas = justificativaBomComCriancas;
    }

    public String getBomComCachorros() {
        return bomComCachorros;
    }

    public void setBomComCachorros(String bomComCachorros) {
        this.bomComCachorros = bomComCachorros;
    }

    public String getImportanciaBomComCachorros() {
        return importanciaBomComCachorros;
    }

    public void setImportanciaBomComCachorros(String importanciaBomComCachorros) {
        this.importanciaBomComCachorros = importanciaBomComCachorros;
    }

    public String getJustificativaBomComCachorros() {
        return justificativaBomComCachorros;
    }

    public void setJustificativaBomComCachorros(String justificativaBomComCachorros) {
        this.justificativaBomComCachorros = justificativaBomComCachorros;
    }

    public String getBomComGatos() {
        return bomComGatos;
    }

    public void setBomComGatos(String bomComGatos) {
        this.bomComGatos = bomComGatos;
    }

    public String getImportanciaBomComGatos() {
        return importanciaBomComGatos;
    }

    public void setImportanciaBomComGatos(String importanciaBomComGatos) {
        this.importanciaBomComGatos = importanciaBomComGatos;
    }

    public String getJustificativaBomComGatos() {
        return justificativaBomComGatos;
    }

    public void setJustificativaBomComGatos(String justificativaBomComGatos) {
        this.justificativaBomComGatos = justificativaBomComGatos;
    }
}
