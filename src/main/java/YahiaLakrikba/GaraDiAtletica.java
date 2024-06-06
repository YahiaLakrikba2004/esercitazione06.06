package YahiaLakrikba;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
@DiscriminatorValue("GaraDiAtletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;


    public GaraDiAtletica(Long id, Set<Persona> atleti, Persona vincitore) {
        super(id);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
