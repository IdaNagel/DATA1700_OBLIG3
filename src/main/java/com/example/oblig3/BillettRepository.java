package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billett innBillet){
        String sql = "INSERT INTO Billett (film, antall, fornavn, etternavn, telefonnr, epost) VALUES (?,?,?,?,?,?)";
        db.update(sql,innBillet.getFilm(),innBillet.getAntall(),innBillet.getFornavn(),innBillet.getEtternavn(),innBillet.getTelefonnummer(),innBillet.getEpost());
    }

    public List<Billett> hentAlleBilletter(){
        String sql = "SELECT * FROM Billett";
        List<Billett> alleBilletter = db.query(sql, new BeanPropertyRowMapper(Billett.class));
        return alleBilletter;
    }

    public void slettAlleKunder(){
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
}