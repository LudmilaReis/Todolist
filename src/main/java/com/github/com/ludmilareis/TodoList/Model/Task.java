package com.github.com.ludmilareis.TodoList.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


/*Anotation entitity entidade para camada de dados*/
@Entity
@Table(name= "tasks")
@Setter
@Getter
@ToString
public class Task {
//Campos e colunas da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// para gerar sem sequência
    private Long id; //chave primária

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime deadLine;

    @CreationTimestamp //carimbo de quando a automação foi criada
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;//A aplicação cria atomPostresqlatico

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
