package YahiaLakrikba;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("U4-D13").createEntityManager();


        Persona atleta1 = new Persona("Mario", "Rossi" );
        Persona atleta2 = new Persona("Luigi", "Verdi");
        Persona atleta3 = new Persona("John", "Doe");


        Set<Persona> atleti = new HashSet<>();
        atleti.add(atleta1);
        atleti.add(atleta2);
        atleti.add(atleta3);


        Persona vincitore = atleta2;


        GaraDiAtletica gara = new GaraDiAtletica(null, atleti, vincitore);


        em.getTransaction().begin();
        em.persist(atleta1);
        em.persist(atleta2);
        em.persist(atleta3);
        em.persist(gara);
        em.getTransaction().commit();


        em.getTransaction().begin();
        GaraDiAtletica garaRecuperata = em.find(GaraDiAtletica.class, gara.getId());
        em.getTransaction().commit();


        System.out.println("Gara di Atletica:");
        System.out.println("Atleti:");
        for (Persona atleta : garaRecuperata.getAtleti()) {
            System.out.println("- " + atleta.getNome() + " " + atleta.getCognome());
        }
        System.out.println("Vincitore: " + garaRecuperata.getVincitore().getNome() + " " + garaRecuperata.getVincitore().getCognome());


        em.close();
    }
}
