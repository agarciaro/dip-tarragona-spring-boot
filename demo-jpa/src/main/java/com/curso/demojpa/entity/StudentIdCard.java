package com.curso.demojpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="StudentIdCard")
@Table(
	name = "student_id_card"
)
public class StudentIdCard {
	
	@Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
	
	@Column(
            name = "card_number",
            nullable = false,
            length = 15,
            unique = true
    )
    private String cardNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "student_id",
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "student_id_fk")
	)
	private Student student;
}
