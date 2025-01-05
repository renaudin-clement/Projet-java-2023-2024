/* au cas ou :

 ! compiler : javac -d bin src/main/java/*.java
 ! executer : java -cp bin Executable
 * 
 * jusqu'au jour ou on fera de l'IHM
 */

import java.util.*;

public class Executable {
    public static void main(String[] args) throws IDdejaExistantException, Exception {

        JeuxOlympique JO2024 = new JeuxOlympique("France", 2024);

        Sport sport1 = new Sport("sport1", 1, 0.7, 0.1, 0.1, 1);
        Sport sport2 = new Sport("sport2", 1, 0.7, 0.1, 0.1, 2);
        Sport sport3 = new Sport("sport3", 2, 0.4, 0.4, 0.2, 6);

        Epreuve Jeu1 = new Epreuve(1, "Jeu1", 'H', "junior", "Score", sport1);
        Epreuve Jeu2 = new Epreuve(2, "Jeu2", 'H', "junior", "Duel", sport2);
        Epreuve Jeu3 = new Epreuve(3, "Jeu3", 'H', "senior", "Score", sport3);

        JO2024.ajouteSport(sport1);
        JO2024.ajouteSport(sport2);

        sport2.setRegle(1, 1, 3);

        JO2024.ajouteEpreuve(Jeu1);
        JO2024.ajouteEpreuve(Jeu2);

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
        Athlete atl1 = new Athlete(1, "John", "Doe", 'H', 20, 20, 20);
        Athlete atl2 = new Athlete(2, "Mike", "Johnson", 'H', 10, 10, 10);

        Athlete atl3 = new Athlete(3, "Luke", "Brown", 'H', 10, 10, 10);
        Athlete atl4 = new Athlete(4, "Chris", "Evans", 'H', 0, 0, 0);

        Athlete atl5 = new Athlete(5, "David", "Garcia", 'F', 9, 7, 8);
        Athlete atl6 = new Athlete(6, "James", "Smith", 'H', 17, 15, 13);

        Athlete atl7 = new Athlete(7, "Robert", "Wilson", 'H', 6, 9, 12);
        Athlete atl8 = new Athlete(8, "Michael", "Martinez", 'H', 20, 18, 19);

        Athlete atl9 = new Athlete(9, "William", "Lopez", 'H', 11, 14, 10);
        Athlete atl10 = new Athlete(10, "Thomas", "Anderson", 'H', 12, 13, 15);

        Athlete atl11 = new Athlete(11, "Charles", "Perez", 'H', 8, 16, 14);
        Athlete atl12 = new Athlete(12, "Daniel", "Thompson", 'H', 19, 17, 20);

        // Femmes
        /*
         * Athlete atl13 = new Athlete("Jane", "Smith", "F", 18, 16, 17);
         * Athlete atl14 = new Athlete("Emily", "Davis", "F", 19, 20, 18);
         * 
         * Athlete atl15 = new Athlete("Anna", "Wilson", "F", 12, 14, 13);
         * Athlete atl16 = new Athlete("Laura", "Martinez", "F", 16, 17, 15);
         * 
         * Athlete atl17 = new Athlete("Sophia", "Anderson", "F", 11, 10, 9);
         * Athlete atl18 = new Athlete("Isabella", "Thomas", "F", 14, 15, 16);
         * 
         * Athlete atl19 = new Athlete("Olivia", "Jackson", "F", 13, 11, 12);
         * Athlete atl20 = new Athlete("Mia", "White", "F", 17, 18, 19);
         * 
         * Athlete atl21 = new Athlete("Ava", "Harris", "F", 10, 12, 14);
         * Athlete atl22 = new Athlete("Abigail", "Clark", "F", 8, 9, 11);
         * 
         * Athlete atl23 = new Athlete("Madison", "Rodriguez", "F", 15, 14, 13);
         * Athlete atl24 = new Athlete("Charlotte", "Lewis", "F", 20, 19, 18);
         */

        Equipe equipeUSchiffoumi = new Equipe(1, 1, 'H');
        Equipe equipeFRchiffoumi = new Equipe(2, 1, 'H');
        Equipe equipePLchiffoumi = new Equipe(3, 1, 'H');
        Equipe equipeCNchiffoumi = new Equipe(4, 1, 'H');

        france.participer(equipeFRchiffoumi);
        pologne.participer(equipePLchiffoumi);
        chine.participer(equipeCNchiffoumi);
        etats_unis.participer(equipeUSchiffoumi);

        equipeFRchiffoumi.participer(atl1);
        equipePLchiffoumi.participer(atl2);
        equipeCNchiffoumi.participer(atl3);
        equipeUSchiffoumi.participer(atl4);
        //equipeUSchiffoumi.participer(atl5); // doit afficher une erreur

        Jeu1.participer(equipeFRchiffoumi);
        Jeu1.participer(equipePLchiffoumi);
        Jeu1.participer(equipeCNchiffoumi);
        Jeu1.participer(equipeUSchiffoumi);

        Jeu2.participer(equipeFRchiffoumi);
        Jeu2.participer(equipePLchiffoumi);
        Jeu2.participer(equipeCNchiffoumi);
        Jeu2.participer(equipeUSchiffoumi);

        /*
         * List<Equipe> resultchifoumi = chifoumimi.lanceEpreuve();
         * for(Equipe equip : resultchifoumi){
         * System.out.println(equip.toString());
         * }
         * System.out.println(resultchifoumi);
         */

        System.out.println(JO2024);
        
        System.out.println(Jeu1);
        
        //! méthode qui simule les JO
        JO2024.simulJO();


        Comparator<Pays> compOr = new CompareMedailleTotal();
        List<Pays> classement = JO2024.classement(compOr);
        System.out.print("classement final des pays : "+classement);

        System.out.println();

        System.out.println("nb medaille d'or de '" + classement.get(0).getNompays() + "' qui a obtenue : "
                + classement.get(0).getmedailles_or());
        System.out.println("nb medaille d'argent de '" + classement.get(0).getNompays() + "' qui a obtenue : "
                + classement.get(0).getmedailles_argent());
        System.out.println("nb medaille d'bronze de '" + classement.get(0).getNompays() + "' qui a obtenue : "
                + classement.get(0).getmedailles_bronze());

        System.out.println();

        System.out.println("nb medaille d'or de '" + classement.get(1).getNompays() + "' qui a obtenue : "
                + classement.get(1).getmedailles_or());
        System.out.println("nb medaille d'argent de '" + classement.get(1).getNompays() + "' qui a obtenue : "
                + classement.get(1).getmedailles_argent());
        System.out.println("nb medaille d'bronze de '" + classement.get(1).getNompays() + "' qui a obtenue : "
                + classement.get(1).getmedailles_bronze());

        System.out.println();

        System.out.println("match de jeu1 : " + Jeu1.getLesMatchs());
        System.out.println("classement de jeu1 : " + Jeu1.getClassement());

        System.out.println();

        System.out.println("match de jeu2 : " + Jeu2.getLesMatchs());
        System.out.println("classement de jeu2 : " + Jeu2.getClassement());

        System.out.println("toString de première equipe du pays vainqueur : "
                +classement.get(0).afficheLesEquipes().get(0).getLesAthletes());
        

    }

}
