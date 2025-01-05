import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVmanager {
    List<Athlete> lesAthletes;
    List<Equipe> lesEquipes;
    List<Pays> lesPays;
    List<Sport> lesSports;
    List<Epreuve> lesEpreuves;

    public void csvToListe(String chemin) {

        String ligne;
        String split = ",";
        // Epreuve<Athlete> vraiEpreuve;

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            line.readLine();
            while ((ligne = line.readLine()) != null) {

                // tableau de String => String []
                String[] ligneElems = ligne.split(split);
              
                if (ligneElems.length >= 9) {
                    try {

                        String nom = ligneElems[0];
                        String prenom = ligneElems[1];
                        char sexe = ligneElems[2].charAt(0);
                        String nomPays = ligneElems[3];
                        Pays pays = new Pays(nomPays);
                        String nomSport = ligneElems[4];
                        int idEpreuve = Integer.parseInt(ligneElems[5]);
                        int force = Integer.parseInt(ligneElems[6]);
                        int endurance = Integer.parseInt(ligneElems[7]);
                        int agilite = Integer.parseInt(ligneElems[8]);

                        Athlete ath = new Athlete(Athlete.getNewId(), nom, prenom, sexe, force, endurance, agilite);
                        lesAthletes.add(ath);
                        Equipe eqSolo = new Equipe(Equipe.getNewId(), 1, sexe); // a voir
                        eqSolo.participer(ath);
                        lesEquipes.add(eqSolo);

                        for(Pays pa : lesPays){
                            if(pa.getNompays().equals(nomPays)){
                                pays.participer(eqSolo);
                                lesPays.add(pays);
                                break;
                            }
                            lesPays.get(lesPays.indexOf(pays)).participer(eqSolo);
                        }


                        if(lesSports.contains(nomSport)){
                            Sport sp = lesSports.get(lesSports.indexOf(nomSport));
                                if (sp.getNbJoueur() == 1)
                                    for (Epreuve ep : lesEpreuves) {
                                        if (ep.getID()==idEpreuve) {
                                            ep.participer(eqSolo);
                                            break;
                                        }
                                        if(lesEpreuves.indexOf(ep)==lesEpreuves.size()-1){
                                        Epreuve newEP = new Epreuve(Epreuve.getNewId(), "nom Epreuve", sexe, "inconnue",
                                                "score", sp, 5.0, 5.0, 5.0);
                                        System.out.println("Veuillez configurer l'épreuve");
                                        newEP.participer(eqSolo);
                                        lesEpreuves.add(newEP);}

                                    }
                                else {
                                    System.err.println("Le sport indiqué n'est pas fait pour les athletes seuls");
                                }
                                
                            }
                        else{
                            Sport newSport = new Sport(nomSport, 1, 1);
                            lesSports.add(newSport);
                            Epreuve newEP = new Epreuve(Epreuve.getNewId(), "nom Epreuve", sexe, "inconnue",
                                                "score", newSport, 5.0, 5.0, 5.0);
                            System.out.println("Veuillez configurer l'épreuve");
                            newEP.participer(eqSolo);
                            lesEpreuves.add(newEP);}
                        }
                       
                    catch (Exception e) {
                        System.out.println("erreur format ligne : " + ligne);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
