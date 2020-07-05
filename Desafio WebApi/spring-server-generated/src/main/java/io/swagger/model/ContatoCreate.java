package io.swagger.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The root of the ContatoCreate type&#x27;s schema.
 */
@ApiModel(description = "The root of the ContatoCreate type's schema.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-04T13:15:51.513Z[GMT]")
public class ContatoCreate   {
  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("canal")
  private String canal = null;

  @JsonProperty("valor")
  private String valor = null;

  @JsonProperty("obs")
  private String obs = null;

  public ContatoCreate nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome que descreva o contato
   * @return nome
  **/
  @ApiModelProperty(value = "Nome que descreva o contato")
  
    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public ContatoCreate canal(String canal) {
    this.canal = canal;
    return this;
  }

  /**
   * Tipo de canal de contato, podendo ser email, celular ou fixo
   * @return canal
  **/
  @ApiModelProperty(value = "Tipo de canal de contato, podendo ser email, celular ou fixo")
  
    public String getCanal() {
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public ContatoCreate valor(String valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Valor para o canal de contato
   * @return valor
  **/
  @ApiModelProperty(value = "Valor para o canal de contato")
  
    public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public ContatoCreate obs(String obs) {
    this.obs = obs;
    return this;
  }

  /**
   * Qualquer observação que seja pertinente
   * @return obs
  **/
  @ApiModelProperty(value = "Qualquer observação que seja pertinente")
  
    public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContatoCreate contatoCreate = (ContatoCreate) o;
    return Objects.equals(this.nome, contatoCreate.nome) &&
        Objects.equals(this.canal, contatoCreate.canal) &&
        Objects.equals(this.valor, contatoCreate.valor) &&
        Objects.equals(this.obs, contatoCreate.obs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, canal, valor, obs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContatoCreate {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    canal: ").append(toIndentedString(canal)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    obs: ").append(toIndentedString(obs)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
