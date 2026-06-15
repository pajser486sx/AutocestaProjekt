package com.example.autocestaprojekt.validation;

import com.example.autocestaprojekt.model.Road;

import java.util.List;
import java.util.Map;

public class TollboothValidator {

    private static final Map<Road.Oznaka, List<String>> VALID_TOLLBOOTHS =
            Map.ofEntries(
                    Map.entry(Road.Oznaka.A1, List.of(
                            "Zagreb Lučko", "Donja Zdenčina", "Jastrebarsko", "Karlovac",
                            "Novigrad", "Bosiljevo", "Ogulin", "Brinje", "Žuta lokva",
                            "Otočac", "Perušić", "Gospić", "Gornja Ploča", "Sveti Rok",
                            "Maslenica", "Posedarje", "Zadar Zapad", "Benkovac",
                            "Pirovac", "Skradin", "Šibenik", "Podi", "Vrpolje",
                            "Prgomet", "Vučevica", "Dugopolje", "Bisko",
                            "Blato na Cetini", "Šestanovac", "Zagvozd",
                            "Ravča", "Vrgorac", "Karamatići"
                    )),

                    Map.entry(Road.Oznaka.A2, List.of(
                            "Trakošćan", "Đurmanec", "Krapina", "Začretje", "Mokrice", "Zaprešić"
                    )),

                    Map.entry(Road.Oznaka.A3, List.of(
                            "Bregana", "Zagreb istok", "Ivanić Grad", "Križ",
                            "Popovača", "Kutina", "Lipovljani", "Novska",
                            "Okučani", "Nova Gradiška", "Lužani",
                            "Slavonski Brod zapad", "Slavonski Brod istok",
                            "Velika Kopanica", "Babina greda",
                            "Županja", "Spačva", "Lipovac"
                    )),

                    Map.entry(Road.Oznaka.A4, List.of(
                            "Goričan", "Čakovec", "Ludbreg", "Varaždin",
                            "Varaždinske toplice", "Novi Marof", "Breznički Hum", "Komin", "Sveta Helena"
                    )),

                    Map.entry(Road.Oznaka.A5, List.of(
                            "Osijek", "Čepin", "Đakovo", "ČCP Svilaj"
                    )),

                    Map.entry(Road.Oznaka.A6, List.of(
                            "Vrbovsko", "Ravna gora", "Delnice", "Vrata", "Oštrovica", "Rijeka"
                    )),

                    Map.entry(Road.Oznaka.A7, List.of(
                            "Rupa"
                    )),

                    Map.entry(Road.Oznaka.A8, List.of(
                            "Tunel Učka", "Vranja", "Lupoglav",
                            "Cerovlje", "Ivoli", "Rogovići",
                            "Žminj", "Kanfanar", "Vodnjan Sjever",
                            "Vodnjan Jug", "Pula"
                    )),

                    Map.entry(Road.Oznaka.A9, List.of(
                            "Umag", "Buje", "Nova Vas", "Višnjan", "Baderna", "Medaki"
                    )),

                    Map.entry(Road.Oznaka.A10, List.of(
                            "Čarapine"
                    )),

                    Map.entry(Road.Oznaka.A11, List.of(
                            "Mraclin", "Buševec", "Lekenik"
                    ))
            );

    public static boolean isValidTollboothForRoad(Road.Oznaka oznaka, String tollboothName) {
        return VALID_TOLLBOOTHS.containsKey(oznaka)
                && VALID_TOLLBOOTHS.get(oznaka).contains(tollboothName);
    }
}