package YahiaLakrikba;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    private String genere;
    private boolean inStreaming;




    public Concerto(Long id, String genere, boolean inStreaming) {
        super(id);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
