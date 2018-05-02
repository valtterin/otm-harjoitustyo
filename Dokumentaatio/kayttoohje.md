# Käyttöohje

Lataa tiedosto [MuistipeliV2.jar]([Release 2 (viikko 6)](https://github.com/valtterin/otm-harjoitustyo/releases/tag/viikko6Final)). Ohjelma käynnistetään komennolla 

```
java -jar MuistipeliV2.jar
```

## Kuvaus

Ohjelma on peli, joka testaa pelaajan muistia. Perus-pelissä käyttäjälle näytetään kuvio kerrallaan ketju kuvioita. Käyttäjän nähtyä kuviot, tämän tulee muistaa näkemänsä kuviot oikeassa järjestyksessä.

![](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje1.2.png) ![](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje2.png)





Pelaajan on mahdollista valita pelinsä neljästä eri pelimuodosta:

![pelimuodot](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje1.png)

- Normal game - 
Kuvio-ketju koostuu neljästä erityyppisestä kuviosta. Pelaajan muistettua kierroksen kuviot oikein, pelaajalle näytetään täysin uusi kuvio-ketju, jonka pituus on edellistä yhdempi isompi.

- Easy game - 
Muuten kuin Normal game, paitsi muistettava kuvio-ketju säilyy läpi kierrosten samana. Vain ketjun pituus kasvaa kunkin kierroksen päätteeksi yhdellä!

- Blind game - 
Muuten kuin Easy game, paitsi käyttäjä näkee kunkin kierroksen alussa vain ketjun uusimman kuvion!

- Reverse game - 
Muuten kuin Normal game, paitsi käyttäjän tulee muistaa näkemänsä symbolit päinvastaisessa järjestyksessä!
