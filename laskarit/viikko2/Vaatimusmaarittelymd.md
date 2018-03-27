# Muistipeli - Vaatimusmäärittely

### Sovelluksen idea

Sovellus on peli, joka pistää pelaajan muistin koetukselle. Pelaajalle näytetään kasvavassa määrin pitenevä ketju symboleja, ja pelaajan tulee 
syöttää näkemänsä symbolit oikeassa järjetyksessä päästäkseen seuraavalle kierrokselle.


### Pelin kulku:

- Pelaajan painaessa Start-painiketta, peli käynnistyy alusta (kierros 1).

Kierros 1:
- Peli näyttää pelaajalle ensin yhden satunnaisen symbolin hetken ajan, minkä jälkeen symboli piilotetaan.
- Peli kysyy pelaajalta minkä symbolin hän juuri näki, ja peli tarjoaa neljä eri vaihtoehtoa, joista pelaajan tulee valita oikea.
- Jos pelaaja valitsee väärin, peli loppuu välittömästi: Game over, score: 0.
- Jos pelaaja valitsee oikein, pelaajan pistemäärä kasvaa yhdellä, ja pelaaja pääsee seuraavalle kierrokselle.

Kierros X:
- Peli näyttää pelaajalle ensin yhden satunnaisen symbolin hetken ajan, minkä jälkeen symboli piilotetaan.
- Peli näyttää seuraavaksi pelaajalle uuden satunnaisen symbolin hetken ajan, minkä jälkeen symboli piilotetaan.
- Peli näyttää samaan tapaan symboleita peräjälkeen, kunnes symboleita on näytetty yhteensä kierrosta vastaava lukumäärä (X).
- Tämän jälkeen peli kysyy pelaajalta, mikä oli ensimmäinen symboli, jonka hän näki. Peli tarjoaa pelaajalle neljä eri vaihtoehtoa, joista pelaajan tulee valita oikea.
- Jos pelaaja valitsee väärin, peli loppuu välittömästi, ja pelaajan pistesaldo on kokonaisuudessaan siihen asti oikein muistettujen symboleiden summa.
- Jos pelaaja valitsee oikein, pelaajan pistemäärä kasvaa yhdellä, ja peli tiedustelee pelaajalta, mikä oli ketjun seuraava symboli.
- Tähän tapaan peli käy lävitse ketjun kaikki symbolit järjestyksessä. Peli päättyy, jos pelaaja arvaa väärin. Mikäli pelaaja muistaa kaikki symbolit oikein, pelaaja 
pääsee seuraavalle kierrokselle (X+1).

Perusversiossa erilaisia mahdollisia symboleita on kokonaisuudessaan neljä. Toisin sanoen pelaajalle tarjotut neljä vaihtoehtoa ovat aina samat. Perus-pelissä ei tule olemaan käyttäjiä, mutta eri tyyppisiä käyttäjiä voitaisiin lisätä pelin kehittymisen yhteydessä. 



## Jatkokehitysideat

- Graafinen käyttöliittymä
  - valikko: uusi peli, parhaat pisteet, (ja mahdollisesti ynnä muu alla-oleva)
  - peli itse: käyttäjä voi hiirellä klikkailla pelin tarjoamia symboli-vaihtoehtoja
   
- "Parhaat pisteet" -tietokanta
   - pelin päätyttyä pelaaja voi syöttää nimimerkkinsä, mikäli hänen pisteensä kelpuuttavat hänet "Parhaat pisteet" -listalle

- Erilaisia variaatioita peruspelistä (ja käyttöliittymään mahdollisuus valita haluamansa variaatio). Esimerkiksi:
   - Aika rajoite
   - Enemmän kuin neljä symbolia
   - Symboli-ketju säilyy läpi kierrosten samana, mutta siihen lisätään jokaisella kierroksella uusi symboli.
   - "Sokko" versio edellisestä: Vain uusin symboli näytetään pelaajalle uudella kierroksella, mutta pelaajan pitää muistaa & syöttää myös kaikki edelliset symbolit

- Käyttäjät
  - Pelaaja voi luoda itselleen normaalin käyttäjätunnuksen käyttöliittymässä
  - Pelaaja voi kirjautua sisään/ulos käyttöliittymässä
  - Pelaaja voi käyttöliittymässä nähdä henkilökohtaiset parhaat pisteensä
  - Normaalin käyttäjätunnuksen nimimerkkiä käytetään automaattisesti "Parhaat pisteet" -listalla
  - Ylläpitäjän käyttäjätunnus, jolla voi poistaa normaalien käyttäjien tunnuksia ja pisteitä "Parhaat pisteet" -listalta
  

