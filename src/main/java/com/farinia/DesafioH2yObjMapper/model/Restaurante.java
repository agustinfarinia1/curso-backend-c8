package com.farinia.DesafioH2yObjMapper.model;


import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "restaurantes")
public class Restaurante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String hora_inicio;
    private String hora_fin;
    private String fecha_creacion;
    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
}
