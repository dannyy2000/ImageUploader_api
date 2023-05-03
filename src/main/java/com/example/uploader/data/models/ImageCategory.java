package com.example.uploader.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ImageCategory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Image> images;
}
