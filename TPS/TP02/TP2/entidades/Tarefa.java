//Estrutura de Tarefas feita por André Mendes, Caio Gomes e Daniel Salgado

package entidades;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.time.LocalDate;

import aeds3.Registro;

public class Tarefa implements Registro {

  //variáveis e construtores
  private int ID;
  private String nome;
  private LocalDate dataCriacao;
  private LocalDate dataConclusao;
  private String status;
  private String prioridade;
  private int idCategoria;

  public Tarefa() {
    this(-1,"", LocalDate.now(), LocalDate.now(), "", "", -1);
  }

  public Tarefa(String n, LocalDate dcr, LocalDate dco, String s, String p, int idC) {
    this(-1, n, dcr, dco, s, p, idC);
  }

  public Tarefa(int id, String n, LocalDate dcr, LocalDate dco, String s, String p, int idC) {
    this.ID = id;
    this.nome = n;
    this.dataCriacao = dcr;
    this.dataConclusao = dco;
    this.status = s;
    this.prioridade = p;
    this.idCategoria = idC;
  }

  //getters e setters
  public int getID() {
    return this.ID;
  }

  public void setID(int i) {
    this.ID = i;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataConclusao(LocalDate dataConclusao) {
    this.dataConclusao = dataConclusao;
  }

  public LocalDate getDataConclusao() {
    return dataConclusao;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setPrioridade(String prioridade) {
    this.prioridade = prioridade;
  }

  public String getPrioridade() {
    return prioridade;
  }

  public int getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
  }

  //converter pra sequencia de bytes
  public byte[] toByteArray() throws Exception {
    ByteArrayOutputStream ba_out = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(ba_out);
    dos.writeInt(this.ID);
    dos.writeUTF(this.nome);
    dos.writeInt((int) this.dataCriacao.toEpochDay());
    dos.writeInt((int) this.dataConclusao.toEpochDay());
    dos.writeUTF(this.status);
    dos.writeUTF(this.prioridade);
    dos.writeInt(this.idCategoria);
    return ba_out.toByteArray();
  }

  //converte da sequencia de bytes pro original
  public void fromByteArray(byte[] ba) throws Exception {
    ByteArrayInputStream ba_in = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(ba_in);
    this.ID = dis.readInt();
    this.nome = dis.readUTF();
    this.dataCriacao = LocalDate.ofEpochDay(dis.readInt());
    this.dataConclusao = LocalDate.ofEpochDay(dis.readInt());
    this.status = dis.readUTF();
    this.prioridade = dis.readUTF();
    this.idCategoria = dis.readInt();
  }

  public String toString() {
    return "ID: " + this.ID +
        "\nTarefa: " + this.nome +
        "\nData de criação da tarefa: " + this.dataCriacao +
        "\nData de conclusão da tarefa: " + this.dataConclusao +
        "\nStatus da tarefa: " + this.status +
        "\nPrioridade da tarefa: " + this.prioridade +
        "\nCategoria: " + this.idCategoria;
  }

  public int compareTo(Object b) {
    return this.getID() - ((Tarefa) b).getID();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}
