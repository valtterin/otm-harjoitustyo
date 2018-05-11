# Arkkitehtuurikuvaus

## Rakenne

Pakkaus muistipeli.ui sisältää JavaFX:llä toteutetun käyttöliittymän ja muistipeli.logics sovelluslogiikan. Näiden pakkauksien suhde ilmenee allaolevasta luokkakaaviosta (missä domain-pakkaus vastaa nykyistä logics-pakkausta).

![luokkakaavio](https://github.com/valtterin/otm-harjoitustyo/blob/master/Dokumentaatio/luokkapakkauskaavio-page-001.jpg)

Tämän lisäksi on olemassa pakkaukset muistipeli.gamemodes ja muistipeli.dao. Näistä jälkimmäinen pakkaus pitää sisällään tietokannan hallintaan liittyviä luokkia. Muistipeli.gamemodes pakkaus puolestaan sisältää luokkia, jotka vastaavat erilaisten pelimuotojen pelaamisesta. Kukin näistä luokista perii muistipeli.logics pakkauksesta luokan "Game". Pakkausrakenta havainnollistaa alla oleva kuva.

![pakkausrakenne](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/muistipeliPakkaus.png)


## Käyttöliittymä

Käyttöliittymä sisältää yhdeksän erilaista näkymää
 - Valitse peli -näkymä (newGameScene)
 - "Varoitus"/"Valmistaudu" -näkymä (showSymbolsScene)
 - Kuvio-näkymä jokaiselle neljästä symbolista (symbolOneScene, jne)
 - Arvuuttelu-näkymä (guessScene)
 - Loppunäkymä (endGameScene)
 - Parhaat pisteet -näkymä (scoresScene)
 - Asetukset-näkymä (settingsScene)
 
Kukin näkymä on toteuttettu Scene-olioin. Käyttäjä voi graafisessa käyttöliittymässä vaihdella asetukset-, parhaat pisteet- ja valitse peli -näkymien välillä nappuloita painamalla. Muut näkymät puolestaan tulevat esille käyttäjän aloittaessa pelin, ja tällöin käyttöliittymä vaihtelee eri näkymien välillä ui-luokan ja sovelluslogiikan määrämin tavoin. Monet näkymistä on asetettu vaihtumaan viiveellä. Esimerkiksi sovelluslogiikka määrittelee pelaajalle näytettävät kuvio-näkymät hetkessä, mutta ketjun kunkin kuvion näkymä on näkyvillä käyttäjälle puolitoista sekuntia (oletusarvoisesti).

Käyttäjän on mahdollista interaktioida sovelluksen kanssa viidessä eri näkymässä: 

- Valitse peli -näkymässä pelaaja voi valita mieluisensa pelityypin (pelityypin valitseminen päivittää sovelluslogiikkaa ja näkymää)

- Arvuuttelu-näkymässäpelaaja yrittää muistaa näkemänsä kuvio-näkymät oikeassa järjestyksessä (painamalla painikkeita oikeassa järjestyksessä). Arvuuttele-näkymä sisältää kutakin kuvio-näkymää vastaavan napin. Pelaajan painaessa nappia sovelluslogiikka vertaa painetun napin kuviota oikeaan vastaukseen, ja ohjeistaa käyttöliittymää vaihtamaan näkymää vastauksen oikeellisuudesta riippuen.

- Loppunäkymässä pelaaja voi tallentaa saamansa pistesaaliin tietokantaan.

- Asetukset näkymässä pelaaja voi muokata pelityyppien asetuksia.

- Parhaat pisteet -näkymässä käyttäjä voi puhdistaa tietokannan.



## Sovelluslogiikka

Kuten ylläolevasta (hiukan vanhasta) luokkakaaviosta käy ilmi, sovelluslogiikka koostuu pääsääntöisesit kolmesta luokasta: SymbolChain, Round, Game. SymbolChain luokka luo halutun pituisen ketjun kuvioita, joita ketjussa symbolisoivat numerot 1-4. Round luokka puolestaan vastaa pelin yhden kierroksen kulusta: Round pitää sisällään kierroksen numeroa vastaavan pituisen SymbolChainin. Game luokka vastaa yhden kokonaisen pelin pelaamisesta, ja yksi peli koostuu useasta Round:sta (vaikkakin vain yhdestä kerralla).

Ohjelman nykyisessä versiossa erilaisia pelivariaaioita vastaavat luokat EasyGame, BlindGame ja ReverseGame. Kukin luokka käyttää pohjanaan Game-luokkaa, josta pelivaariaation kannalta väärät metodit on ylikirjoitettu (@Override).

Alla on sekvenssikaavio, joka kuvaa sovelluksen toimintaa ja luokkien välistä yhteyttä käyttäjän painaessa käyttöliittymässä "Normaali peli" -painiketta.

![sekvenssikaavio](https://raw.githubusercontent.com/valtterin/otm-harjoitustyo/master/Dokumentaatio/sekvenssikaavio-page-001.jpg)


## Tietojen pysyväistallennus

Tietojen pysyväistalletuksesta vastaavat luokat paketissa muistipeli.dao. Luokka Score pitää sisällään yhden pistesaaliin talletukseen tarvittavat tiedot. Luokka ScoreDao puolestaan huolehtii eri pistesaldojen tallentamisesta tietokantaan, ja parhaimpien pisteiden etsimisestä tietokannasta. Luokka Database luo itse tietokannan, ja korvaa sen uudella tietokannalla käyttäjän näin halutessa.




