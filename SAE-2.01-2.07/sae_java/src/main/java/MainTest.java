
//import org.junit.*;
//import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
class MainTest {
    public static void main(String [] args) throws Exception, IDdejaExistantException {

        JeuxOlympique JO2024 = new JeuxOlympique("Olympiques racistes", "France", 2024);

        Sport groscaca = new Sport("caca", 1);
        Sport race = new Sport("racisme");
        Sport tennis = new Sport("tennis", 1);


        Epreuve diarrhee = new Epreuve(1,"diarrhee", 'H' , "junior", "Score", groscaca, 36, 14, 0.1, 0.8, 0.7);
        Epreuve duelracing = new Epreuve(2,"duel auto racing", 'H' , "junior", "Duel", race, 0.1, 0.5, 0.9);
        //Epreuve tennnis = new Epreuve(3,"teniis", 'F', "senior", "Score", tennis);


        JO2024.ajouteSport(groscaca);
        JO2024.ajouteSport(race);
        JO2024.ajouteEpreuve(diarrhee);
        JO2024.ajouteEpreuve(duelracing);

        
        Pays france = new Pays("France");
        Pays allemagne = new Pays("Allemagne");
        Pays italie = new Pays("Italie");
        Pays pologne = new Pays("Pologne");
        Pays chine = new Pays("Chine");
        Pays etats_unis = new Pays("Etats-Unis");

        JO2024.ajoutePays(etats_unis);
        JO2024.ajoutePays(france);
        JO2024.ajoutePays(pologne);
        JO2024.ajoutePays(italie);
        JO2024.ajoutePays(chine);
        JO2024.ajoutePays(allemagne);

        // Hommes
        Athlete atl1 = new Athlete("John", "Doe", 'H', 20, 20, 20);
        Athlete atl2 = new Athlete("Mike", "Johnson", 'H', 10, 10, 10);

        Athlete atl3 = new Athlete("Luke", "Brown", 'H', 10, 10, 10);
        Athlete atl4 = new Athlete("Chris", "Evans", 'H', 0, 0, 0);

        Athlete atl5 = new Athlete("David", "Garcia", 'H', 9, 7, 8);
        Athlete atl6 = new Athlete("James", "Smith", 'H', 17, 15, 13);

        Athlete atl7 = new Athlete("Robert", "Wilson", 'H', 6, 9, 12);
        Athlete atl8 = new Athlete("Michael", "Martinez", 'H', 20, 18, 19);

        Athlete atl9 = new Athlete("William", "Lopez", 'H', 11, 14, 10);
        Athlete atl10 = new Athlete( "Thomas", "Anderson", 'H', 12, 13, 15);

        Athlete atl11 = new Athlete("Charles", "Perez", 'H', 8, 16, 14);
        Athlete atl12 = new Athlete("Daniel", "Thompson", 'H', 19, 17, 20);




        Equipe equipeUScaca = new Equipe(1, 'H');
        Equipe equipeFRcaca = new Equipe( 1, 'H');
        Equipe equipePLcaca = new Equipe( 1, 'H');
        Equipe equipeCNcaca = new Equipe( 1, 'H');
        Equipe equipeALcaca = new Equipe( 1, 'H');
        System.out.println("GOOD");


        Equipe equipeUSrace = new Equipe(3, 'H');
        Equipe equipeFRrace = new Equipe(3, 'H');
        Equipe equipePLrace = new Equipe(3, 'H');
        Equipe equipeCNrace = new Equipe(3, 'H');
        Equipe equipeALrace = new Equipe(3, 'H');
        System.out.println("GOOD");
        
        france.participer(equipeFRcaca);
        pologne.participer(equipePLcaca);
        chine.participer(equipeCNcaca);
        etats_unis.participer(equipeUScaca);
        allemagne.participer(equipeALcaca);
        System.out.println("GOOD");

        france.participer(equipeFRrace);
        pologne.participer(equipePLrace);
        chine.participer(equipeCNrace);
        etats_unis.participer(equipeUSrace);
        allemagne.participer(equipeALrace);
        System.out.println("GOOD");


        equipeFRcaca.participer(atl1);
        equipePLcaca.participer(atl2);
        equipeCNcaca.participer(atl3);
        equipeUScaca.participer(atl4);
        equipeALcaca.participer(atl5);
        System.out.println("GOOD");

        
        equipeFRrace.participer(atl1);
        equipePLrace.participer(atl2);
        equipeCNrace.participer(atl3);
        equipeUSrace.participer(atl4);
        equipeFRrace.participer(atl5);
        equipePLrace.participer(atl6);
        equipeCNrace.participer(atl7);
        equipeUSrace.participer(atl8);
        equipeFRrace.participer(atl9);
        equipePLrace.participer(atl10);
        equipeCNrace.participer(atl11);
        equipeUSrace.participer(atl12);
        System.out.println("GOOD (fin participer equipe)");

        diarrhee.participer(equipeFRcaca);
        diarrhee.participer(equipePLcaca);
        diarrhee.participer(equipeCNcaca);
        diarrhee.participer(equipeUScaca);
        diarrhee.participer(equipeALcaca);
        System.out.println("GOOD");

        duelracing.participer(equipeFRrace);
        duelracing.participer(equipePLrace);
        duelracing.participer(equipeCNrace);
        duelracing.participer(equipeUSrace);
        System.out.println("GOOD");

        
        // System.out.println("\nGetter\n");

        // if (atl1.getAgilite() == 1)
        //     System.out.print("test getAgilite pass\n");
        // else System.out.println("test fail\n");

        // if (atl1.getEndurance() == 2)
        //     System.out.print("test getEndurance pass\n");
        // else System.out.println("test getEndurence fail\n");
    
        // if (atl1.getForce() == 3)
        //     System.out.print("test getForce pass\n");
        // else System.out.println("test getForce fail\n");

        // if (atl1.getNomA().equals("John"))
        //     System.out.print("test getNomA pass\n");
        // else System.out.println("test getNomA fail\n");


        // System.out.println("\nScore\n");

        // if (chifoumimi.getLeSports().equals(chifoumi))
        //     System.out.print("test getLeSports pass\n");
        // else System.out.println("test getLeSports fail\n");

        // if (chifoumimi.afficheLesEquipes().size() == 4)
        //     System.out.print("test afficheLesEquipes pass\n");
        // else System.out.println("test afficheLesEquipes fail\n");


        // if (chifoumimi.lanceEpreuve().size() == 4)
        //     System.out.print("test lanceEpreuve classement pass\n");
        // else System.out.println("test lanceEpreuve classement fail\n");

        // if (chifoumimi.lanceEpreuve().get(0).equals(equipeCNchiffoumi))
        //     System.out.print("test lanceEpreuve 1er pass\n");
        // else System.out.println("test lanceEpreuve 1er fail\n");

        // //if (chifoumimi.lanceEpreuve().get(0).getPays().getmedailles_or() == 1)
        // //    System.out.print("test getmedailles_or pass\n");
        // //else System.out.println("test getmedailles_or fail\n");

        
        // System.out.println("\nDuel\n");

        // if (pierrepapierciseaux.getLeSports().equals(ppc))
        //     System.out.print("test getLeSports pass\n");
        // else System.out.println("test getLeSports fail\n");

        // if (pierrepapierciseaux.afficheLesEquipes().size() == 4)
        //     System.out.print("test afficheLesEquipes pass\n");
        // else System.out.println("test afficheLesEquipes fail\n");


        // if (pierrepapierciseaux.lanceEpreuve().size() == 4)
        //     System.out.print("test lanceEpreuve classement pass\n");
        // else System.out.println("test lanceEpreuve classement fail\n");

        // if (pierrepapierciseaux.lanceEpreuve().get(0).equals(equipeCNchiffoumi))
        //     System.out.print("test lanceEpreuve 1er pass\n");
        // else System.out.println("test lanceEpreuve 1er fail\n");

        //if (pierrepapierciseaux.lanceEpreuve().get(0).getPays().getmedailles_or() == 1)
        //    System.out.print("test getmedailles_or pass\n");
        //else System.out.println("test getmedailles_or fail\n");

    
        diarrhee.lanceEpreuve2(false);
        //System.out.println(diarrhee.getClassement());
        for(Equipe eq : diarrhee.getClassement()){
            System.out.println(eq.toString() + "\n");
        }
        for(Match mat : diarrhee.getLesMatchs()){
            System.out.println(mat.toString());
        }

        System.out.println("//////////");
        duelracing.lanceEpreuve2(false);
        System.out.println(duelracing.getClassement() + "\n");
        for(Match mat : duelracing.getLesMatchs()){
            System.out.println(mat.toString());
        }




    
        CSVmanager.csvToListe("C:/Users/shank/OneDrive/Bureau/Travail/SAE 2.01 2.07 java/SAE-2.01-2.07-java-1/donnees.csv");
        System.out.println("glob");System.out.println("glob");System.out.println("glob");System.out.println("glob");System.out.println("glob");System.out.println("glob");
        System.out.println(CSVmanager.getData());
        System.out.println(CSVmanager.getData().get("Athlete").size());



    }
}


