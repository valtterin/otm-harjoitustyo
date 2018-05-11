# Testausdokumentti

Sovelluksen automaattiset testit SymbolChainTest, RoundTest ja GameTest testaavat sovelluslogiikkaa, josta vastaavat luokat pakkauksessa muistipeli.logics. SymbolChainTest testaa vain luokkaa SymbolChain. Round puolestaan käyttää SymbolChaineja oleellisena osana toimintaansa, joten RoundTest testaa epäsuorasti myös SymbolChainin toimintaa. Vastaavasti GameTest testaa Game- ja Round-luokkien toimintaa.

Luokka ScoreDaoTest testaa tietokannan toimintaa (luokat paketissa muistipeli.dao), vaikkeikaan kovin laajasti. ScoreDaoTest sisältää tällä hetkellä vain yhden testin, mutta kyseinen testi testaa yhdellä kertaa kaikkien muistipeli.dao paketista löytyvien luokkien toimintaa, koska ScoreDao:n metodi saveScore() käyttää kaikkia paketista löytyviä luokkia jossain muodossa.


## Manuaalinen testaus

Sovelluksen graafista käyttöliittymää on testattu laajasti manuaalisesti, ja testauksen aikana kohdatut ongelmat on oikaistu. Tällä hetkellä tiedossa ei ole oikaisemattomia ongelmia.


## Jatkokehitysidea

Tällä hetkellä symboliketju koostuu satunnaisesti numeroista väliltä 1-4. Tämä tekee joidenkin luokkien toiminnallisuuden testaamisesta haastavaa. Tulevaisuuden varalta voitaisiin SymbolChain ja Round luokkiin lisätä metodeita, joilla voitaisiin testaustarkoitusta varten luoda jokin vakio symboliketju.
