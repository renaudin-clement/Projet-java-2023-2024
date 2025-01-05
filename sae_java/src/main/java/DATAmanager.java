/**import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DATAmanager {
    List<Athlete> lesAthletes;
    Athlete at;
    List<Equipe> lesEquipes;
    Equipe eq;
    List<Pays> lesPays;
    Pays pa;
    List<Sport> lesSports;
    Sport sp;
    List<Epreuve> lesEpreuves;
    Epreuve ep;
    List<JeuxOlympique> lesJO;
    JeuxOlympique jo;
    String statusLecture = "";

    /#/
     * @param chemin
     \#\
    public void dataToListe(String chemin) {
        // List<Athlete> listeAthletes = new ArrayList<>();

        String ligne;
        String split = ",";

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            line.readLine();
            while ((ligne = line.readLine()) != null) {

                // tableau de String => String []
                String[] ligneElems = ligne.split(split);

                switch (ligneElems[0]) {
                    case "":
                        break;

                    case "<classe> Sports":
                        majListe(statusLecture);
                        statusLecture = "sport";
                        break;
                    case "<classe> Athletes":
                        majListe(statusLecture);
                        statusLecture = "athlete";
                        break;
                    case "<classe> Equipes":
                        majListe(statusLecture);
                        statusLecture = "equip";
                        break;
                    case "<classe> Pays":
                        majListe(statusLecture);
                        statusLecture = "pays";
                        break;
                    case "<classe> Epreuves":
                        majListe(statusLecture);
                        statusLecture = "epreuve";
                        break;
                    case "<classe> Jeux Olympique":
                        majListe(statusLecture);
                        statusLecture = "JO";
                        break;

                    default:
                        switch (statusLecture) {
                            case "JO":
                                if (!(ligneElems[0] == "> insert pays") && !(ligneElems[0] == "> insert epreuve"
                                        && !(ligneElems[0] == "> insert sport")))
                                    if (ligneElems.length == 2) {
                                        try {
                                            String nom = ligneElems[1];
                                            int date = Integer.parseInt(ligneElems[0]);
                                            try {
                                                jo = new JeuxOlympique(nom, date);
                                            } catch (Exception x) {
                                                System.err.println(x);
                                            }
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert pays") {
                                    List<String> PaysAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        PaysAInsert.add(ligneElems[i]);
                                    for (Pays p : lesPays)
                                        if (PaysAInsert.contains(p.getNompays())) {
                                            jo.ajoutePays(p);
                                            PaysAInsert.remove(p.getNompays());
                                        }
                                } else if (ligneElems[0] == "> insert epreuve") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Epreuve e : lesEpreuves)
                                        if (IdAInsert.contains(e.getID())) {
                                            jo.ajouteEpreuve(e);
                                            IdAInsert.remove(e.getID());
                                        }
                                }

                                else if (ligneElems[0] == "> insert sport") {
                                    List<String> SportAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        SportAInsert.add(ligneElems[i]);
                                    for (Sport s : lesSports)
                                        if (SportAInsert.contains(s.getNomSport())) {
                                            jo.ajouteSport(s);
                                            SportAInsert.remove(s.getNomSport());
                                        }

                                }
                                break;
                            case "epreuve":
                                if (!(ligneElems[0] == "> insert equipe") && !(ligneElems[0] == "> insert athlete"))
                                    if (ligneElems.length == 6) {
                                        try {
                                            int id = Integer.parseInt(ligneElems[0]);
                                            String nom = ligneElems[1];
                                            char sexe = ligneElems[2].charAt(0);
                                            String cat = ligneElems[3];
                                            String type = ligneElems[4];
                                            Sport sport = null;
                                            String nomsport = ligneElems[5];
                                            for (Sport spor : lesSports)
                                                if (spor.getNomSport().equals(nomsport))
                                                    sport = spor;
                                            try {
                                                if (sport != null)
                                                    ep = new Epreuve(id, nom, sexe, cat, type, sport);
                                            } catch (Exception x) {
                                                System.err.println(x);
                                            }
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    } else if (ligneElems.length == 8) {
                                        int id = Integer.parseInt(ligneElems[0]);
                                        String nom = ligneElems[1];
                                        char sexe = ligneElems[2].charAt(0);
                                        String cat = ligneElems[3];
                                        String type = ligneElems[4];
                                        Sport sport = null;
                                        String nomsport = ligneElems[5];
                                        Double moy = Double.parseDouble(ligneElems[6]);
                                        Double rec = Double.parseDouble(ligneElems[7]);
                                        for (Sport spor : lesSports)
                                            if (spor.getNomSport().equals(nomsport))
                                                sport = spor;
                                        try {
                                            if (sport != null)
                                                ep = new Epreuve(id, nom, sexe, cat, type, sport, moy, rec);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert equipe") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Equipe e : lesEquipes)
                                        if (IdAInsert.contains(e.getID())) {
                                            pa.participer(e);
                                            IdAInsert.remove(e.getID());
                                        }
                                } else if (ligneElems[0] == "> insert athlete") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            for (Equipe e : lesEquipes) {
                                                if (e.getTaille() == 1 && e.getLesAthletes().contains(a)) {
                                                    ep.participer(e);
                                                    IdAInsert.remove(a.getID());
                                                    break;
                                                }
                                            }

                                        }
                                }
                                break;
                            case "pays":
                                if (!(ligneElems[0] == "> insert equipe") && !(ligneElems[0] == "> insert athlete"))
                                    if (ligneElems.length == 1) {
                                        try {
                                            String nom = ligneElems[0];
                                            try {
                                                pa = new Pays(nom);
                                            } catch (Exception x) {
                                                System.err.println(x);
                                            }
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert equipe") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Equipe e : lesEquipes)
                                        if (IdAInsert.contains(e.getID())) {
                                            pa.participer(e);
                                            IdAInsert.remove(e.getID());
                                        }
                                } else if (ligneElems[0] == "> insert athlete") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            boolean existe = false;
                                            for (Equipe e : lesEquipes) {
                                                if (e.getTaille() == 1 && e.getLesAthletes().contains(a)) {
                                                    pa.participer(e);
                                                    IdAInsert.remove(a.getID());
                                                    existe = true;
                                                    break;
                                                }
                                            }
                                            if (!existe) {
                                                Equipe equ = new Equipe(Equipe.getNewId(), 1);
                                                equ.participer(a);
                                                lesEquipes.add(equ);
                                                pa.participer(equ);
                                                IdAInsert.remove(a.getID());
                                            }

                                        }
                                }
                                break;
                            case "equip":
                                if (!(ligneElems[0] == "> insert"))
                                    if (ligneElems.length == 2) {
                                        try {
                                            int id = Integer.parseInt(ligneElems[0]);
                                            int taille = Integer.parseInt(ligneElems[1]);
                                            try {
                                                eq = new Equipe(id, taille);
                                            } catch (Exception x) {
                                                System.err.println(x);
                                            }
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            eq.participer(a);
                                            IdAInsert.remove(a.getID());
                                        }
                                }
                                break;
                            case "athlete":
                                if (ligneElems.length == 7) {
                                    try {
                                        int id = Integer.parseInt(ligneElems[0]);
                                        String nom = ligneElems[1];
                                        String prenom = ligneElems[2];
                                        char sexe = ligneElems[3].charAt(0);
                                        int agili = Integer.parseInt(ligneElems[4]);
                                        int endur = Integer.parseInt(ligneElems[5]);
                                        int force = Integer.parseInt(ligneElems[6]);
                                        try {
                                            at = new Athlete(id, nom, prenom, sexe, agili, endur, force);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }

                                } else
                                    System.err.println("Pas le bon insert");
                                break;
                            case "sport":
                                if (ligneElems.length == 5) {
                                    try {
                                        String nom = ligneElems[0];
                                        int nb = Integer.parseInt(ligneElems[1]);
                                        Double agili = Double.parseDouble(ligneElems[2]);
                                        Double endur = Double.parseDouble(ligneElems[3]);
                                        Double force = Double.parseDouble(ligneElems[4]);
                                        try {
                                            sp = new Sport(nom, nb, agili, endur, force);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }

                                } else if (ligneElems.length == 6) {
                                    try {
                                        String nom = ligneElems[0];
                                        int nb = Integer.parseInt(ligneElems[1]);
                                        Double agili = Double.parseDouble(ligneElems[2]);
                                        Double endur = Double.parseDouble(ligneElems[3]);
                                        Double force = Double.parseDouble(ligneElems[4]);
                                        int rec = Integer.parseInt(ligneElems[5]);
                                        try {
                                            sp = new Sport(nom, nb, agili, endur, force, rec);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }
                                } else
                                    System.err.println("Pas le bon insert");
                                break;

                            default:
                                break;
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void majListe(String prec) {
        switch (prec) {
            case "sport":
                this.lesSports.add(sp);
                break;
            case "athlete":
                this.lesAthletes.add(at);
                break;
            case "equip":
                this.lesEquipes.add(eq);
                break;
            case "pays":
                this.lesPays.add(pa);
                break;
            case "epreuve":
                this.lesEpreuves.add(ep);
                break;
            case "JO":
                this.lesJO.add(jo);
                break;
            default:
                break;
        }
    }
}\#\ */
