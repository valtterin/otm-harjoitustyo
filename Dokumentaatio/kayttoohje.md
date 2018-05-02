# Käyttöohje

Lataa tiedosto [muistipeli.jar](https://github.com/mluukkai/OtmTodoApp/releases/tag/0.1). Ohjelma käynnistetään komennolla 

```
java -jar todoapp.jar
```
![kuvio](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje1.2.png)

## Kuvaus

Ohjelma on peli, joka testaa pelaajan muistia. Perus-pelissä käyttäjälle näytetään kuvio kerrallaan ketju kuvioita. Käyttäjän nähtyä kuviot, tämän tulee muistaa näkemänsä kuviot oikeassa järjestyksessä.

![painikkeet](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/ohje2.png)


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
