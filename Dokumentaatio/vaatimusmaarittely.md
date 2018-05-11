# Muistipeli - Vaatimusmäärittely

### Sovelluksen idea

Sovellus on peli, joka pistää pelaajan muistin koetukselle. Pelaajalle näytetään kasvavassa määrin pitenevä ketju kuvioita, ja pelaajan tulee 
syöttää näkemänsä kuviot oikeassa järjetyksessä päästäkseen seuraavalle kierrokselle.


### Pelin kulku:

- Pelaajan painaessa Start-painiketta, peli käynnistyy alusta (kierros 1).

Kierros 1:
- Peli näyttää pelaajalle ensin yhden satunnaisen kuvion hetken ajan, minkä jälkeen kuvio piilotetaan.
- Peli kysyy pelaajalta minkä kuvion hän juuri näki, ja peli tarjoaa neljä eri vaihtoehtoa, joista pelaajan tulee valita oikea.
- Jos pelaaja valitsee väärin, peli loppuu välittömästi: Peli päättyi, pisteet: 0.
- Jos pelaaja valitsee oikein, pelaajan pistemäärä kasvaa yhdellä, ja pelaaja pääsee seuraavalle kierrokselle.

Kierros X:
- Peli näyttää pelaajalle ensin yhden satunnaisen kuvion hetken ajan, minkä jälkeen kuvio piilotetaan.
- Peli näyttää seuraavaksi pelaajalle uuden satunnaisen kuvion hetken ajan, minkä jälkeen kuvio piilotetaan.
- Peli näyttää samaan tapaan kuvioita peräjälkeen, kunnes kuvioita on näytetty yhteensä kierrosta vastaava lukumäärä (X).
- Tämän jälkeen peli kysyy pelaajalta, mikä oli ensimmäinen kuvio, jonka hän näki. Peli tarjoaa pelaajalle neljä eri vaihtoehtoa, joista pelaajan tulee valita oikea.
- Jos pelaaja valitsee väärin, peli loppuu välittömästi, ja pelaajan pistesaldo on kokonaisuudessaan siihen asti oikein muistettujen kuvioiden summa.
- Jos pelaaja valitsee oikein, pelaajan pistemäärä kasvaa yhdellä, ja peli tiedustelee pelaajalta, mikä oli ketjun seuraava kuvio.
- Tähän tapaan peli käy lävitse ketjun kaikki kuviot järjestyksessä. Peli päättyy, jos pelaaja arvaa väärin. Mikäli pelaaja muistaa kaikki kuviot oikein, pelaaja 
pääsee seuraavalle kierrokselle (X+1).

Perusversiossa erilaisia mahdollisia kuvioita on kokonaisuudessaan neljä. Toisin sanoen pelaajalle tarjotut neljä vaihtoehtoa ovat aina samat. Perus-pelissä ei ole erilaisia käyttäjiä. 

Pelissä on neljä eri pelimuotoa, joista pelaaja voi käyttöliittymästä valita mieleisensä. "Normaali" pelimuoto vastaa yllä kuvattua, "Helppo" pelimuoto säilyttää vanhan osan kuvioketjua läpi kierrosten samana, "Sokko" pelimuodossa pelaajalle näytetään vain uusin symboli, ja "Reverse" pelimuodossa pelaajan tulee syöttää näkemänsä kuviot päinvastaisessa järjestyksessä. Käyttäjän on myös mahdollista "asetukset" välilehdellä muuttaa pelimuotoja mieleisikseen. Esimerkiksi pelin nopeutta ja muistettavien kuvioiden määrää on mahdollista muuttaa.

Sovellus tallentaa pelin päätteeksi pisteet (ja nimimerkin ja pelimuodon) tietokantaan käyttäjän näin halutessa.

Pelissä on graafinen käyttöliittymä, joka pelin kuluessa näyttää käyttäjälle kuvio-ketjun kuviot. Käyttäjä voi myös graafisen käyttöliittymän kautta kertoa pelille muistamansa symbolit järjestyksessä. Graafinen käyttöliittymä pitää sisällään myös "Menun", josta käyttäjä voi valita mieleisensä pelimuodon, "Asetukset"-välilehden, josta pelaaja voi muuttaa pelin asetuksia, ja "Parhaat pisteet" välilehden, josta pelaaja voi tarkastaa parhaat ansaitsemansa pisteet.



## Jatkokehitysideat

- Kattavampi tietokanta ja kattavampi "parhaat pisteet" välilehti
  - tietokantaan voitaisiin tallentaa, millä asetuksilla talletettava pistemäärä ansaittiin
  - "parhaat pisteet" -välilehteä voitaisiin päivittii listaamaan kunkin pelimuodon 10 parhainta tulosta
  - "parhaat pisteet" -välilehdelle hakutoiminto, jolla voitaisiin hakea eri asetuksilla saatuja tuloksia

- Uusia erilaisia variaatioita peruspelistä (ja käyttöliittymään mahdollisuus valita haluamansa variaatio). Esimerkiksi:
   - Aika rajoite
   - Enemmän kuin neljä kuviota
   - Kuvioiden kesto ruudulla lyhenee kierros kierrokselta

- Käyttäjät
  - Pelaaja voi luoda itselleen normaalin käyttäjätunnuksen käyttöliittymässä
  - Pelaaja voi kirjautua sisään/ulos käyttöliittymässä
  - Pelaaja voi käyttöliittymässä nähdä tunnuksensa henkilökohtaiset parhaat pisteensä
  - Normaalin käyttäjätunnuksen nimimerkkiä käytetään automaattisesti "Parhaat pisteet" -listalla
  - Ylläpitäjän käyttäjätunnus, jolla voi poistaa normaalien käyttäjien tunnuksia ja pisteitä "Parhaat pisteet" -listalta
  

