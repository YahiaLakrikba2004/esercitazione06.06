package YahiaLakrikba;

import jakarta.persistence.*;

import java.util.List;

public class EventoDAO {
    @PersistenceContext
    private EntityManager em;


    public void setEntityManager(EntityManager em) {
        this.em =em;
    }

    public List<PartitaDiCalcio> getPartiteDiCalcioConRisultato() {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NOT NULL", PartitaDiCalcio.class).getResultList();
    }
}
