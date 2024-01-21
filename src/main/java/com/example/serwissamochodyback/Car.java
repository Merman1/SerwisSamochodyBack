package com.example.serwissamochodyback;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marka;
    private String model;
    private int rok;
    private String moc_silnika;
    private double cena;
    private String opis;
    private boolean dostepny;
    @Lob
    @Column(name="obraz", columnDefinition="blob")
    private byte[] obraz; // Zmiana na typ byte[] dla przechowywania obrazu w bazie danych

    @OneToMany(mappedBy = "car")
    private List<PurchasedCar> purchasedCars;
    private String typ;

    private boolean klimatyzacja;

    public Car(Long id, String marka, String model, int rok, String moc_silnika, double cena, String opis, boolean dostepny, byte[] obraz, String typ, boolean klimatyzacja) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rok = rok;
        this.moc_silnika = moc_silnika;
        this.cena = cena;
        this.opis = opis;
        this.dostepny = dostepny;
        this.obraz = obraz;
        this.typ = typ;
        this.klimatyzacja = klimatyzacja;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getMoc_silnika() {
        return moc_silnika;
    }

    public void setMoc_silnika(String moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isDostepny() {
        return dostepny;
    }

    public void setDostepny(boolean dostepny) {
        this.dostepny = dostepny;
    }

    public byte[] getObraz() {
        return obraz;
    }

    public void setObraz(byte[] obraz) {
        this.obraz = obraz;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public boolean isKlimatyzacja() {
        return klimatyzacja;
    }

    public void setKlimatyzacja(boolean klimatyzacja) {
        this.klimatyzacja = klimatyzacja;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rok=" + rok +
                ", moc_silnika='" + moc_silnika + '\'' +
                ", cena=" + cena +
                ", opis='" + opis + '\'' +
                ", dostepny=" + dostepny +
                ", obraz=" + Arrays.toString(obraz) +
                ", typ='" + typ + '\'' +
                ", klimatyzacja=" + klimatyzacja +
                '}';
    }
}
