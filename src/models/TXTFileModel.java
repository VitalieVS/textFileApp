package models;

public class TXTFileModel {
    String id;
    String prenume;
    String nume;
    String grupa;
    String bursa;

    public TXTFileModel(String[] data) {
        this.id = data[0];
        this.prenume = data[1];
        this.nume = data[2];
        this.grupa = data[3];
        this.bursa = data[4];

    }

    public String getBursa() {
        return bursa;
    }

    public String getGrupa() {
        return grupa;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getId() {
        return id;
    }

    public void setBursa(String bursa) {
        this.bursa = bursa;
    }

    public String getValue(int j) {
        switch (j) {
            case 0 -> {
                return id;
            }
            case 1 -> {
                return prenume;
            }
            case 2 -> {
                return nume;
            }
            case 3 -> {
                return grupa;
            }
            case 4 -> {
                return bursa;
            }
            default -> {
                return null;
            }
        }
    }
}
