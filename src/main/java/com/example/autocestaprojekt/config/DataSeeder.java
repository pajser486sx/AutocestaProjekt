package com.example.autocestaprojekt.config;

import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.model.Tollbooth;
import com.example.autocestaprojekt.repository.RoadRepository;
import com.example.autocestaprojekt.repository.TollboothRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoadRepository roadRepository;
    private final TollboothRepository tollboothRepository;

    public DataSeeder(RoadRepository roadRepository, TollboothRepository tollboothRepository) {
        this.roadRepository = roadRepository;
        this.tollboothRepository = tollboothRepository;
    }

    @Override
    public void run(String... args) {

        if (roadRepository.count() > 0) {
            return;
        }

        Map<Road.Oznaka, String> roadNames = Map.ofEntries(
                Map.entry(Road.Oznaka.A1, "Zagreb-Split-Dubrovnik"),
                Map.entry(Road.Oznaka.A2, "Zagreb-Macelj"),
                Map.entry(Road.Oznaka.A3, "Bregana-Zagreb-Lipovac"),
                Map.entry(Road.Oznaka.A4, "Goričan-Zagreb"),
                Map.entry(Road.Oznaka.A5, "Beli Manastir-Osijek-Svilaj"),
                Map.entry(Road.Oznaka.A6, "Bosiljevo-Rijeka"),
                Map.entry(Road.Oznaka.A7, "Rupa-Rijeka-Žuta Lokva"),
                Map.entry(Road.Oznaka.A8, "Istarski ipsilon"),
                Map.entry(Road.Oznaka.A9, "Istarski ipsilon"),
                Map.entry(Road.Oznaka.A10, "Nova Sela-Ploče"),
                Map.entry(Road.Oznaka.A11, "Zagreb-Sisak")
        );

        Map<Road.Oznaka, List<String>> data = Map.ofEntries(
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
                        "Trakošćan", "Đurmanec", "Krapina", "Začretje",
                        "Mokrice", "Zaprešić"
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
                        "Varaždinske toplice", "Novi Marof",
                        "Breznički Hum", "Komin", "Sveta Helena"
                )),

                Map.entry(Road.Oznaka.A5, List.of(
                        "Osijek", "Čepin", "Đakovo", "ČCP Svilaj"
                )),

                Map.entry(Road.Oznaka.A6, List.of(
                        "Vrbovsko", "Ravna gora", "Delnice",
                        "Vrata", "Oštrovica", "Rijeka"
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
                        "Umag", "Buje", "Nova Vas",
                        "Višnjan", "Baderna", "Medaki",
                        "Kanfanar", "Vodnjan Sjever", "Vodnjan Jug", "Pula"
                )),

                Map.entry(Road.Oznaka.A10, List.of(
                        "Čarapine"
                )),

                Map.entry(Road.Oznaka.A11, List.of(
                        "Mraclin", "Buševec", "Lekenik"
                ))
        );

        data.forEach((oznaka, tollboothNames) -> {

            Road road = new Road();
            road.setOznaka(oznaka);
            road.setIme(roadNames.get(oznaka));

            Road savedRoad = roadRepository.save(road);

            tollboothNames.forEach(tollboothName -> {
                Tollbooth tollbooth = new Tollbooth();
                tollbooth.setIme(tollboothName);
                tollbooth.setRoad(savedRoad);

                tollboothRepository.save(tollbooth);
            });
        });
    }
}
