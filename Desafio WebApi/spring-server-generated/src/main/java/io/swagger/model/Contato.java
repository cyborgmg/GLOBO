package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The root of the Contato type&#x27;s schema.
 */
@ApiModel(description = "The root of the Contato type's schema.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-04T13:15:51.513Z[GMT]")
public class Contato   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("canal")
  private String canal = null;

  @JsonProperty("valor")
  private String valor = null;

  @JsonProperty("obs")
  private String obs = null;

  public Contato(String id, String nome, String canal, String valor, String obs) {
	super();
	this.id = id;
	this.nome = nome;
	this.canal = canal;
	this.valor = valor;
	this.obs = obs;
}

/**
   * Identificador único
   * @return id
  **/
  @ApiModelProperty(value = "Identificador único")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Contato nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome que descreva o contato
   * @return nome
  **/
  @ApiModelProperty(required = true, value = "Nome que descreva o contato")
      @NotNull

    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Contato canal(String canal) {
    this.canal = canal;
    return this;
  }

  /**
   * Tipo de canal de contato, podendo ser email, celular ou fixo
   * @return canal
  **/
  @ApiModelProperty(required = true, value = "Tipo de canal de contato, podendo ser email, celular ou fixo")
      @NotNull

    public String getCanal() {
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public Contato valor(String valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Valor para o canal de contato
   * @return valor
  **/
  @ApiModelProperty(required = true, value = "Valor para o canal de contato")
      @NotNull

    public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public Contato obs(String obs) {
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
    Contato contato = (Contato) o;
    return Objects.equals(this.id, contato.id) &&
        Objects.equals(this.nome, contato.nome) &&
        Objects.equals(this.canal, contato.canal) &&
        Objects.equals(this.valor, contato.valor) &&
        Objects.equals(this.obs, contato.obs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, canal, valor, obs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contato {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
