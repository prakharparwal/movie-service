package com.movie.service.data;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import javax.persistence.*;

@Entity
@Table(name ="MOVIE")
public class Movie implements Callback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RELEASE_YEAR")
    private int releaseYear;

    public Movie() {
    }

    public Movie(int id, String name, int releaseYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        System.out.println("Ok record produced." +metadata);
    }
}
