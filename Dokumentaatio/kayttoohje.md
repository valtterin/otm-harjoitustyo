# Käyttöohje

Lataa tiedosto [MuistipeliV2.jar](https://github.com/valtterin/otm-harjoitustyo/releases/tag/viikko6Final). Ohjelma käynnistetään komennolla 

```
java -jar MuistipeliV2.jar
```

## Kuvaus

Ohjelma on peli, joka testaa pelaajan muistia. Perus-pelissä käyttäjälle näytetään kuvio kerrallaan ketju kuvioita. Käyttäjän nähtyä kuviot, tämän tulee muistaa näkemänsä kuviot oikeassa järjestyksessä.

![](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje1.2.png) ![](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje2.png)


_________

Pelaajan on mahdollista valita pelinsä neljästä eri pelimuodosta:


- Normaali - 
Kuvio-ketju koostuu neljästä erityyppisestä kuviosta. Pelaajan muistettua kierroksen kuviot oikein, pelaajalle näytetään täysin uusi kuvio-ketju, jonka pituus on edellistä yhdempi isompi.

- Helppo - 
Muuten kuin Normaali peli, paitsi muistettava kuvio-ketju säilyy läpi kierrosten samana. Vain ketjun pituus kasvaa kunkin kierroksen päätteeksi yhdellä!

- Sokko - 
Muuten kuin Helppo peli, paitsi käyttäjä näkee kunkin kierroksen alussa vain ketjun uusimman kuvion!

- Reverse game - 
Muuten kuin Normaali peli, paitsi käyttäjän tulee muistaa näkemänsä symbolit päinvastaisessa järjestyksessä!

_________

Pelaajan on myös mahdollista muuttaa pelin asetuksia haluamikseen "Asetukset" -valikosta.

- Aloituskierros - 
Pelaaja voi asettaa itselleen haluamansa aloituskierroksen, jolloinka peli alkaa suoraan valitusta kierroksesta. Huomioitavaa on, että aloituskierroksella näytettävien kuvioiden määrä on aloituskierroksen numeron ja "Vaikeusasteen" tulo.

- Vaikeusaste - 
Vaikeuaste määrittää, kuinka monella kuviolla kuvioketju kasvaa jokaisen kierroksen alussa. Vaikeuasteen ollessa nolla, kuvioiden lukumäärä ei kasva ollenkaan: ketjun pituus vastaa tällöin aina aloituskierroksen numeroa.

- Kuvioiden kesto -
Kuvioiden kesto määrittää, kuinka pitkän aikaa kukin kuvio näytetään pelaajalle. Luku on millisekunteina.

- Varoituksen kesto - 
Varoituksen kesto määrittää, kuinka kauan jokaisen kierroksen alussa näkyvä "Kierros X! Valmistaudu!" -varoitus on näkyvissä pelaajalle.

- Default -
Palauttaa oletusarvoiset asetukset.

_________

Kunkin pelin päätteeksi pelaajalta kysytään, mikäli hän haluaa tallentaa pisteensä tietokantaan. Pelaajan tulee syöttää nimimerkki, joka koostuu vain kirjaimista, ja on enintään 10 kirjaimen pituinen.

